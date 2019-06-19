package com.caogen.jfd.service.user;

import java.util.List;

import com.caogen.jfd.entity.user.AppUserTicket;
import com.caogen.jfd.service.BaseService;

/**
 * 
 * @author Spuiln
 *
 */
public interface AppUserTicketService extends BaseService<AppUserTicket> {
	/**
	 * 全是查询
	 * 
	 * @param phone
	 * @return
	 */
	List<AppUserTicket> getAll(String phone);

}
