package com.tenco;

import java.util.logging.Logger;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionLinstener implements HttpSessionListener{

	private static final Logger logger = Logger.getLogger(SessionLinstener.class.getName());

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		logger.info("새로운 세션이 생성 됨 : " + se.getSession().getId());
		se.getSession().setAttribute("loginTime", System.currentTimeMillis());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		Long loginTime = (Long) se.getSession().getAttribute("loginTime");
		Long logoutTime = System.currentTimeMillis();
		
		
		
		if (loginTime != null) {
			

			Long sessionDurationMs = logoutTime - loginTime; // 밀리초 단위
			double sessionDurationSec = sessionDurationMs / 1000.0; // 초 단위로 변환
			logger.info("sessionDestroyed : "+se.getSession().getId());
		}
	}
}
