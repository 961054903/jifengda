package com.caogen.jfd.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.entity.user.AppUserTicket;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.user.AppTicketService;
import com.caogen.jfd.service.user.AppUserService;
import com.caogen.jfd.service.user.AppUserTicketService;

@Controller
@RequestMapping("ticket")
public class AppUserTicketControllerr {
	@Autowired
	private AppUserService userService;
	@Autowired
	private AppUserTicketService userTicketService;
	@Autowired
	private AppTicketService appTicketService;

	@ResponseBody
	@RequestMapping(value = { "add", "api/add" })
	public Message add(String data) {
		Message message = new Message();
		try {
			AppUserTicket userTicket = Constants.gson.fromJson(data, AppUserTicket.class);
			AppUser user = userService.getByUsername(userTicket.getPhone());
			userTicket.setUser_ticket_id(user.getId());
			userTicketService.create(userTicket);
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.TICKET_ERROR);
			StaticLogger.error("user ticket add error", e);
		}
		return message;
	}

}
