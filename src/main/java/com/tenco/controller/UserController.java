package com.tenco.controller;

import java.io.IOException;

import com.tenco.Repo.user.UserRepositoryImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserRepositoryImpl userRepositoryImpl;

	public UserController() {
		super();

	}

	@Override
	public void init() throws ServletException {
		userRepositoryImpl = new UserRepositoryImpl();
	}

	// 아이디 찾기, 비밀번호 찾기 sendredirect
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();

		switch (action) {
		case "/findId":

			break;

		case "/findPw":

			break;

		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();

		switch (action) {

		case "/login":

			handleLogin(request, response);

			break;

		default:
			break;
		}

	}

	int a;

	private void handleLogin(HttpServletRequest request, HttpServletResponse response) {
		// userLogin return 값은 1로 리턴! || Impl 수정 필요
		// if (userRepositoryImpl.userLogin("", "") == 1) {
		// 로그인 성공

		// permission-level 확인 1=학생, 2=교수, 3= 관리직
		HttpSession session = request.getSession();
		session.setAttribute("principal", a);
	}// else {
		// TODO 로그인 실패
		// }

	// }

}
