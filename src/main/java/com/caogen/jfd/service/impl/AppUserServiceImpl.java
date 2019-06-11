package com.caogen.jfd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.AppUserDao;
import com.caogen.jfd.entity.AppUser;
import com.caogen.jfd.service.AppUserService;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private AppUserDao appUserDao;

	@Override
	public void create(AppUser entity) {
		appUserDao.insert(entity);
	}

	@Override
	public void remove(AppUser entity) {
		appUserDao.delete(entity);
	}

	@Override
	public void modify(AppUser entity) {
		appUserDao.update(entity);
	}

	@Override
	public AppUser getById(Integer id) {
		AppUser entity = new AppUser();
		entity.setId(id);
		return appUserDao.get(entity);
	}

}
