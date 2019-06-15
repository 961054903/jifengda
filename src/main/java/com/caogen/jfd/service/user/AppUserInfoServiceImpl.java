package com.caogen.jfd.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.AppUserInfoDao;
import com.caogen.jfd.entity.user.AppUserInfo;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class AppUserInfoServiceImpl implements AppUserInfoService {
	@Autowired
	private AppUserInfoDao infoDao;

	@Override
	public void create(AppUserInfo entity) {
		infoDao.insert(entity);
	}

	@Override
	public void remove(AppUserInfo entity) {
		infoDao.delete(entity);
	}

	@Override
	public void modify(AppUserInfo entity) {
		infoDao.update(entity);
	}

	@Override
	public AppUserInfo getById(Integer id) {
		AppUserInfo entity = new AppUserInfo();
		entity.setId(id);
		return infoDao.get(entity);
	}

}
