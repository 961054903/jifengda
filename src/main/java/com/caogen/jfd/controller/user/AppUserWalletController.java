package com.caogen.jfd.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.entity.user.AppUserDetail;
import com.caogen.jfd.entity.user.AppUserTicket;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.user.AppUserDetailService;
import com.caogen.jfd.service.user.AppUserService;
import com.caogen.jfd.service.user.AppUserTicketService;

/**
 * 
 * @author Spuiln
 *
 */
@Controller
public class AppUserWalletController {
	@Autowired
	private AppUserService userService;
	@Autowired
	private AppUserDetailService detailService;
	@Autowired
	private AppUserTicketService ticketService;

	/**
	 * 账户明细
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "detail/all", "detail/api/all" })
	public Message detail(Message data) {
		Message message = new Message();
		try {
			AppUser user = userService.getByToken(data.getDesc());
			AppUserDetail entity = new AppUserDetail();
			entity.setUser_id(user.getId());
			List<AppUserDetail> list = detailService.getAll(entity);
			message.setData(list, user.getDes_key(), user.getDes_iv());
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.DETAIL_ERROR);
			StaticLogger.error(message.getDesc(), e);
		}
		return message;
	}

	/**
	 * 红包列表
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "ticket/all", "ticket/api/all" })
	public Message ticket(Message data) {
		Message message = new Message();
		try {
			AppUser user = userService.getByToken(data.getDesc());
			AppUserTicket ticket = Constants.gson.fromJson((String) data.getData(), AppUserTicket.class);
			ticket.setUser_id(user.getId());
			List<AppUserTicket> list = ticketService.getAll(ticket);
			message.setData(list, user.getDes_key(), user.getDes_iv());
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.TICKET_ERROR);
			StaticLogger.error(message.getDesc(), e);
		}
		return message;
	}

}
