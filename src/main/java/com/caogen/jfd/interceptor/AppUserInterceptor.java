package com.caogen.jfd.interceptor;

import static com.caogen.jfd.common.Constants.REQUEST_BODY;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.caogen.jfd.common.StaticLogger;

/**
 * 
 * @author Spuiln
 *
 */
public class AppUserInterceptor implements HandlerInterceptor {

	/*-
	@Autowired
	private AppUserService userService;
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			StaticLogger.info("===path=== " + request.getServletPath());
			String token = request.getParameter(REQUEST_TOKEN);
			String head = request.getParameter(REQUEST_HEAD);
			String ciphertext = request.getParameter(REQUEST_BODY);
			// 检查参数
			if (StringUtils.isEmpty(head) || StringUtils.isEmpty(token)) {
				throw new DefinedException(ErrorCode.PARAM_MISSING);
			}
			// 不需要解密操作
			if (StringUtils.isEmpty(ciphertext)) {
				return true;
			}
			// 验证用户
			AppUser user = userService.getByToken(token);
			if (user == null || !user.getState().equals(State.normal)) {
				throw new DefinedException(ErrorCode.LOGIN_USER_ERROR);
			}
			// 解密密钥和向量
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
			// 解密
			String plaintext = SecretUtils.desedeDecode(ciphertext.replace(" ", "+"), key, iv);
			StaticLogger.info("<<<<<<" + plaintext);
			// 转发
			WrappedRequest wr = new WrappedRequest(request);
			wr.setParameter(REQUEST_BODY, plaintext);
			String path = request.getServletPath().replace(PATH_TARGET_USER, PATH_REPLACEMENT);
			request.getRequestDispatcher(path).forward(wr, response);
			return false;
		}*/

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		StaticLogger.info("===path=== " + request.getServletPath());
		StaticLogger.info("<<<<<<" + request.getParameter(REQUEST_BODY));
		return true;
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
