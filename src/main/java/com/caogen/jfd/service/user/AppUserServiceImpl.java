package com.caogen.jfd.service.user;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.dao.user.AppUserDao;
import com.caogen.jfd.dao.user.AppUserSmsDao;
import com.caogen.jfd.dao.user.ConfigDao;
import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.entity.user.AppUser.State;
import com.caogen.jfd.entity.user.AppUserSms;
import com.caogen.jfd.entity.user.AppUserThird;
import com.caogen.jfd.entity.user.SysConfig;
import com.caogen.jfd.exception.DefinedException;
import com.caogen.jfd.util.PasswordHelper;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private AppUserDao userDao;
	@Autowired
	private AppUserSmsDao smsDao;
	@Autowired
	private ConfigDao configDao;

	@Override
	public void create(AppUser entity) {
		userDao.insert(entity);
	}

	@Override
	public void remove(AppUser entity) {
		userDao.delete(entity);
	}

	@Override
	public void modify(AppUser entity) {
		userDao.update(entity);
	}

	@Override
	public AppUser getById(Integer id) {
		AppUser entity = new AppUser();
		entity.setId(id);
		return userDao.get(entity);
	}

	@Override
	public AppUser getByToken(String token) {
		AppUser entity = new AppUser();
		entity.setToken(token);
		return userDao.get(entity);
	}

	@Override
	public AppUser getByUsername(String username) {
		AppUser entity = new AppUser();
		entity.setUsername(username);
		return userDao.get(entity);
	}

	@Override
	public void verifySms(String phone, String sms) throws Exception {
		// 查询该条验证码记录
		AppUserSms userSms = smsDao.get(new AppUserSms(phone));
		if (userSms == null) {
			throw new DefinedException(ErrorCode.SMS_INEXISTENCE);
		}
		// 验证码是否在有效期内
		SysConfig config = configDao.get(new SysConfig("indate"));
		Long indate = Long.parseLong(config.getItem_value());
		Duration duration = Duration.between(userSms.getCreate_date(), LocalDateTime.now());
		if (duration.toMillis() > indate) {
			throw new DefinedException(ErrorCode.SMS_PAST);
		}
		if (!userSms.getCode().equals(sms)) {
			throw new DefinedException(ErrorCode.SMS_MISMATCHING);
		}
	}

	@Override
	public String loginByPassword(AppUser user) throws Exception {
		// 检查参数
		if (user.getUsername() == null || user.getPassword() == null) {
			throw new DefinedException(ErrorCode.LOGIN_PARAM_ERROR);
		}
		// 用户是否存在
		AppUser entity = userDao.get(user);
		if (entity == null || !entity.getState().equals(State.normal)) {
			throw new DefinedException(ErrorCode.LOGIN_USER_ERROR);
		}
		// 密码是否设置
		if (StringUtils.isEmpty(entity.getPassword())) {
			throw new DefinedException(ErrorCode.LOGIN_PASSWORD_ERROR);
		}
		// 密码是否正确
		String ciphertext = PasswordHelper.encryptPassword(user.getPassword(), entity.getSalt());
		if (!ciphertext.equals(entity.getPassword())) {
			throw new DefinedException(ErrorCode.LOGIN_PASSWORD_ERROR);
		}
		return generateToken(user.getUsername());
	}

	@Override
	public String loginBySms(AppUser user, AppUserSms sms) throws Exception {
		// 检查参数
		if (user.getUsername() == null || sms.getCode() == null) {
			throw new DefinedException(ErrorCode.LOGIN_PARAM_ERROR);
		}
		// TODO对比验证码
		verifySms(user.getUsername(), sms.getCode());
		//
		AppUser entity = userDao.get(user);
		if (entity == null) {// 创建用户
			entity = new AppUser();
			entity.setUsername(user.getUsername());
			entity.setReferrer(user.getReferrer());
			entity.setState(State.normal);
			entity.setCreate_date(LocalDateTime.now());
			create(entity);
		} else if (!entity.getState().equals(State.normal)) {
			throw new DefinedException(ErrorCode.LOGIN_USER_ERROR);
		}
		return generateToken(user.getUsername());
	}

	@Override
	public String loginByThird(AppUser user, AppUserSms sms, AppUserThird third) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 生成token
	 * 
	 * @param username
	 * @return
	 */
	private String generateToken(String username) {
		String token = PasswordHelper.generateNumber();
		AppUser entity = new AppUser();
		entity.setUsername(username);
		entity.setToken(token);
		userDao.update(entity);
		return token;
	}

}
