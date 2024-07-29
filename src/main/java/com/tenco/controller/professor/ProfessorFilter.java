package com.tenco.controller.professor;

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
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/professor/*")
public class ProfessorFilter extends HttpFilter implements Filter {

	public ProfessorFilter() {
		super();
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// downcasting ServletRequest -> HttpServletRequest
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		// GET HttpSession object
		HttpSession session = httpRequest.getSession();
		UserDTO userDTO = null;
		String msg = "";
		if ((userDTO = (UserDTO) session.getAttribute("verifiedUser")) == null) {
			msg = Define.NONE_VERIFIED_USER;
			session.invalidate();
		} else {
			// Logined user
			if (userDTO.getPermissionLevel() == 2) {
				// professor login | clear to pass
				chain.doFilter(request, response);
				return;
			} else {
				// other logined user | denied
				msg = Define.USER_PERMISSION_DENIED;
				session.removeAttribute("verifiedUser");
				session.invalidate();
			}
		}
		httpResponse.sendRedirect(httpRequest.getContextPath() + "?error=" + msg);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
