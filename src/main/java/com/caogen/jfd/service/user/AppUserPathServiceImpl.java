package com.caogen.jfd.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.AppUserPathDao;
import com.caogen.jfd.entity.user.AppUserPath;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class AppUserPathServiceImpl implements AppUserPathService {
	@Autowired
	private AppUserPathDao pathDao;

	@Override
	public void create(AppUserPath entity) {
		pathDao.find(entity);
	}

	@Override
	public void remove(AppUserPath entity) {
		pathDao.delete(entity);
	}

	@Override
	public void modify(AppUserPath entity) {
		pathDao.update(entity);
	}

	@Override
	public AppUserPath getById(Integer id) {
		AppUserPath entity = new AppUserPath();
		entity.setId(id);
		return pathDao.get(entity);
	}

}
