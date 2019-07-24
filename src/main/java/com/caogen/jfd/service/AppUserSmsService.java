package com.caogen.jfd.service;

import com.caogen.jfd.entity.AppUserSms;

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
