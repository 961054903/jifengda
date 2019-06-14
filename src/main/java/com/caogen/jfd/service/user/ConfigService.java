package com.caogen.jfd.service.user;

import java.util.List;

import com.caogen.jfd.entity.SysConfig;
import com.caogen.jfd.service.BaseService;

/**
 * 
 * @author Spuiln
 *
 */
public interface ConfigService extends BaseService<SysConfig> {

	List<String> getCities();

}
