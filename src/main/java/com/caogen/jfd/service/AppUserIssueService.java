package com.caogen.jfd.service;

import java.util.List;

import com.caogen.jfd.entity.AppUserIssue;

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
