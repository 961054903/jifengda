package com.caogen.jfd.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.AppUserIssueDao;
import com.caogen.jfd.entity.user.AppUserIssue;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class AppUserIssueServiceImpl implements AppUserIssueService {
	@Autowired
	private AppUserIssueDao issueDao;

	@Override
	public void create(AppUserIssue entity) {
		issueDao.insert(entity);
	}

	@Override
	public void remove(AppUserIssue entity) {
		issueDao.delete(entity);
	}

	@Override
	public void modify(AppUserIssue entity) {
		issueDao.update(entity);
	}

	@Override
	public AppUserIssue getById(Integer id) {
		AppUserIssue entity = new AppUserIssue();
		entity.setId(id);
		return issueDao.get(entity);
	}

}
