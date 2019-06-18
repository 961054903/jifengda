package com.caogen.jfd.service.user;

import com.caogen.jfd.entity.user.AppUserSms;
import com.caogen.jfd.service.BaseService;

/**
 * 
 * @author Spuiln
 *
 */
public interface AppUserSmsService extends BaseService<AppUserSms> {
	/**
	 * 根据手机号查询
	 * 
	 * @param phone
	 * @return
	 */
	AppUserSms getByPhone(String phone);

}
