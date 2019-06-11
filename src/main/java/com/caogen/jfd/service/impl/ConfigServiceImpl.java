package com.caogen.jfd.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.ConfigDao;
import com.caogen.jfd.entity.SysConfig;
import com.caogen.jfd.service.ConfigService;

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
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(SysConfig entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(SysConfig entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public SysConfig getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getCities() {
		SysConfig config = new SysConfig();
		config.setItem_key("city");
		config = configDao.get(config);
		List<String> list = Arrays.asList(config.getItem_value().split("|"));
		return list;
	}

}
