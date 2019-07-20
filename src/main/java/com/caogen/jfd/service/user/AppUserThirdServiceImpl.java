package com.caogen.jfd.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.AppUserThirdDao;
import com.caogen.jfd.entity.user.AppUserThird;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class AppUserThirdServiceImpl implements AppUserThirdService {
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

}
