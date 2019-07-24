package com.caogen.jfd.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.entity.AppUserOrder;
import com.caogen.jfd.service.AppUserOrderService;

public class OrderTask {
	@Autowired
	private AppUserOrderService orderService;

	public void clearNonPaymentOrder() {
		AppUserOrder order = new AppUserOrder();
		order.setStatus(Constants.ORDER_STATUS_PAYMENT);
		List<AppUserOrder> list = orderService.getUnderway(order);
		
	}
}
