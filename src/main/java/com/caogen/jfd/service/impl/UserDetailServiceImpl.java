package com.caogen.jfd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.AppUserDetailDao;
import com.caogen.jfd.entity.AppUserDetail;
import com.caogen.jfd.service.AppUserDetailService;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class UserDetailServiceImpl implements AppUserDetailService {
	@Autowired
	private AppUserDetailDao detailDao;

	@Override
	public void create(AppUserDetail entity) {
		detailDao.insert(entity);
	}

	@Override
	public void remove(AppUserDetail entity) {
		detailDao.delete(entity);
	}

	@Override
	public void modify(AppUserDetail entity) {
		detailDao.update(entity);
	}

	@Override
	public AppUserDetail getById(Integer id) {
		return detailDao.get(new AppUserDetail(id));
	}

	@Override
	public List<AppUserDetail> getAll(AppUserDetail entity) {
		return detailDao.find(entity);
	}

}
