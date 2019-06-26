package com.caogen.jfd.service.user;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.AppUserSmsDao;
import com.caogen.jfd.entity.user.AppUserSms;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class AppUserSmsServiceImpl implements AppUserSmsService {
	@Autowired
	private AppUserSmsDao smsDao;

	@Override
	public void create(AppUserSms entity) {
		entity.setCreate_date(LocalDateTime.now());
		smsDao.insert(entity);
	}

	@Override
	public void remove(AppUserSms entity) {
		smsDao.delete(entity);
	}

	@Override
	public void modify(AppUserSms entity) {
		smsDao.update(entity);
	}

	@Override
	public AppUserSms getById(Integer id) {
		return smsDao.get(new AppUserSms(id));
	}

	@Override
	public AppUserSms getByPhone(String phone) {
		return smsDao.get(new AppUserSms(phone));
	}

}
