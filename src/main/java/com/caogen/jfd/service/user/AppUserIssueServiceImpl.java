package com.caogen.jfd.service.user;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.AppUserIssueDao;
import com.caogen.jfd.entity.user.AppUserIssue;
import com.caogen.jfd.entity.user.AppUserIssue.Type;

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
		entity.setIs_check(false);
		entity.setCreate_date(LocalDateTime.now());
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

	@Override
	public List<AppUserIssue> getFAQ() {
		AppUserIssue entity = new AppUserIssue();
		entity.setType(Type.faq);
		return issueDao.find(entity);
	}

	@Override
	public List<AppUserIssue> getHistory(AppUserIssue entity) {
		return issueDao.find(entity);
	}

}
