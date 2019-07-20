package com.caogen.jfd.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.AppUserDao;
import com.caogen.jfd.dao.user.AppUserInfoDao;
import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.entity.user.AppUserInfo;
import com.caogen.jfd.entity.user.AppUserInfo.Gender;
import com.caogen.jfd.util.FormatUtils;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class AppUserInfoServiceImpl implements AppUserInfoService {
	@Autowired
	private AppUserInfoDao infoDao;
	@Autowired
	private AppUserDao userDao;

	@Override
	public void create(AppUserInfo entity) {
		AppUser user = userDao.get(new AppUser(entity.getPhone()));
		entity.setUser_id(user.getId());
		entity.setLevel(0);
		entity.setGender(Gender.unknown);
		entity.setIs_real(false);
		entity.setBalance(0.0);
		infoDao.insert(entity);
	}

	@Override
	public void remove(AppUserInfo entity) {
		infoDao.delete(entity);
	}

	@Override
	public void modify(AppUserInfo entity) {
		infoDao.update(entity);
	}

	@Override
	public AppUserInfo getById(Integer id) {
		return infoDao.get(new AppUserInfo(id));
	}

	@Override
	public AppUserInfo getOne(AppUserInfo entity) {
		AppUserInfo info = infoDao.get(entity);
		if (info.getBirthday() != null) {
			info.setBirth(FormatUtils.dateToStr(info.getBirthday()));
			info.setBirthday(null);
		}
		return info;
	}

}
