package com.caogen.jfd.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.ConfigDao;
import com.caogen.jfd.entity.user.SysConfig;

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
	public List<String> getCities() {
		SysConfig config = new SysConfig();
		config.setItem_key("city");
		config = configDao.get(config);
		List<String> list = Arrays.asList(config.getItem_value().split(","));
		return list;
	}

}
