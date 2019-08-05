package com.caogen.jfd.interceptor;

import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.entity.AppUser;
import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.exception.DefinedException;
import com.caogen.jfd.service.AppUserService;
import com.caogen.jfd.service.driver.AppDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.caogen.jfd.common.Constants.REQUEST_TOKEN;

public class CheckTokenInterceptor implements HandlerInterceptor {
	@Autowired
	private AppDriverService appDriverService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = request.getParameter(REQUEST_TOKEN);
		if (StringUtils.isEmpty(token)) {
			return true;
		}
		AppDriver driver =appDriverService.getByToken(token);
		if (driver == null) {
			throw new DefinedException(ErrorCode.TOKEN_PAST_DUE);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
