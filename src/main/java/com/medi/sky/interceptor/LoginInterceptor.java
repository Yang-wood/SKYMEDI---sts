package com.medi.sky.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.log4j.Log4j;

@Log4j
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final String LOGIN = "login";
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		String contextPath = request.getContextPath();
		
		Object memInfo = modelMap.get("memInfo");
		
		if (memInfo != null) {
			log.info("new login success");
			
			session.setAttribute(LOGIN, memInfo);
			
			String dest = (String)session.getAttribute("dest");		
			if (dest == null || dest.equals("null") || dest.contains("/login")) {
				dest = "/";
			}
			
			log.info("LoginInterceptor Dest : " + dest);
			
			modelAndView.setViewName("redirect:" + dest);
		}
	}
	
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		HttpSession session = request.getSession();
//		
//		if (session.getAttribute(LOGIN) != null) {
//			log.info("clear login data before");
//			
//			session.removeAttribute(LOGIN);
//		}
//		
//		return true;
//	}
}
