package com.tenco.controller;

import java.io.IOException;
import java.util.List;

import com.tenco.Repo.interfaces.temp.NoticeRepository;
import com.tenco.Repo.interfaces.temp.ScheduleRepository;
import com.tenco.Repo.temp.NoticeRepositoryImpl;
import com.tenco.Repo.temp.ScheduleRepositoryImpl;
import com.tenco.Repo.user.UserRepositoryImpl;
import com.tenco.model.temp.NoticeDTO;
import com.tenco.model.temp.ScheduleDTO;
import com.tenco.model.user.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/user/*") 
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserRepositoryImpl userRepositoryImpl;
	private NoticeRepository noticeRepository;//공지사항
	private ScheduleRepository scheduleRepository;//학사일정

	public UserController() {
		super();
	}

	
    @Override
    public void init() throws ServletException {
    	userRepositoryImpl = new UserRepositoryImpl();
    	noticeRepository= new NoticeRepositoryImpl();
    	scheduleRepository=new ScheduleRepositoryImpl();
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
		case "/home":
			request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
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
			handleLogin(request,response);
			break;

		default:
			break;
		}

	}
	
	// TODO 여기 들어오기전 필터 체크 
	// index.html - login button Pressed, Activate
	private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("asdf");
		UserDTO userDTO = null;
		
		//TODO - getparameter data 필수 작성!!!!!!!!!!!!!!!!!!!!
		
		int id = Integer.parseInt(request.getParameter("id"));
		String password = (String) request.getParameter("password");
		if ((userDTO = userRepositoryImpl.userLogin(id, password)) != null) {
			// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("verifiedUser", userDTO);
			// 공지사항 getAll
			List<NoticeDTO> noticeList=noticeRepository.SelectNoitceAll5();
			request.setAttribute("noticeList", noticeList);
			// 학사일정 getAll
			List<ScheduleDTO> scheduleList=scheduleRepository.SelectScheduleAll5();
			request.setAttribute("scheduleList", scheduleList);
			System.out.println("login성공");
			// permission-level 확인 1=학생, 2=교수, 3= 관리직
			// TODO - main page로 이동
			request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
		}else {
			System.out.println("login실패");
			response.sendRedirect(request.getContextPath()+"/user/login");
			//TODO 로그인 실패 알람 전송
		}
		
	}


}
