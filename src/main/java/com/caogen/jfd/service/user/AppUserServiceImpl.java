package com.caogen.jfd.service.user;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.dao.user.AppUserDao;
import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.entity.user.AppUser.State;
import com.caogen.jfd.util.PasswordHelper;
import com.caogen.jfd.util.SecretUtils;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private AppUserDao userDao;

	@Override
	public void create(AppUser entity) {
		entity.setState(State.normal);
		entity.setCreate_date(LocalDateTime.now());
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
		return userDao.get(new AppUser(id));
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
	public String[] exchangeKey(String A, String phone) throws Exception {
		AppUser user = getByUsername(phone);
		String[] result = SecretUtils.dh(A, Constants.DH_G, Constants.DH_P);
		String B = result[0];
		String iv = result[1].substring(Constants.IV_START, Constants.IV_END);
		String key = result[1].substring(Constants.KEY_START, Constants.KEY_END);
		user.setDes_iv(iv);
		user.setDes_key(key);
		String verify = SecretUtils.desedeEncode(Constants.DEFAULT_IV, key, iv);
		modify(user);
		return new String[] { B, verify };
	}

	@Override
	public void changePassword(String username, String password) {
		AppUser user = getByUsername(username);
		user.setSalt(PasswordHelper.generateSalt());
		user.setPassword(PasswordHelper.encryptPassword(password, user.getSalt()));
		modify(user);
	}

}
