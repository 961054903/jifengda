package com.caogen.jfd.service.user;

import com.caogen.jfd.entity.user.AppUserThird;
import com.caogen.jfd.service.BaseService;

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

}
