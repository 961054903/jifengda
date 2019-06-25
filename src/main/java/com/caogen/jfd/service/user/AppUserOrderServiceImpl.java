package com.caogen.jfd.service.user;

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
import com.caogen.jfd.dao.user.VehiclePriceDao;
import com.caogen.jfd.entity.user.AppUserOrder;
import com.caogen.jfd.entity.user.AppUserOrder.Type;
import com.caogen.jfd.entity.user.AppUserSite;
import com.caogen.jfd.entity.user.VehiclePrice;
import com.caogen.jfd.model.Distance;
import com.caogen.jfd.model.Distance.Result;
import com.caogen.jfd.util.HttpClientUtils;

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

	@Override
	public void create(AppUserOrder entity) {
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
	public double getPrice(AppUserOrder order, int distance) {
		int model_id = order.getModel_id();
		Type type = order.getType();
		double cost = 0.0;
		VehiclePrice entity = new VehiclePrice();
		entity.setModel_id(model_id);
		List<VehiclePrice> list = priceDao.find(entity);
		double price = 0.0;
		double gap = 0.0;
		switch (type) {
		case single:
			// 单点订单，获取起步价、起步距离
			double startSpace = list.get(0).getStart_space();
			double startPrice = list.get(0).getPrice();
			for (int i = 1; i < list.size(); i++) {
				if (distance >= list.get(i).getEnd_space()) {
					gap = list.get(i).getEnd_space() - list.get(i).getStart_space();
				} else if (distance < list.get(i).getStart_space()) {
					break;
				} else {
					gap = distance - list.get(i).getStart_space();
				}
				price += gap * (list.get(i).getPrice() + cost);
			}
			price += startPrice;
			break;
		case multiple:
			for (VehiclePrice item : list) {
				if (distance >= item.getEnd_space()) {
					gap = item.getEnd_space() - item.getStart_space();
				} else if (distance < item.getStart_space()) {
					break;
				} else {
					gap = distance - item.getStart_space();
				}
				price += gap * (item.getPrice() + cost);
			}
			break;
		default:
			break;
		}
		return price;
	}

}
