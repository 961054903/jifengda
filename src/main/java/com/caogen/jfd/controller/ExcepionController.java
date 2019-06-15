package com.caogen.jfd.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.caogen.jfd.exception.DefinedException;
import com.caogen.jfd.model.Message;

@ControllerAdvice
public class ExcepionController {
	@ExceptionHandler(DefinedException.class)
	public Message error(Exception e) {
		return null;
	}
}
