package com.tenco.controller;

import java.io.IOException;

import com.tenco.Repo.user.UserRepositoryImpl;
import com.tenco.model.user.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;




@WebServlet("/user/*") 
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
		System.out.println(action+"/doget");
		switch (action) {

		case "/findId":	
			break;
		case "/findPw":
			break;

		
		case "/My":
			// TODO - /학생이 My 페이지로 이동하는지 확인하기 위해서 임시로 jsp를 생성함 - 경로 및 파일 삭제예정
			handleMypage(request, response);
			request.getRequestDispatcher("/test_Mypage.jsp").forward(request, response);
			break;

		case "/home":
			request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
			break;	

		default:
			break;
		}
	}
	/**
	 * 학생 Mypage 로그인 후 내 정보 조회가 먼저 출력된다.
	 * @param request
	 * @param response
	 */
	private void handleMypage(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		System.out.println(action);
		switch (action) {
		case "/login":
			System.out.println("/login 됨");
			handleLogin(request, response);
			break;
		default:
			break;
		}

	}
	
	// TODO 여기 들어오기전 필터 체크 
	// index.html - login button Pressed, Activate
	private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

			response.sendRedirect(request.getContextPath()+"/user/home");
		}else {
			System.out.println("login실패");
			//TODO 로그인 실패 알람 전송
		}
		
	}

}
