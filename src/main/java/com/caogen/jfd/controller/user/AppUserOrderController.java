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
import com.caogen.jfd.entity.user.AppUserOrder;
import com.caogen.jfd.entity.user.AppUserSite;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.user.AppUserOrderService;
import com.caogen.jfd.service.user.AppUserService;

/**
 * 
 * @author Spuiln
 *
 */
@Controller
@RequestMapping("order")
public class AppUserOrderController {
	@Autowired
	private AppUserService userService;
	@Autowired
	private AppUserOrderService orderService;

	/**
	 * 统计订单数量
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "count", "api/count" })
	public Message count(String data) {
		Message message = new Message();
		try {
			AppUserOrder order = Constants.gson.fromJson(data, AppUserOrder.class);
			AppUser user = userService.getByPhone(order.getPhone());
			order.setUser_id(user.getId());
			Integer num = orderService.count(order);
			message.setData(num, user.getDes_key(), user.getDes_iv());
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.ORDER_ERROR);
			StaticLogger.error("user order count error", e);
		}
		return message;
	}

	/**
	 * 获取未完成的订单列表
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "underway", "api/underway" })
	public Message underway(String data) {
		Message message = new Message();
		try {
			AppUserOrder order = Constants.gson.fromJson(data, AppUserOrder.class);
			AppUser user = userService.getByPhone(order.getPhone());
			order.setUser_id(user.getId());
			List<AppUserOrder> list = orderService.getUnderway(order);
			message.setData(list, user.getDes_key(), user.getDes_iv());
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.ORDER_ERROR);
			StaticLogger.error("user order get all error", e);
		}
		return message;
	}

	/**
	 * 获取已完成的订单列表
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "finish", "api/finish" })
	public Message finish(String data) {
		Message message = new Message();
		try {
			AppUserOrder order = Constants.gson.fromJson(data, AppUserOrder.class);
			AppUser user = userService.getByPhone(order.getPhone());
			order.setUser_id(user.getId());
			List<AppUserOrder> list = orderService.getFinish(order);
			message.setData(list, user.getDes_key(), user.getDes_iv());
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.ORDER_ERROR);
			StaticLogger.error("user order get all error", e);
		}
		return message;
	}

	/**
	 * 计算价格
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "calculate", "api/calculate" })
	public Message calculate(String data) {
		Message message = new Message();
		try {
			AppUserOrder order = Constants.gson.fromJson(data, AppUserOrder.class);
			AppUserSite origin = Constants.gson.fromJson(order.getOrigin(), AppUserSite.class);
			AppUserSite[] destination = Constants.gson.fromJson(order.getDestination(), AppUserSite[].class);
			int distance = orderService.getDistance(origin, destination);
			double price = orderService.getPrice(order.getModel_id(), order.getType(), distance);

		} catch (Exception e) {
			message.setErrorCode(ErrorCode.ORDER_ERROR);
			StaticLogger.error("user order calculate price error", e);
		}
		return message;
	}
}
