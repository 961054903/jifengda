package com.caogen.jfd.service.user;

import java.util.List;

import com.caogen.jfd.entity.user.AppUserDetail;
import com.caogen.jfd.service.BaseService;

/**
 * 
 * @author Spuiln
 *
 */
public interface AppUserDetailService extends BaseService<AppUserDetail> {
	/**
	 * 全部查询
	 * 
	 * @param phone
	 * @return
	 */
	List<AppUserDetail> getAll(String phone);

}
