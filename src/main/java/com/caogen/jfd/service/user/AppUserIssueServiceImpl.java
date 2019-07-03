package com.caogen.jfd.service.user;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.AppUserIssueDao;
import com.caogen.jfd.entity.user.AppUserIssue;
import com.caogen.jfd.entity.user.AppUserIssue.Type;
import com.caogen.jfd.util.FormatUtils;

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
		return issueDao.get(new AppUserIssue(id));
	}

	@Override
	public List<AppUserIssue> getFAQ() {
		AppUserIssue entity = new AppUserIssue();
		entity.setType(Type.faq);
		List<AppUserIssue> list = issueDao.find(entity);
		for (AppUserIssue item : list) {
			item.setCreate_date(null);
		}
		return list;
	}

	@Override
	public List<AppUserIssue> getHistory(AppUserIssue entity) {
		List<AppUserIssue> list = issueDao.find(entity);
		for (AppUserIssue item : list) {
			item.setCreateDate(FormatUtils.dateToStr(item.getCreate_date()));
			item.setCreate_date(null);
		}
		return list;
	}

}
