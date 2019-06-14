package com.caogen.jfd.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.AppUserDao;
import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.entity.user.AppUser.Identity;

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

	@Override
	public AppUser getByToken(String token) {
		AppUser entity = new AppUser();
		entity.setToken(token);
		return appUserDao.get(entity);
	}

	@Override
	public AppUser getByUsername(String username, Identity identity) {
		AppUser entity = new AppUser();
		entity.setUsername(username);
		entity.setIdentity(identity);
		return appUserDao.get(entity);
	}

}
