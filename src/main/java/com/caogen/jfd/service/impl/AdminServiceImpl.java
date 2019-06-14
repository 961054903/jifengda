package com.caogen.jfd.service.impl;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.AppSmsDao;
import com.caogen.jfd.dao.AppThirdDao;
import com.caogen.jfd.dao.AppUserDao;
import com.caogen.jfd.dao.ConfigDao;
import com.caogen.jfd.entity.AppSms;
import com.caogen.jfd.entity.AppThird;
import com.caogen.jfd.entity.AppUser;
import com.caogen.jfd.entity.AppUser.Identity;
import com.caogen.jfd.entity.SysConfig;
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
	@Autowired
	private AppThirdDao appThirdDao;
	@Autowired
	private ConfigDao configDao;

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
		// 查询验证码有效时间
		SysConfig config = new SysConfig();
		config.setItem_key("indate");
		Long indate = Long.parseLong(configDao.get(config).getItem_value());
		// 查询该条验证码记录
		AppSms sms = new AppSms();
		sms.setPhone(username);
		sms = appSmsDao.get(sms);
		// 验证码是否在有效期内
		Duration duration = Duration.between(sms.getCreate_date(), LocalDateTime.now());
		long millis = duration.toMillis();
		if (millis > indate) {
			throw new RuntimeException("验证码已过期");
		}
		// 验证码是否正确
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
	public void createAppUser(AppThird.Thirdparty thirdparty, String identifier, String portrait_url, String username,
			Identity identity, String referrer) {
		createAppUser(username, identity, referrer);
		AppThird third = new AppThird();
		third.setThirdparty(thirdparty);
		third.setIdentifier(identifier);
		third.setPortrait_url(portrait_url);
		appThirdDao.insert(third);
	}

}
