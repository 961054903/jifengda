package com.caogen.jfd.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.AppUserSiteDao;
import com.caogen.jfd.entity.user.AppUserSite;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class AppUserSiteServiceImpl implements AppUserSiteService {
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

}
