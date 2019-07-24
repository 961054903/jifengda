package com.caogen.jfd.service.impl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.dao.user.AppUserOrderDao;
import com.caogen.jfd.dao.user.VehiclePriceDao;
import com.caogen.jfd.entity.AppUserOrder;
import com.caogen.jfd.entity.AppUserSite;
import com.caogen.jfd.entity.VehiclePrice;
import com.caogen.jfd.entity.VehiclePrice.Price;
import com.caogen.jfd.model.Distance;
import com.caogen.jfd.model.Distance.Result;
import com.caogen.jfd.service.AppUserOrderService;
import com.caogen.jfd.util.HttpClientUtils;
import com.caogen.jfd.util.PasswordHelper;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class OrderServiceImpl implements AppUserOrderService {
	@Autowired
	private AppUserOrderDao orderDao;
	@Autowired
	private VehiclePriceDao priceDao;

	@Override
	public void create(AppUserOrder entity) {
		// 获取提成比例并计算提成
		VehiclePrice vp = new VehiclePrice();
		vp.setCity(entity.getCity());
		vp.setModel_id(entity.getModel_id());
		Double bonus = priceDao.get(vp).getBonus();
		entity.setBonus(bonus * entity.getActually_paid() * 0.01);
		// 设置默认参数
		entity.setCreate_date(LocalDateTime.now());
		entity.setCode(PasswordHelper.generateNumber());
		entity.setStatus(Constants.ORDER_STATUS_PAYMENT);
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
	public AppUserOrder getOne(AppUserOrder entity) {
		AppUserOrder order = orderDao.getUnderway(entity);
		if (order == null) {
			order = orderDao.getFinish(entity);
		}
		return order;
	}

	@Override
	public void evaluate(AppUserOrder entity) {
		entity.setIs_evaluate(true);
		orderDao.evaluate(entity);
	}

	@Override
	public void calculateDistance(AppUserOrder order) {
		AppUserSite origin = Constants.gson.fromJson(order.getOrigin(), AppUserSite.class);
		AppUserSite[] destination = Constants.gson.fromJson(order.getDestination(), AppUserSite[].class);
		Map<String, String> map = new HashMap<String, String>();
		// 高德地图测量距离接口参数
		map.put("key", Constants.GD_KEY);
		map.put("type", Constants.GD_DISTANCE_TYPE);
		// 高德地图目的地（发货地点）
		map.put("destination", origin.getLongitude() + "," + origin.getLatitude());
		StringBuffer sb = new StringBuffer();
		for (AppUserSite item : destination) {
			sb.append(item.getLongitude()).append(",");
			sb.append(item.getLatitude()).append("|");
		}
		// 高德地图出发点（多个，收货地点）
		map.put("origins", sb.toString());
		// 调用高德地图接口，获取返回值，按距离由近到远排序
		String result = HttpClientUtils.doGet(Constants.GD_DISTANCE_URL, map);
		Distance dis = Constants.gson.fromJson(result, Distance.class);
		List<Result> results = dis.getResults();
		Collections.sort(results);
		// 排序后放入集合
		List<AppUserSite> list = new ArrayList<AppUserSite>();
		list.add(origin);
		for (Result item : results) {
			list.add(destination[Integer.valueOf(item.getOrigin_id()) - 1]);
		}
		// 每两个地点计算一次距离，累加
		sb = new StringBuffer();
		int distance = 0;
		for (int i = 0; i < list.size() - 1; i++) {
			map.put("origins", list.get(i).getLongitude() + "," + list.get(i).getLatitude());
			map.put("destination", list.get(i + 1).getLongitude() + "," + list.get(i + 1).getLatitude());
			result = HttpClientUtils.doGet(Constants.GD_DISTANCE_URL, map);
			dis = Constants.gson.fromJson(result, Distance.class);
			String gap = dis.getResults().get(0).getDistance();
			sb.append(gap).append("|");
			distance += Integer.valueOf(gap);
		}
		list.remove(0);
		order.setDestination(Constants.gson.toJson(list));
		order.setGap(sb.toString());
		order.setKilometer(distance * 0.001);
	}

	@Override
	public void calculatePrice(AppUserOrder order) {
		Double distance = order.getKilometer();
		// 获取价格
		VehiclePrice entity = new VehiclePrice();
		entity.setCity(order.getCity());
		entity.setModel_id(order.getModel_id());
		VehiclePrice vp = priceDao.get(entity);
		// 根据订单模式获取订单时间
		LocalTime time = null;
		switch (order.getMode()) {
		case common:// 实时订单
			time = LocalTime.now();
			break;
		case appoint:// 预约订单
			time = order.getAppoint_date().toLocalTime();
			break;
		}
		// 夜间服务费
		if (vp.getIs_night() || time.isAfter(vp.getNight_start()) && time.isBefore(vp.getNight_end())) {
			order.setNight_cost(vp.getNight_cost());
		} else {
			order.setNight_cost(0.0);
		}
		// 高峰拥堵费
		if (vp.getIs_jam() || time.isAfter(vp.getJam_start()) && time.isBefore(vp.getJam_end())) {
			order.setJam_cost(vp.getJam_cost());
		} else {
			order.setJam_cost(0.0);
		}
		// 空驶费
		order.setEmpty_cost(vp.getEmpty_cost());
		// 根据订单类型计算价格
		double price = 0.0;
		switch (order.getType()) {
		case single:// 单点订单
			Price[] single = Constants.gson.fromJson(vp.getSingle(), Price[].class);
			price += single[0].getPrice();// 起步价
			price += (distance - single[0].getEnd_space()) * single[1].getPrice();// （距离-起步距离）*单价
			break;
		case multiple:// 多点订单
			Price[] multitude = Constants.gson.fromJson(vp.getMultitude(), Price[].class);
			for (Price item : multitude) {
				if (distance < item.getStart_space()) {
					// 距离小于某分段的起始值，结束计算
					break;
				} else if (distance > item.getEnd_space()) {
					// 距离大于某分段的结束值，该分段内的价格为（结束值 - 起始值）* 该分段价格
					price += (item.getEnd_space() - item.getStart_space()) * item.getPrice();
				} else {
					// 距离在某分段内，该分段内的价格为（距离 - 起始值）* 该分段价格
					price += (distance - item.getStart_space()) * item.getPrice();
				}
			}
			break;
		}
		price += distance * order.getJam_cost();// 距离 * 高峰加价
		price += order.getNight_cost();// 夜间服务费
		order.setOrder_money(price);
	}

}
