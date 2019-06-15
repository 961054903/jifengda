package com.caogen.jfd.filter;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.service.user.AppUserService;

/**
 * 
 * @author Spuiln
 *
 */
public class AppFilter implements Filter {

	@Autowired
	private AppUserService userService;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String head = request.getParameter("code");
		String token = request.getParameter("desc");
		String message = request.getParameter("data");
		if (Integer.parseInt(head.substring(0, 6)) != message.length()) {
			
		}
		AppUser user = userService.getByToken(token);
		if (user == null) {
			response.getWriter();
		}

		chain.doFilter(request, response);
//		String token = ((HttpServletRequest) request).getHeader("token");
//		if (StringUtils.isEmpty(token)) {
//			throw new RuntimeException("token null");
//		}
//		AppUser user = appUserService.getByToken(token);
//		if (user == null) {// 用户不存在或token已过期
//			throw new RuntimeException("user null");
//		}
//		String message = getRequestBody((HttpServletRequest) request);
//		int len = Integer.parseInt(message.substring(0, 6));
//		String type = message.substring(6, 8);
//		String code = message.substring(8, 10);
//		String data = message.substring(10);
//		if (data.length() != len) {
//			throw new RuntimeException("format error");
//		}
//		if (code.equals("00")) {// 默认密钥和向量解密
//
//		} else {// 数据库查询密钥和向量解密
//
//		}
//		WrappedRequest wr = new WrappedRequest((HttpServletRequest) request);
//		wr.setParameter("id", user.getId());
//		wr.setParameter("type", type);
//		wr.setParameter("data", data);
//		chain.doFilter(wr, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	/**
	 * 获取报文体
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	private String getRequestBody(HttpServletRequest request) throws IOException {
		BufferedReader reader = request.getReader();
		StringBuffer sb = new StringBuffer();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}

}
