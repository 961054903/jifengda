package com.caogen.jfd.service;

import java.util.List;

import com.caogen.jfd.entity.AppUserThird;

/**
 * 
 * @author Spuiln
 *
 */
public interface AppUserThirdService extends BaseService<AppUserThird> {
	/**
	 * 通过属性查询
	 * 
	 * @param entity
	 * @return
	 */
	AppUserThird getByProperty(AppUserThird entity);

	/**
	 * 通过属性查询
	 * 
	 * @param entity
	 * @return
	 */
	List<AppUserThird> findByProperty(AppUserThird entity);

}
