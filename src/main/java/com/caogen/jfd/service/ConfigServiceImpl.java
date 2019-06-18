package com.caogen.jfd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.ConfigDao;
import com.caogen.jfd.entity.SysConfig;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class ConfigServiceImpl implements ConfigService {
	@Autowired
	private ConfigDao configDao;

	@Override
	public void create(SysConfig entity) {
		configDao.insert(entity);
	}

	@Override
	public void remove(SysConfig entity) {
		configDao.delete(entity);
	}

	@Override
	public void modify(SysConfig entity) {
		configDao.update(entity);
	}

	@Override
	public SysConfig getById(Integer id) {
		SysConfig entity = new SysConfig();
		entity.setId(id);
		return configDao.get(entity);
	}

	@Override
	public SysConfig getByItem(String key) {
		SysConfig entity = new SysConfig();
		entity.setItem_key(key);
		return configDao.get(entity);
	}

}
