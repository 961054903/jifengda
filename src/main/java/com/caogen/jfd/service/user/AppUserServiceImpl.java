package com.caogen.jfd.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.dao.user.AppUserDao;
import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.exception.DefinedException;

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
		String token = null;
		// 检查参数
		if (user == null || user.getUsername() == null || user.getPassword() == null) {
			throw new DefinedException(ErrorCode.LOGIN_PARAM_ERROR);
		}
		return token;
	}

}
