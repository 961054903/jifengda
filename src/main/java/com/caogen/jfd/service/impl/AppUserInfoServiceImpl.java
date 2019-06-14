package com.caogen.jfd.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.caogen.jfd.entity.AppUserInfo;
import com.caogen.jfd.service.AppUserInfoService;

@Service
public class AppUserInfoServiceImpl implements AppUserInfoService {

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

	private int getAge(LocalDateTime birthday) {
		return LocalDateTime.now().getYear() - birthday.getYear();
	}

}
