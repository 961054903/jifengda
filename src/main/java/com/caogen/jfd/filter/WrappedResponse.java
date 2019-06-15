package com.caogen.jfd.filter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * 
 * @author Spuiln
 *
 */
public class WrappedResponse extends HttpServletResponseWrapper {

	public WrappedResponse(HttpServletResponse response) {
		super(response);
	}

}
