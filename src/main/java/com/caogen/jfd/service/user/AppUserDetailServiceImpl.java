package com.caogen.jfd.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.AppUserDetailDao;
import com.caogen.jfd.entity.user.AppUserDetail;
import com.caogen.jfd.util.FormatUtils;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class AppUserDetailServiceImpl implements AppUserDetailService {
	@Autowired
	private AppUserDetailDao detailDao;

	@Override
	public void create(AppUserDetail entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(AppUserDetail entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(AppUserDetail entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public AppUserDetail getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppUserDetail> getAll(AppUserDetail entity) {
		List<AppUserDetail> list = detailDao.find(entity);
		for (AppUserDetail item : list) {
			item.setCreateDate(FormatUtils.dateToStr(item.getCreate_date()));
			item.setCreate_date(null);
		}
		return list;
	}

}
