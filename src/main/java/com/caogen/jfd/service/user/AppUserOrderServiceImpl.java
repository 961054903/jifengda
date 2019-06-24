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
import com.caogen.jfd.entity.user.AppUserOrder;
import com.caogen.jfd.entity.user.AppUserSite;
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
	public void calculate(AppUserSite origin, AppUserSite[] destination) {
		// 高德地图测量距离接口参数
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", Constants.GD_KEY);
		map.put("type", Constants.GD_DISTANCE_TYPE);
		// 处理参数
		List<AppUserSite> list = new ArrayList<AppUserSite>();
		List<AppUserSite> newList = new ArrayList<AppUserSite>();
		list.add(origin);
		list.addAll(1, Arrays.asList(destination));
		while (list.size() > 1) {
			AppUserSite site = list.remove(0);
			map.put("destination", site.getLongitude() + "," + site.getLatitude());
			StringBuffer sb = new StringBuffer();
			for (AppUserSite item : list) {
				sb.append(item.getLongitude());
				sb.append(",");
				sb.append(item.getLatitude());
				sb.append("|");
			}
			map.put("origins", sb.toString());
			String result = HttpClientUtils.doGet(Constants.GD_DISTANCE_URL, map);
			Distance dis = Constants.gson.fromJson(result, Distance.class);
			List<Result> a = dis.getResults();
		}
	}

}
