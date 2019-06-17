package com.caogen.jfd.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.exception.DefinedException;
import com.caogen.jfd.model.Message;

/**
 * 
 * @author Spuiln
 *
 */
@ControllerAdvice
public class ExcepionController {

	@ResponseBody
	@ExceptionHandler(DefinedException.class)
	public Message error(DefinedException e) {
		Message message = new Message();
		message.setCode(e.getError().getCode());
		message.setDesc(e.getError().getDesc());
		return message;
	}

	@ResponseBody
	@ExceptionHandler(Exception.class)
	public Message exception(Exception e) {
		Message message = new Message();
		message.setCode(ErrorCode.FAIL.getCode());
		message.setDesc(ErrorCode.FAIL.getDesc());
		return message;
	}
}
