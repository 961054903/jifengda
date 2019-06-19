package com.caogen.jfd.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.AppTicketDao;
import com.caogen.jfd.entity.user.AppTicket;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class AppTicketServiceImpl implements AppTicketService {
	@Autowired
	private AppTicketDao ticketDao;

	@Override
	public void create(AppTicket entity) {
		ticketDao.insert(entity);
	}

	@Override
	public void remove(AppTicket entity) {
		ticketDao.delete(entity);
	}

	@Override
	public void modify(AppTicket entity) {
		ticketDao.update(entity);
	}

	@Override
	public AppTicket getById(Integer id) {
		return ticketDao.get(new AppTicket(id));
	}

}
