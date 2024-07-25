package com.tenco.controller;

import java.io.IOException;
import java.util.List;

import com.tenco.Repo.interfaces.student.StudentRepository;
import com.tenco.Repo.interfaces.temp.NoticeRepository;
import com.tenco.Repo.interfaces.temp.ScheduleRepository;
import com.tenco.Repo.student.StudentRepositoryImpl;
import com.tenco.Repo.temp.NoticeRepositoryImpl;
import com.tenco.Repo.temp.ScheduleRepositoryImpl;
import com.tenco.Repo.user.UserRepositoryImpl;
import com.tenco.model.student.StudentDTO;
import com.tenco.model.subject.UsersSubjectDTO;
import com.tenco.model.temp.EvaluationQuestionDTO;
import com.tenco.model.temp.NoticeDTO;
import com.tenco.model.temp.ScheduleDTO;
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
	private NoticeRepository noticeRepository;// 공지사항
	private ScheduleRepository scheduleRepository;// 학사일정
	private StudentRepository studentRepository;

	public UserController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		userRepositoryImpl = new UserRepositoryImpl();
		noticeRepository = new NoticeRepositoryImpl();

		scheduleRepository = new ScheduleRepositoryImpl();
		studentRepository = new StudentRepositoryImpl();

		scheduleRepository = new ScheduleRepositoryImpl();

		System.out.println("12");
	}

	// 아이디 찾기, 비밀번호 찾기 sendredirect
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		System.out.println(action + "/doget");
		switch (action) {

		case "/findId":
			break;
		case "/findPw":
			break;

		case "/evaluation":
			System.out.println("학생 -> 강의평가를 위한 내 강의 조회 폼 진입");
			request.getRequestDispatcher("/WEB-INF/views/student/select.jsp").forward(request, response);
			break;
		case "/readmysubject":
			System.out.println("학생ID, 강의 개설년도, 개설학기 정보를 받아 내 강의 리스트 폼 진입");
			handleMySubject(request, response);
			break;
		case "/goevaluation":
			System.out.println("강의평가 설문 폼 진입");
			handleEvaluation(request,response);
			break;



		case "/myInfo":
			// TODO - /학생이 My 페이지로 이동하는지 확인하기 위해서 임시로 jsp를 생성함 - 경로 및 파일 삭제예정
			handleMypage(request, response);
			break;

		case "/home":
			request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
			break;

		case "/Myinformation":
			System.out.println("/학생 정보 조회시도");
			handleInformation(request, response);

		case "/update":
			System.out.println("/학생 정보 수정페이지 이동시도");
			handleInfoModify(request, response);
			
		case "/myInfomodifyUpdate":
			// TODO - 내 정보를 수정하고 변경 버튼을 클릭 시 get 방식으로 이동한다.

		case "/a":
			HttpSession session = request.getSession();
			List<NoticeDTO> noticeList = noticeRepository.SelectNoitceAll5();
			request.setAttribute("noticeList", noticeList);
			// 학사일정 getAll
			List<ScheduleDTO> scheduleList = scheduleRepository.SelectScheduleAll5();
			request.setAttribute("scheduleList", scheduleList);
			UserDTO temp = (UserDTO)session.getAttribute("verifiedUser");
			StudentDTO student = studentRepository.studentInfo(temp.getId());
			session.setAttribute("studentDTO", student);
			request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}
<<<<<<< HEAD
	
	private void handleEvaluation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EvaluationQuestionDTO questions = studentRepository.getEvaluationQuestion();
        request.setAttribute("questions", questions);
        String subjectName = request.getParameter("subjectName");
        String subjectId = request.getParameter("subjectId");
        request.setAttribute("subjectId", subjectId);
        request.setAttribute("subjectName", subjectName);
        request.getRequestDispatcher("/WEB-INF/views/student/evaluation.jsp").forward(request, response);
    }
=======
	private void handleEvaluation(HttpServletRequest request, HttpServletResponse response) {
		

		
	}
>>>>>>> 0d9931b8e86df7f7a508c9a297c3a822dc2bf597

	/**
	 * 학생 정보 수정 페이지로 이동
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void handleInfoModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("verifiedUser");
		StudentDTO studentDTO = studentRepository.studentInfo(userDTO.getId());
		request.setAttribute("verifiedUser", userDTO );
		request.setAttribute("studentDTO", studentDTO);
		System.out.println("학생 정보 수정: " + studentDTO.toString());
		request.getRequestDispatcher("/WEB-INF/views/myInfo2.jsp").forward(request, response);

	}

	private void handleMySubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("내 강의 조회 메서드 진입");

		String year = request.getParameter("year");
		String semester = request.getParameter("semester");
		String studnetId = request.getParameter("studentId");
		List<UsersSubjectDTO> subjectList = studentRepository.readMySubject(Integer.parseInt(studnetId),
				Integer.parseInt(year), Integer.parseInt(semester));
		System.out.println(subjectList.toString());
		request.setAttribute("subjectList", subjectList);

		
		request.getRequestDispatcher("/WEB-INF/views/student/studentsubject.jsp").forward(request, response);


	}

	/**
	 * 학생 Mypage 버튼 클릭 후 내 정보 조회가 먼저 출력된다.
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void handleMypage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("verifiedUser");
		System.out.println("handleMypage : " + userDTO.toString());
		System.out.println(userDTO.getId());
		StudentDTO studentDTO = studentRepository.studentInfo(userDTO.getId());
		System.out.println(studentDTO.toString() + "학생DTO@");
		request.setAttribute("studentDTO", studentDTO);

		System.out.println(userDTO.getId());
		
		request.getRequestDispatcher("/WEB-INF/views/myInfo.jsp").forward(request, response);

	}

	/**
	 * 학생이 정보 조회 시도
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void handleInformation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("verifiedUser");

		StudentDTO studentDTO = studentRepository.studentInfo(userDTO.getId());
		System.out.println(studentDTO.toString() + "학생DTO@");
		request.setAttribute("studentDTO", studentDTO);
		request.getRequestDispatcher("/WEB-INF/views/myInfo.jsp").forward(request, response);
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
			
		case "/update":
			System.out.println("학생 정보 변경 시도");
			handlemyInfoModify(request, response);
			break;

		default:
			break;
		}

	}
	/**
	 * 학생이 정보를 수정하면 실행하는 메서드 이다.
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void handlemyInfoModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("verifiedUser");
		StudentDTO studentDTO = studentRepository.studentInfo(userDTO.getId());
		System.out.println(studentDTO.toString());
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("1 "+address);
		System.out.println("2 "+tel);
		System.out.println("3 "+password);
			
		studentRepository.studentInfoModify(password, email, tel, address, userDTO.getId());
		
		studentDTO = studentRepository.studentInfo(userDTO.getId());
			System.out.println("변경 성공");
			System.out.println(studentDTO.toString());
			
	}

	// TODO 여기 들어오기전 필터 체크
	// index.html - login button Pressed, Activate
	private void handleLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("asdf");
		UserDTO userDTO = null;
		// TODO - getparameter data 필수 작성!!!!!!!!!!!!!!!!!!!!
		int id = Integer.parseInt(request.getParameter("id")); 
		String password = (String) request.getParameter("password"); 
		if ((userDTO = userRepositoryImpl.userLogin(id, password)) != null) { 
			// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("verifiedUser", userDTO);
			// 공지사항 getAll
			List<NoticeDTO> noticeList = noticeRepository.SelectNoitceAll5();
			request.setAttribute("noticeList", noticeList);
			// 학사일정 getAll
			List<ScheduleDTO> scheduleList = scheduleRepository.SelectScheduleAll5();
			request.setAttribute("scheduleList", scheduleList);
			System.out.println("login성공");
			// 학생유저 정보
			StudentDTO student = studentRepository.studentInfo(userDTO.getId());
			session.setAttribute("studentDTO", student);
			// permission-level 확인 1=학생, 2=교수, 3= 관리직
			// TODO - main page로 이동

			request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
		} else {
			System.out.println("login실패");
			response.sendRedirect(request.getContextPath() + "/user/login");
			// TODO 로그인 실패 알람 전송
		}

	}

}
