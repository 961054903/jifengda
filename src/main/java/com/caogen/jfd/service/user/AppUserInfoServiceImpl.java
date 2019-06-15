package com.caogen.jfd.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.AppUserInfoDao;
import com.caogen.jfd.entity.user.AppUserInfo;

@Service
public class AppUserInfoServiceImpl implements AppUserInfoService {
	@Autowired
	private AppUserInfoDao infoDao;

	@Override
	public void create(AppUserInfo entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(AppUserInfo entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(AppUserInfo entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public AppUserInfo getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
