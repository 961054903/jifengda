package com.caogen.jfd.service;

import com.caogen.jfd.entity.AppUser;

/**
 * 
 * @author Spuiln
 *
 */
public interface AppUserService extends BaseService<AppUser> {

	AppUser getByToken(String token);

}
