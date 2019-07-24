package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.ConfigDao;
import com.caogen.jfd.entity.driver.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * @author Spuiln
 *
 */
@Service
public class ConfigServiceImpl implements ConfigService{
	@Autowired
	private ConfigDao configDao;

	@Override
	public void create(Config entity) {
		configDao.insert(entity);
	}

	@Override
	public void remove(Config entity) {
		configDao.delete(entity);
	}

	@Override
	public void modify(Config entity) {
		configDao.update(entity);
	}

	@Override
	public Config getById(Integer id) {
		Config entity = new Config();
		entity.setId(id);
		return configDao.get(entity);
	}

	@Override
	public Config getByItem(String key) {
		return configDao.get(new Config(key));
	}

}
