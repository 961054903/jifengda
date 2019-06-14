package com.caogen.jfd.service.user;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.AppSmsDao;
import com.caogen.jfd.dao.user.AppThirdDao;
import com.caogen.jfd.dao.user.AppUserDao;
import com.caogen.jfd.dao.user.ConfigDao;
import com.caogen.jfd.entity.user.AppSms;
import com.caogen.jfd.entity.user.AppThird;
import com.caogen.jfd.entity.user.AppThird.Thirdparty;
import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.entity.user.SysConfig;
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
	public String generateToken(String username) {
		String token = PasswordHelper.generateNumber();
		AppUser user = new AppUser();
		user.setUsername(username);
		user.setToken(token);
		appUserDao.update(user);
		return token;
	}

	@Override
	public void verifyPassword(String username, String password) throws Exception {
		AppUser user = new AppUser();
		user.setUsername(username);
		user = appUserDao.get(user);
		// 用户密码判断
		String ciphertext = PasswordHelper.encryptPassword(password, user.getSalt());
		if (!ciphertext.equals(user.getPassword())) {
			throw new RuntimeException("密码输入错误");
		}
		// 用户状态判断
		switch (user.getState()) {
		case normal:
			break;
		case locked:
			throw new RuntimeException("用户被锁定");
		default:
			break;
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
		if (sms == null) {
			throw new RuntimeException("验证码不存在");
		}
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
	public void createAppUser(String username, String referrer) {
		AppUser user = new AppUser();
		user.setUsername(username);
		user.setState(AppUser.State.normal);
		user.setCreate_date(LocalDateTime.now());
		appUserDao.insert(user);
		System.out.println(user);
	}

	@Override
	public void createAppUser(Thirdparty thirdparty, String identifier, String portrait_url, String username,
			String referrer) {
		createAppUser(username, referrer);
		AppThird third = new AppThird();
		third.setThirdparty(thirdparty);
		third.setIdentifier(identifier);
		third.setPortrait_url(portrait_url);
		appThirdDao.insert(third);
		System.out.println(third);
	}

}
