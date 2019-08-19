package com.caogen.jfd.interceptor;

import static com.caogen.jfd.common.Constants.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.AppDriver;
import com.caogen.jfd.exception.DefinedException;
import com.caogen.jfd.service.AppDriverService;
import com.caogen.jfd.util.SecretUtils;

/**
 * @author Spuiln
 *
 */
public class AppDriverInterceptor implements HandlerInterceptor {

	@Autowired
	private AppDriverService driverService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = request.getParameter(REQUEST_TOKEN);
		String head = request.getParameter(REQUEST_HEAD);
		String ciphertext = request.getParameter(REQUEST_BODY);

		StaticLogger.info(token + " " + head + " " + ciphertext);
		// 检查参数
		if (StringUtils.isEmpty(head) || StringUtils.isEmpty(token)) {
			throw new DefinedException(ErrorCode.PARAM_MISSING);
		}
		// 不需要解密操作
		if (StringUtils.isEmpty(ciphertext)) {
			return true;
		}
		// 验证用户
		AppDriver driver = driverService.getByToken(token);
		if (driver == null) {
			throw new DefinedException(ErrorCode.FAIL);
		}
		// 解密
		String key, iv;
		if (head.equals(DECODE_DEFAULT)) {
			key = DES_KEY;
			iv = DES_IV;
		} else if (head.equals(DECODE_SECRETKEY)) {
			key = driver.getDes_key();
			iv = driver.getDes_iv();
		} else {
			throw new DefinedException(ErrorCode.PARAM_ILLEGALITY);
		}
		String plaintext = SecretUtils.desedeDecode(ciphertext.replace(" ", "+"), key, iv);
		// 转发
		WrappedRequest wr = new WrappedRequest(request);
		wr.setParameter("data", plaintext);
		String path = request.getServletPath().replace(PATH_TARGET_DRIVER, PATH_REPLACEMENT);
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
