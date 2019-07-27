package com.caogen.jfd.service.driver;
import com.caogen.jfd.dao.driver.AppUserIssueDao;
import com.caogen.jfd.entity.driver.AppUserIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class IssueServiceImpl implements AppUserIssueService{
	@Autowired
	private AppUserIssueDao issueDao;

	@Override
	public void create(AppUserIssue entity) {
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
		entity.setType(AppUserIssue.Type.faq);
		List<AppUserIssue> list = issueDao.find(entity);
		for (AppUserIssue item : list) {
			item.setCreate_date(null);
		}
		return list;
	}

	@Override
	public List<AppUserIssue> getHistory(AppUserIssue entity) {
		return issueDao.find(entity);
	}

}
