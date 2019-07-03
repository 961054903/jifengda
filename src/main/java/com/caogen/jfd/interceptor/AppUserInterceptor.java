package com.caogen.jfd.interceptor;

import static com.caogen.jfd.common.Constants.DECODE_DEFAULT;
import static com.caogen.jfd.common.Constants.DECODE_SECRETKEY;
import static com.caogen.jfd.common.Constants.DES_IV;
import static com.caogen.jfd.common.Constants.DES_KEY;
import static com.caogen.jfd.common.Constants.PATH_REPLACEMENT;
import static com.caogen.jfd.common.Constants.PATH_TARGET_USER;
import static com.caogen.jfd.common.Constants.REQUEST_BODY;
import static com.caogen.jfd.common.Constants.REQUEST_HEAD;
import static com.caogen.jfd.common.Constants.REQUEST_TOKEN;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.exception.DefinedException;
import com.caogen.jfd.service.user.AppUserService;
import com.caogen.jfd.util.SecretUtils;

/**
 * 
 * @author Spuiln
 *
 */
public class AppUserInterceptor implements HandlerInterceptor {

	@Autowired
	private AppUserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = request.getParameter(REQUEST_TOKEN);
		String head = request.getParameter(REQUEST_HEAD);
		String ciphertext = request.getParameter(REQUEST_BODY);
		
		StaticLogger.info("===head=== " + head);
		StaticLogger.info("===token=== " + token);
		StaticLogger.info("===ciphertext=== " + ciphertext);
		
		// 检查参数
		if (StringUtils.isEmpty(head) || StringUtils.isEmpty(token) || StringUtils.isEmpty(ciphertext)) {
			throw new DefinedException(ErrorCode.PARAM_MISSING);
		}
		// 验证用户
		AppUser user = userService.getByToken(token);
		if (user == null) {
			throw new DefinedException(ErrorCode.FAIL);
		}
		// 解密
		String key, iv;
		if (head.equals(DECODE_DEFAULT)) {
			key = DES_KEY;
			iv = DES_IV;
		} else if (head.equals(DECODE_SECRETKEY)) {
			key = user.getDes_key();
			iv = user.getDes_iv();
		} else {
			throw new DefinedException(ErrorCode.PARAM_ILLEGALITY);
		}
		String plaintext = SecretUtils.desedeDecode(ciphertext.replace(" ", "+"), key, iv);
		StaticLogger.info("===plaintext=== " + plaintext);
		// 转发
		WrappedRequest wr = new WrappedRequest(request);
		wr.setParameter("data", plaintext);
		String path = request.getServletPath().replace(PATH_TARGET_USER, PATH_REPLACEMENT);
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
