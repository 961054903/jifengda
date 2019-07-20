package com.caogen.jfd.service;

import com.caogen.jfd.entity.Config;

/**
 * 
 * @author Spuiln
 *
 */
public interface ConfigService extends BaseService<Config> {

	/**
	 * 根据item_key查询
	 * 
	 * @param key
	 * @return
	 */
	Config getByItem(String key);

}
