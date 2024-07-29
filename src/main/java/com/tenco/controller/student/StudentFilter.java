package com.tenco.controller.student;

import java.io.IOException;

import com.tenco.Define;
import com.tenco.model.user.UserDTO;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter("/student/*")
public class StudentFilter extends HttpFilter implements Filter {

	public StudentFilter() {
		super();
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// downcasting ServletRequest -> HttpServletRequest
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		// GET HttpSession object
		HttpSession session = httpRequest.getSession();
		UserDTO userDTO = null;
		if((userDTO=(UserDTO)session.getAttribute("verifiedUser")) == null) {
			request.setAttribute("errorMSG",Define.NONE_VERIFIED_USER_ERROR);
			session.invalidate();
		}else {
			// Logined user
			if (userDTO.getPermissionLevel()==1) {
				//professor login | clear to pass
				chain.doFilter(request, response);
			
			}else {
				// other logined user |  denied 
				request.setAttribute("errorMSG",Define.USER_PERMISSION_ERROR);
				session.removeAttribute("verifiedUser");
				session.invalidate();
			}
		}
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
