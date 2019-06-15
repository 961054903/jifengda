package com.caogen.jfd.exception;

import com.caogen.jfd.common.ErrorCode;

/**
 * 
 * @author Spuiln
 *
 */
public class DefinedException extends Exception {

	private static final long serialVersionUID = -5103774988551641390L;
	private ErrorCode error;

	public DefinedException() {
		super();
	}

	public DefinedException(ErrorCode error) {
		super();
		this.error = error;
	}

	@Override
	public String getMessage() {
		return error.getDesc();
	}

	public ErrorCode getError() {
		return error;
	}

	public void setError(ErrorCode error) {
		this.error = error;
	}

}
