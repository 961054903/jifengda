package com.caogen.jfd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.AppUserTicketDao;
import com.caogen.jfd.entity.AppUserTicket;
import com.caogen.jfd.service.AppUserTicketService;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class UserTicketServiceImpl implements AppUserTicketService {
	@Autowired
	private AppUserTicketDao ticketDao;

	@Override
	public void create(AppUserTicket entity) {
		ticketDao.insert(entity);
	}

	@Override
	public void remove(AppUserTicket entity) {
		ticketDao.delete(entity);
	}

	@Override
	public void modify(AppUserTicket entity) {
		ticketDao.update(entity);
	}

	@Override
	public AppUserTicket getById(Integer id) {
		return ticketDao.get(new AppUserTicket(id));
	}

	@Override
	public List<AppUserTicket> getAll(AppUserTicket entity) {
		return ticketDao.find(entity);
	}

}
