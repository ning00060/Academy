package com.tenco.controller;

import java.io.IOException;

import com.tenco.Repo.user.UserRepositoryImpl;
<<<<<<< HEAD
import com.tenco.model.user.UserDTO;
=======
>>>>>>> c3a544e11fbb61427eb1886c5ab70525f34b4a2b

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

<<<<<<< HEAD


@WebServlet("/user/*") 
=======
@WebServlet("/user/*")
>>>>>>> c3a544e11fbb61427eb1886c5ab70525f34b4a2b
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserRepositoryImpl userRepositoryImpl;

	public UserController() {
		super();
	}

	
    @Override
    public void init() throws ServletException {
    	userRepositoryImpl = new UserRepositoryImpl();
    	System.out.println("12");
    }
    
    // 아이디 찾기, 비밀번호 찾기 sendredirect
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

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
		System.out.println(action);
		switch (action) {

		case "/login":
<<<<<<< HEAD
			handleLogin(request,response);
=======
			System.out.println("/login 됨");
			handleLogin(request, response);

>>>>>>> c3a544e11fbb61427eb1886c5ab70525f34b4a2b
			break;

		default:
			break;
		}

	}
<<<<<<< HEAD
	
	// TODO 여기 들어오기전 필터 체크 
	// index.html - login button Pressed, Activate
	private void handleLogin(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("asdf");
		UserDTO userDTO = null;
		
		//TODO - getparameter data 필수 작성!!!!!!!!!!!!!!!!!!!!
		
		int id = Integer.parseInt(request.getParameter("id"));
		String password = (String) request.getParameter("password");
		
		if ((userDTO = userRepositoryImpl.userLogin(id, password)) != null) {
			// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("verifiedUser", userDTO);
			System.out.println("login성공");
			// permission-level 확인 1=학생, 2=교수, 3= 관리직
			// TODO - main page로 이동
		}else {
			System.out.println("login실패");
			//TODO 로그인 실패 알람 전송
		}
		
	}

=======


int a;
	private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usename = request.getParameter("username");
		String password = request.getParameter("password");
		// userLogin return 값은 1로 리턴! || Impl 수정 필요
		// if (userRepositoryImpl.userLogin("", "") == 1) {
		// 로그인 성공
		// permission-level 확인 1=학생, 2=교수, 3= 관리직
		HttpSession session = request.getSession();
		System.out.println("로그인까지옴");
		session.setAttribute("principal", a);
		 request.getRequestDispatcher("/WEB-INF/main-body.jsp").forward(request, response);
	}// else {
		// TODO 로그인 실패
		// }

	// }
>>>>>>> c3a544e11fbb61427eb1886c5ab70525f34b4a2b

}
