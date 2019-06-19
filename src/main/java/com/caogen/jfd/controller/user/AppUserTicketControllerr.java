package com.caogen.jfd.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caogen.jfd.service.user.AppUserTicketService;

@Controller
@RequestMapping("ticket")
public class AppUserTicketControllerr {
	@Autowired
	private AppUserTicketService ticketService;
}
