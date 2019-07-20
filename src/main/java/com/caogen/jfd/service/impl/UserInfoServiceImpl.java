package com.caogen.jfd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.AppUserInfoDao;
import com.caogen.jfd.entity.AppUserInfo;
import com.caogen.jfd.entity.AppUserInfo.Gender;
import com.caogen.jfd.service.AppUserInfoService;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class UserInfoServiceImpl implements AppUserInfoService {
	@Autowired
	private AppUserInfoDao infoDao;

	@Override
	public void create(AppUserInfo entity) {
		entity.setLevel(0);
		entity.setGender(Gender.unknown);
		entity.setIs_real(false);
		entity.setBalance(0.0);
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
		return infoDao.get(new AppUserInfo(id));
	}

	@Override
	public AppUserInfo getOne(AppUserInfo entity) {
		return infoDao.get(entity);
	}

	@Override
	public void modifyBalance(AppUserInfo entity) {
		infoDao.updateBalance(entity);
	}

}
