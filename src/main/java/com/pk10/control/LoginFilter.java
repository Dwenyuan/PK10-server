package com.pk10.control;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		Pattern compile = Pattern.compile("\\/(login|register|checkTel|checkusername)|userlogin\\.html|\\/build\\/.+");
		Matcher matcher = compile.matcher(req.getServletPath());
		boolean isFilter = matcher.find();
		if ("/userlogin.html".equals(req.getServletPath()) && req.getSession().getAttribute("userinfo") != null) { // 出去不需要过滤的静态资源或者已登录。。。
			// 当用户已登录时，再进入登录界面会直接跳转
			res.sendRedirect("index.html");
		} else if (isFilter || req.getSession().getAttribute("userinfo") != null) {
			chain.doFilter(request, response);
		} else {
			res.sendRedirect("userlogin.html");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
