package com.caogen.jfd.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.caogen.jfd.exception.DefinedException;
import com.caogen.jfd.model.Message;

/**
 * 
 * @author Spuiln
 *
 */
@ControllerAdvice
public class ExcepionController {

	@ExceptionHandler(DefinedException.class)
	public Message error(DefinedException e) {
		Message message = new Message();
		message.setCode(e.getError().getCode());
		message.setDesc(e.getError().getDesc());
		return message;
	}
}
