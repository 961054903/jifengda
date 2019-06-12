package com.caogen.jfd.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 因为HttpServletRequest只提供了getParameter()，而没有提供setParameter()
 * 所以写一个HttpServletRequest类继承HttpServletRequestWrapper，然后覆盖里面的方法，并且增加setParameters方法
 * 
 * @author Spuiln
 *
 */
public class WrappedRequest extends HttpServletRequestWrapper {

	private Map<String, String[]> params = new HashMap<String, String[]>();

	public WrappedRequest(HttpServletRequest request) {
		super(request);
		this.params.putAll(request.getParameterMap());
	}

	@Override
	public String getParameter(String name) {
		String[] values = params.get(name);
		if (values == null || values.length == 0) {
			return null;
		}
		return params.get(name)[0];
	}

	@Override
	public String[] getParameterValues(String name) {
		return params.get(name);
	}

	public void setParameters(Map<String, Object> params) {
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			setParameter(entry.getKey(), entry.getValue());
		}
	}

	public void setParameter(String name, Object value) {
		if (value != null) {
			if (value instanceof String[]) {
				params.put(name, (String[]) value);
			} else if (value instanceof String) {
				params.put(name, new String[] { (String) value });
			} else {
				params.put(name, new String[] { String.valueOf(value) });
			}
		}
	}

}
