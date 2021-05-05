package com.house.health.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.house.health.entity.Admin;
import com.house.health.entity.Users;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class UserInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		response.setCharacterEncoding("utf-8");
		String url = request.getRequestURL().toString();

		if (url.indexOf("toIndexPage") >= 0 || url.indexOf("login") >= 0 || url.indexOf("regist") >= 0
				|| url.indexOf("toDetailsPage") >= 0 || url.indexOf("findHouseByLike") >= 0
				|| url.indexOf("findHousrOrderByAsc") >= 0 || url.indexOf("findHousrOrderByDesc") >= 0
				|| url.indexOf("toAdminLogin") >= 0||url.indexOf("adminAccess")>=0) {
			return true;
		}
		HttpSession session = request.getSession();
		Users u = (Users) session.getAttribute("loginUser");
		Admin admin = (Admin) session.getAttribute("Admin");
		if (u != null || admin != null) {
			return true;
		}
		request.getRequestDispatcher("/WEB-INF/pages/demo.jsp").forward(request, response);

		return false;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

	}
}
