package com.caogen.jfd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.AppUserThirdDao;
import com.caogen.jfd.entity.AppUserThird;
import com.caogen.jfd.service.AppUserThirdService;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class UserThirdServiceImpl implements AppUserThirdService {
	@Autowired
	private AppUserThirdDao thirdDao;

	@Override
	public void create(AppUserThird entity) {
		thirdDao.insert(entity);
	}

	@Override
	public void remove(AppUserThird entity) {
		thirdDao.delete(entity);
	}

	@Override
	public void modify(AppUserThird entity) {
		thirdDao.update(entity);
	}

	@Override
	public AppUserThird getById(Integer id) {
		return thirdDao.get(new AppUserThird(id));
	}

	@Override
	public AppUserThird getByProperty(AppUserThird entity) {
		return thirdDao.get(entity);
	}

	@Override
	public List<AppUserThird> findByProperty(AppUserThird entity) {
		return thirdDao.find(entity);
	}

}
