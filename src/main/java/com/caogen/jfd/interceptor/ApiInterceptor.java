package com.caogen.jfd.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.caogen.jfd.common.ErrorCode;
import static com.caogen.jfd.common.Constants.*;
import com.caogen.jfd.exception.DefinedException;
import com.caogen.jfd.service.user.AppUserService;

public class ApiInterceptor implements HandlerInterceptor {

	@Autowired
	private AppUserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String head = request.getParameter(REQUEST_HEAD);
		String token = request.getParameter(REQUEST_TOKEN);
		String message = request.getParameter(REQUEST_MESSAGE);
		// 检查参数
		if (StringUtils.isEmpty(head) || StringUtils.isEmpty(token) || StringUtils.isEmpty(message)) {
			throw new DefinedException(ErrorCode.PARAM_MISSING);
		}
		// 校验报文长度
		int len = Integer.parseInt(head.substring(LEN_START, LEN_END));
		if (message.length() != len) {
			throw new DefinedException(ErrorCode.PARAM_ILLEGALITY);
		}
		//
		String type = head.substring(TYPE_START, TYPE_END);
		WrappedRequest wr = new WrappedRequest(request);
		// TODO
		String path = request.getServletPath().replace(PATH_TARGET, PATH_REPLACEMENT);
		request.getRequestDispatcher(path).forward(wr, response);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
