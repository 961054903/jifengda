package com.caogen.jfd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.AppUserDao;
import com.caogen.jfd.entity.AppUser.Identity;
import com.caogen.jfd.service.AdminService;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AppUserDao appUserDao;

	@Override
	public String generateToken(String username, Identity identity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateSms(String phone) {
		// TODO Auto-generated method stub

	}

	@Override
	public void password(String username, String password) {
		// TODO Auto-generated method stub

	}

}
