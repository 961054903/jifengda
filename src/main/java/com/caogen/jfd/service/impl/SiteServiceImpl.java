package com.caogen.jfd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.AppUserSiteDao;
import com.caogen.jfd.entity.AppUserSite;
import com.caogen.jfd.service.AppUserSiteService;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class SiteServiceImpl implements AppUserSiteService {
	@Autowired
	private AppUserSiteDao siteDao;

	@Override
	public void create(AppUserSite entity) {
		siteDao.insert(entity);
	}

	@Override
	public void remove(AppUserSite entity) {
		siteDao.delete(entity);
	}

	@Override
	public void modify(AppUserSite entity) {
		siteDao.update(entity);
	}

	@Override
	public AppUserSite getById(Integer id) {
		return siteDao.get(new AppUserSite(id));
	}

	@Override
	public AppUserSite getOne(AppUserSite entity) {
		return siteDao.get(entity);
	}

	@Override
	public List<AppUserSite> getAll(AppUserSite entity) {
		return siteDao.find(entity);
	}

	@Override
	public List<AppUserSite> getDriverLocation(double longitude, double latitude, double distance, Integer model_id) {
		List<AppUserSite> list = siteDao.findLocation(model_id);
		List<AppUserSite> newList = new ArrayList<AppUserSite>();
		for (AppUserSite item : list) {
			double gap = getDistance(latitude, longitude, item.getLatitude(), item.getLongitude());
			if (gap < distance) {
				newList.add(item);
			}
		}
		return newList;
	}

	/**
	 * 通过经纬度获取距离(单位：千米)
	 *
	 * @param lat1
	 * @param lng1
	 * @param lat2
	 * @param lng2
	 * @return 距离
	 */
	public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(
				Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000d) / 10000d;
		return s;
	}

	private static double EARTH_RADIUS = 6378.137;// 地球半径

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}
}
