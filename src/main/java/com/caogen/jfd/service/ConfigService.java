package com.caogen.jfd.service;

import java.util.List;

import com.caogen.jfd.entity.SysConfig;

/**
 * 
 * @author Spuiln
 *
 */
public interface ConfigService extends BaseService<SysConfig> {

	List<String> getCities();

}
