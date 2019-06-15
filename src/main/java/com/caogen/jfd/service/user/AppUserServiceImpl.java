package com.caogen.jfd.service.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.dao.user.AppUserDao;
import com.caogen.jfd.entity.user.AppUser;
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
	public String loginByPassword(AppUser user) throws Exception {
		// 检查参数
		if (user.getUsername() == null || user.getPassword() == null) {
			throw new DefinedException(ErrorCode.LOGIN_PARAM_ERROR);
		}
		// 用户是否存在
		AppUser entity = userDao.get(user);
		if (entity == null || !entity.getState().equals(AppUser.State.normal)) {
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

	@Test
	public void test() {
		String salt = PasswordHelper.generateSalt();
		System.out.println(salt);
		System.out.println(PasswordHelper.encryptPassword("123456", salt));
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
