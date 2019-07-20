package com.caogen.jfd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.AppUserPathDao;
import com.caogen.jfd.entity.AppUserPath;
import com.caogen.jfd.service.AppUserPathService;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class PathServiceImpl implements AppUserPathService {
	@Autowired
	private AppUserPathDao pathDao;

	@Override
	public void create(AppUserPath entity) {
		pathDao.insert(entity);
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
		return pathDao.get(new AppUserPath(id));
	}

	@Override
	public AppUserPath getOne(AppUserPath entity) {
		return pathDao.get(entity);
	}

	@Override
	public List<AppUserPath> getAll(AppUserPath entity) {
		return pathDao.find(entity);
	}

	@Override
	public Integer count(AppUserPath path) {
		return pathDao.count(path);
	}

}
