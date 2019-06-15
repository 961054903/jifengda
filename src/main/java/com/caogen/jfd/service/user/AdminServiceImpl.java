package com.caogen.jfd.service.user;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.AppUserDao;
import com.caogen.jfd.dao.user.AppUserSmsDao;
import com.caogen.jfd.dao.user.AppUserThirdDao;
import com.caogen.jfd.dao.user.ConfigDao;
import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.entity.user.AppUserSms;
import com.caogen.jfd.entity.user.AppUserThird;
import com.caogen.jfd.entity.user.AppUserThird.Thirdparty;
import com.caogen.jfd.entity.user.SysConfig;
import com.caogen.jfd.util.PasswordHelper;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class AdminServiceImpl {
	@Autowired
	private AppUserDao userDao;
	@Autowired
	private AppUserSmsDao smsDao;
	@Autowired
	private AppUserThirdDao thirdDao;
	@Autowired
	private ConfigDao configDao;

	public String generateToken(String username) {
		String token = PasswordHelper.generateNumber();
		AppUser user = new AppUser();
		user.setUsername(username);
		user.setToken(token);
		userDao.update(user);
		return token;
	}

	public void verifySms(String phone, String sms) {
		// 查询该条验证码记录
		AppUserSms userSms = smsDao.get(new AppUserSms(phone));
		if (userSms == null) {
			throw new RuntimeException("验证码不存在");
		}
		// 验证码是否在有效期内
		SysConfig config = configDao.get(new SysConfig("indate"));
		Long indate = Long.parseLong(config.getItem_value());
		Duration duration = Duration.between(userSms.getCreate_date(), LocalDateTime.now());
		if (duration.toMillis() > indate) {
			throw new RuntimeException("验证码已过期");
		}
		// 验证码是否正确
		if (!userSms.getCode().equals(sms)) {
			throw new RuntimeException("验证码错误");
		}
	}

	public void createAppUser(String username, String referrer) {
		AppUser user = new AppUser();
		user.setUsername(username);
		user.setState(AppUser.State.normal);
		user.setCreate_date(LocalDateTime.now());
		user.setReferrer(referrer);
		userDao.insert(user);
	}

	public void createAppUser(Thirdparty thirdparty, String identifier, String portrait_url, String username,
			String referrer) {
		createAppUser(username, referrer);
		AppUserThird third = new AppUserThird();
		third.setThirdparty(thirdparty);
		third.setIdentifier(identifier);
		third.setPortrait_url(portrait_url);
		thirdDao.insert(third);
	}

	public void thirdpartyLogin(Thirdparty thirdparty, String identifier, String portrait_url, String username,
			String sms, String referrer) throws Exception {
		// 检查参数
		if (thirdparty == null || identifier == null) {
			throw new RuntimeException("登录参数缺失");
		}
		AppUserThird third = thirdDao.get(new AppUserThird(thirdparty, identifier));
		if (third == null) {// 第一次登录
			// 检查参数
			if (username == null || sms == null) {
				throw new RuntimeException("登录参数缺失");
			}
			// 比较验证码
			verifySms(username, sms);
			createAppUser(thirdparty, identifier, portrait_url, username, referrer);
		} else {
//			String phone = third.getPhone();
//			AppUser user = userDao.get(new AppUser(phone));
//			ckeckUserState(user);
		}
	}

}
