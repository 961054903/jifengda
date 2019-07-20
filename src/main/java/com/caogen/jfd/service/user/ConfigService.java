package com.caogen.jfd.service.user;

import com.caogen.jfd.entity.user.SysConfig;
import com.caogen.jfd.service.BaseService;

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
