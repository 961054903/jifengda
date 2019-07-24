package com.caogen.jfd.service.driver;

import com.caogen.jfd.entity.driver.Config;
import com.caogen.jfd.service.BaseService;


/**
 * 
 * @author Spuiln
 *
 */
public interface ConfigService extends BaseService<Config> {

	void create(Config entity);

	void remove(Config entity);

	void modify(Config entity);

	/**
	 * 根据item_key查询
	 * 
	 * @param key
	 * @return
	 */
	Config getByItem(String key);

}
