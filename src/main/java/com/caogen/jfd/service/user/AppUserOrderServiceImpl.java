package com.caogen.jfd.service.user;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.dao.user.AppUserOrderDao;
import com.caogen.jfd.dao.user.ConfigDao;
import com.caogen.jfd.dao.user.VehicleModelDao;
import com.caogen.jfd.dao.user.VehiclePriceDao;
import com.caogen.jfd.entity.user.AppUserOrder;
import com.caogen.jfd.entity.user.AppUserOrder.Label;
import com.caogen.jfd.entity.user.AppUserOrder.Mode;
import com.caogen.jfd.entity.user.AppUserSite;
import com.caogen.jfd.entity.user.SysConfig;
import com.caogen.jfd.entity.user.VehicleModel;
import com.caogen.jfd.entity.user.VehiclePrice;
import com.caogen.jfd.model.Distance;
import com.caogen.jfd.model.Distance.Result;
import com.caogen.jfd.util.FormatUtils;
import com.caogen.jfd.util.HttpClientUtils;
import com.caogen.jfd.util.PasswordHelper;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class AppUserOrderServiceImpl implements AppUserOrderService {
	@Autowired
	private AppUserOrderDao orderDao;
	@Autowired
	private VehiclePriceDao priceDao;
	@Autowired
	private VehicleModelDao modelDao;
	@Autowired
	private ConfigDao configDao;

	@Override
	public void create(AppUserOrder entity) {
		entity.setCreate_date(LocalDateTime.now());
		if (entity.getMode().equals(Mode.appoint)) {
			entity.setAppoint_date(FormatUtils.strToDateTime(entity.getAppointDate()));
		}
		entity.setCode(PasswordHelper.generateNumber());
		entity.setStatus(0);
		entity.setLabel(Label.none);
		orderDao.insert(entity);
	}

	@Override
	public void remove(AppUserOrder entity) {
		orderDao.delete(entity);
	}

	@Override
	public void modify(AppUserOrder entity) {
		orderDao.update(entity);
	}

	@Override
	public AppUserOrder getById(Integer id) {
		return orderDao.get(new AppUserOrder(id));
	}

	@Override
	public Integer count(AppUserOrder entity) {
		int a = orderDao.countInfo(entity);
		int b = orderDao.countHistory(entity);
		return a + b;
	}

	@Override
	public List<AppUserOrder> getUnderway(AppUserOrder entity) {
		return orderDao.findUnderway(entity);
	}

	@Override
	public List<AppUserOrder> getFinish(AppUserOrder entity) {
		return orderDao.findFinish(entity);
	}

	@Override
	public int getDistance(AppUserSite origin, AppUserSite[] destination) {
		// 高德地图测量距离接口参数
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", Constants.GD_KEY);
		map.put("type", Constants.GD_DISTANCE_TYPE);
		// 处理参数
		List<AppUserSite> list = new ArrayList<AppUserSite>();
		List<AppUserSite> newList = new ArrayList<AppUserSite>();
		newList.add(origin);
		list.addAll(Arrays.asList(destination));
		int distance = 0;
		while (!list.isEmpty()) {
			AppUserSite site = newList.get(newList.size() - 1);
			map.put("destination", site.getLongitude() + "," + site.getLatitude());
			StringBuffer sb = new StringBuffer();
			for (AppUserSite item : list) {
				sb.append(item.getLongitude()).append(",");
				sb.append(item.getLatitude()).append("|");
			}
			map.put("origins", sb.toString());
			String result = HttpClientUtils.doGet(Constants.GD_DISTANCE_URL, map);
			Distance dis = Constants.gson.fromJson(result, Distance.class);
			List<Result> results = dis.getResults();
			Collections.sort(results);
			Result near = results.get(0);
			int index = Integer.parseInt(near.getOrigin_id()) - 1;
			distance += Integer.parseInt(near.getDistance());
			newList.add(list.remove(index));
		}
		// 排序后的地点
		// return newList;
		return distance;
	}

	@Override
	public AppUserOrder getPrice(AppUserOrder order, int distance) {
		double price = 0.0;// 订单金额
		int model_id = order.getModel_id();
		VehicleModel vm = modelDao.get(new VehicleModel(model_id));
		SysConfig jam = configDao.get(new SysConfig("traffic_jam_period"));
		SysConfig night = configDao.get(new SysConfig("night_service_period"));
		// 判断时间
		switch (order.getMode()) {
		case common:// 实时订单
			order.setTraffic_jam_cost(jam.getFlag() ? vm.getJam_cost() : 0.0);
			order.setNight_service_cost(night.getFlag() ? vm.getNight_cost() : 0.0);
			break;
		case appoint:// 预约订单
			LocalTime time = FormatUtils.strToDateTime(order.getAppointDate()).toLocalTime();
			// 高峰期加价
			if (time.isAfter(jam.getStart_time()) && time.isBefore(jam.getEnd_time())) {
				order.setTraffic_jam_cost(vm.getJam_cost());
			} else {
				order.setTraffic_jam_cost(0.0);
			}
			// 夜间服务费
			if (time.isAfter(night.getStart_time()) && time.isBefore(night.getEnd_time())) {
				order.setNight_service_cost(vm.getNight_cost());
			} else {
				order.setNight_service_cost(0.0);
			}
			break;
		default:
			throw new RuntimeException("订单模式错误");
		}
		// 获取分段价格列表
		VehiclePrice entity = new VehiclePrice();
		entity.setModel_id(model_id);
		List<VehiclePrice> list = priceDao.find(entity);
		double gap = 0.0;
		switch (order.getType()) {
		case single:// 单点订单
			double startPrice = list.get(0).getPrice();
			for (int i = 1; i < list.size(); i++) {
				if (distance >= list.get(i).getEnd_space()) {
					gap = list.get(i).getEnd_space() - list.get(i).getStart_space();
				} else if (distance < list.get(i).getStart_space()) {
					break;
				} else {
					gap = distance - list.get(i).getStart_space();
				}
				price += gap * (list.get(i).getPrice() + order.getTraffic_jam_cost());
			}
			price += startPrice;
			break;
		case multiple:// 多点订单
			for (VehiclePrice item : list) {
				if (distance >= item.getEnd_space()) {
					gap = item.getEnd_space() - item.getStart_space();
				} else if (distance < item.getStart_space()) {
					break;
				} else {
					gap = distance - item.getStart_space();
				}
				price += gap * (item.getPrice() + order.getTraffic_jam_cost());
			}
			break;
		default:
			throw new RuntimeException("订单类型错误");
		}
		order.setOrder_money(price);
		order.setKilometre(distance * 0.001);
		return order;
	}

	@Override
	public AppUserOrder getOne(AppUserOrder entity) {
		AppUserOrder order = orderDao.getUnderway(entity);
		if (order == null) {
			order = orderDao.getFinish(entity);
		}
		order.setCreateDate(FormatUtils.dateToStr(order.getCreate_date()));
		if (order.getMode().equals(Mode.appoint)) {
			order.setAppointDate(FormatUtils.dateToStr(order.getAppoint_date()));
		}
		return order;
	}

}
