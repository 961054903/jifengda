package com.caogen.jfd.service;

import com.caogen.jfd.entity.SysConfig;

/**
 * 
 * @author Spuiln
 *
 */
public interface ConfigService extends BaseService<SysConfig> {

	/**
	 * 根据item_key查询
	 * 
	 * @param key
	 * @return
	 */
	SysConfig getByItem(String key);

}
