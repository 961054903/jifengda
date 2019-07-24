package com.caogen.jfd.service;

import java.util.List;

import com.caogen.jfd.entity.AppUserTicket;

/**
 * 
 * @author Spuiln
 *
 */
public interface AppUserTicketService extends BaseService<AppUserTicket> {
	/**
	 * 全是查询
	 * 
	 * @param entity
	 * @return
	 */
	List<AppUserTicket> getAll(AppUserTicket entity);

}
