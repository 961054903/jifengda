package com.caogen.jfd.service.user;

import java.util.List;

import com.caogen.jfd.entity.user.AppUserIssue;
import com.caogen.jfd.service.BaseService;

/**
 * 
 * @author Spuiln
 *
 */
public interface AppUserIssueService extends BaseService<AppUserIssue> {
	/**
	 * 获取FAQ列表
	 * 
	 * @return
	 */
	List<AppUserIssue> getFAQ();

	/**
	 * 获取历史反馈列表
	 * 
	 * @param issue
	 * @return
	 */
	List<AppUserIssue> getHistory(AppUserIssue entity);

}
