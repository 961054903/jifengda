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
	public Message count(Message data) {
		Message message = new Message();
		try {
			AppUser user = userService.getByToken(data.getDesc());
			AppUserOrder order = new AppUserOrder();
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
	 * 获取进行中的订单列表
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "underway", "api/underway" })
	public Message underway(Message data) {
		Message message = new Message();
		try {
			AppUser user = userService.getByToken(data.getDesc());
			AppUserOrder order = new AppUserOrder();
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
	public Message finish(Message data) {
		Message message = new Message();
		try {
			AppUserOrder order = Constants.gson.fromJson((String) data.getData(), AppUserOrder.class);
			AppUser user = userService.getByToken(data.getDesc());
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
	public Message calculate(Message data) {
		Message message = new Message();
		try {
			AppUser user = userService.getByToken(data.getDesc());
			AppUserOrder order = Constants.gson.fromJson((String) data.getData(), AppUserOrder.class);
			AppUserSite origin = Constants.gson.fromJson(order.getOrigin(), AppUserSite.class);
			AppUserSite[] destination = Constants.gson.fromJson(order.getDestination(), AppUserSite[].class);
			int distance = orderService.getDistance(origin, destination);
			order.setKilometre(distance * 0.001);
			AppUserOrder entity = orderService.getPrice(order);
			message.setData(entity, user.getDes_key(), user.getDes_iv());
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.ORDER_ERROR);
			StaticLogger.error("user order calculate price error", e);
		}
		return message;
	}

	/**
	 * 创建订单
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "add", "api/add" })
	public Message add(Message data) {
		Message message = new Message();
		try {
			AppUser user = userService.getByToken(data.getDesc());
			AppUserOrder order = Constants.gson.fromJson((String) data.getData(), AppUserOrder.class);
			order.setUser_id(user.getId());
			orderService.create(order);
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.ORDER_ERROR);
			StaticLogger.error("user order add error", e);
		}
		return message;
	}

	/**
	 * 评价订单
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "evaluate", "api/evaluate" })
	public Message evaluate(String data) {
		Message message = new Message();
		try {
			AppUserOrder order = Constants.gson.fromJson(data, AppUserOrder.class);
			orderService.evaluate(order);
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.ORDER_ERROR);
			StaticLogger.error("user order evaluate error", e);
		}
		return message;
	}

	/**
	 * 订单详情
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "details", "api/details" })
	public Message details(Message data) {
		Message message = new Message();
		try {
			AppUser user = userService.getByToken(data.getDesc());
			AppUserOrder order = Constants.gson.fromJson((String) data.getData(), AppUserOrder.class);
			AppUserOrder entity = orderService.getOne(order);
			message.setData(entity, user.getDes_key(), user.getDes_iv());
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.ORDER_ERROR);
			StaticLogger.error("user order get details error", e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping(value = { "cancel", "api/cancel" })
	public Message cancel(Message data) {
		Message message = new Message();
		try {
			// TODO

		} catch (Exception e) {
			message.setErrorCode(ErrorCode.ORDER_ERROR);
			StaticLogger.error("user order get details error", e);
		}
		return message;
	}

}
