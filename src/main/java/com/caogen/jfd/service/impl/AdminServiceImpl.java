package com.caogen.jfd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.AppSmsDao;
import com.caogen.jfd.dao.AppUserDao;
import com.caogen.jfd.entity.AppSms;
import com.caogen.jfd.entity.AppUser;
import com.caogen.jfd.entity.AppUser.Identity;
import com.caogen.jfd.model.LoginMessage.Thirdparty;
import com.caogen.jfd.service.AdminService;
import com.caogen.jfd.util.PasswordHelper;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AppUserDao appUserDao;
	@Autowired
	private AppSmsDao appSmsDao;

	@Override
	public void generateSms(String phone) {
		// TODO 短信接口，获取验证码，存到数据库

	}

	@Override
	public String generateToken(String username, Identity identity) {
		String token = PasswordHelper.generateNumber();
		AppUser user = new AppUser();
		user.setUsername(username);
		user.setIdentity(identity);
		user.setToken(token);
		appUserDao.update(user);
		return token;
	}

	@Override
	public void verifyPassword(String username, String password, Identity identity) throws Exception {
		AppUser user = new AppUser();
		user.setUsername(username);
		user.setIdentity(identity);
		user = appUserDao.get(user);
		password = PasswordHelper.encryptPassword(password, user.getPassword());
		if (!password.equals(user.getPassword())) {
			throw new RuntimeException("密码输入错误");
		}
	}

	@Override
	public void verifySms(String username, String code) throws Exception {
		AppSms sms = new AppSms();
		sms.setPhone(username);
		sms = appSmsDao.get(sms);
		if (!sms.getCode().equals(code)) {
			throw new RuntimeException("验证码错误");
		}
	}

	@Override
	public void createAppUser(String username, Identity identity, String referrer) {
		AppUser user = new AppUser();
		user.setUsername(username);
		user.setIdentity(identity);
		appUserDao.insert(user);
	}

	@Override
	public void createAppUser(Thirdparty thirdparty, String identifier, String portrait_url, String username,
			Identity identity, String referrer) {
		// TODO Auto-generated method stub
		createAppUser(username, identity, referrer);

	}

}
