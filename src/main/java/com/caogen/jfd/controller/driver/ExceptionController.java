package com.caogen.jfd.controller.driver;

import com.caogen.jfd.exception.DefinedException;
import com.caogen.jfd.model.Message;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {

	@ResponseBody
	@ExceptionHandler(DefinedException.class)
	public Message definedException(DefinedException e) {
		Message message = new Message();
		message.setErrorCode(e.getError());
		return message;
	}
}
