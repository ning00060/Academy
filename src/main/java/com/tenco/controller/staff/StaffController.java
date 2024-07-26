package com.tenco.controller.staff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.staff.StaffRepository;
import com.tenco.Repo.interfaces.student.StudentRepository;
import com.tenco.Repo.interfaces.temp.EnrollRepository;
import com.tenco.Repo.interfaces.temp.NoticeRepository;
import com.tenco.Repo.interfaces.temp.StudentScholarRepository;
import com.tenco.Repo.interfaces.temp.TuitionRepository;
import com.tenco.Repo.staff.StaffRepositoryImpl;
import com.tenco.Repo.student.StudentRepositoryImpl;
import com.tenco.Repo.temp.EnrollRepositoryImpl;
import com.tenco.Repo.temp.NoticeRepositoryImpl;
import com.tenco.Repo.temp.StudentScholarRepositoryImpl;
import com.tenco.Repo.temp.TuitionRepositoryImpl;
import com.tenco.model.staff.StaffDTO;
import com.tenco.model.student.StudentDTO;
import com.tenco.model.temp.NoticeDTO;
import com.tenco.model.temp.StudentScholarDTO;
import com.tenco.model.temp.TuitionDTO;
import com.tenco.model.user.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/staff/*")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private static StaffRepository staffRepository;
       private static StudentRepository studentRepository;
       private static EnrollRepository enrollRepository;
       private static StudentScholarRepository scholarRepository;
       private static TuitionRepository	tuitionRepository;
       private static NoticeRepository	noticeRepository;

    public StaffController() {
    	staffRepository=new StaffRepositoryImpl();
    	studentRepository= new StudentRepositoryImpl();
    	enrollRepository=new EnrollRepositoryImpl();
    	scholarRepository = new StudentScholarRepositoryImpl();
    	tuitionRepository=new TuitionRepositoryImpl();
    	noticeRepository = new NoticeRepositoryImpl();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		switch (action) {

		case "/schedule":
			schedulePage(request, response);

			break;
		case "/tuition":
			
			tuition(request,response);
			
			break;
		case "/tuitionModify":
			
			request.getRequestDispatcher("/WEB-INF/views/staff/tuition_regist.jsp").forward(request, response);
			
			break;
			
		case "/scholarship":
			scholarshipPage(request,response);
			
			break;
		case "/subjectList":
			subjectList(request,response);
			
			break;
		case "/registStaff":
			request.getRequestDispatcher("/WEB-INF/views/staff/regist_staff.jsp").forward(request, response);
			break;
		case "/registStu":
			request.getRequestDispatcher("/WEB-INF/views/staff/regist_stu.jsp").forward(request, response);
			break;
		case "/registPro":
			request.getRequestDispatcher("/WEB-INF/views/staff/regist_pro.jsp").forward(request, response);
			break;

		default:
			break;
		}
		
	}







	private void scholarshipPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List< StudentScholarDTO> studentScholarDTO= scholarRepository.selectStudentScholarAll();
		if(studentScholarDTO!=null) {
			
		request.setAttribute("studentScholarDTO", studentScholarDTO);
		request.getRequestDispatcher("/WEB-INF/views/staff/scholarship.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/user/login");
		}
		
	}


	private void tuition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List< TuitionDTO> tuiList= tuitionRepository.selectTuitionAll();
		if(tuiList!=null) {
		request.setAttribute("tuiList", tuiList);
		request.getRequestDispatcher("/WEB-INF/views/staff/tuition.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/user/login");
		}
		
		
		
	}


	private void subjectList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		StudentDTO studentDTO=studentRepository.selectStudentById(2023000001);
//		List<EnrollDTO> enrollList=enrollRepository.selectByStudentId( studentDTO.getId());
//		request.setAttribute("enrollList", enrollList);
		request.getRequestDispatcher("/WEB-INF/views/temp/schedule.jsp").forward(request, response);
	}


	private void schedulePage(HttpServletRequest request, HttpServletResponse response) {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		switch (action) {

		case "/notice":
			System.out.println("notice이동");
			noticePage(request, response, session);
			break;
			
		case "/tuition":
			tuitionRegist(request,response);
			break;
			
		case "/tuitionModify":
			tuitionModify(request,response);
			break;
			
		case "/tuitionDelete":
			tuitionDelete(request,response);
			break;
			
		case "/registStu":
			registStuPage(request,response,session);
			break;
			
		case "/registPro":
			registProPage(request,response,session);
			break;
			
		case "/registStaff":
			registStaffPage(request,response,session);
			break;
		default:
			break;
		}

	}
	


	private void tuitionDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt( request.getParameter("id"));
		tuitionRepository.deleteTution(id);
		request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
	}


	private void tuitionModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt( request.getParameter("id"));
		int tuiYear=Integer.parseInt( request.getParameter("tuiYear"));
		int semester=Integer.parseInt( request.getParameter("semester"));
		int tuiId=Integer.parseInt( request.getParameter("tuiId"));
		int schType=Integer.parseInt( request.getParameter("schType"));
		int status=Integer.parseInt( request.getParameter("status"));
		
		TuitionDTO tuitionDTO=TuitionDTO.builder()
				.id(id)
				.tuiYear(tuiYear)
				.semester(semester)
				.tuiId(tuiId)
				.schType(schType)
				.status(status)
				.build();
		tuitionRepository.updateTution(tuitionDTO, id);
		request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
		
	}


	private void tuitionRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt( request.getParameter("id"));
		int tuiYear=Integer.parseInt( request.getParameter("tuiYear"));
		int semester=Integer.parseInt( request.getParameter("semester"));
		int tuiId=Integer.parseInt( request.getParameter("tuiId"));
		int schType=Integer.parseInt( request.getParameter("schType"));
		int status=Integer.parseInt( request.getParameter("status"));
		
		TuitionDTO tuitionDTO=TuitionDTO.builder()
				.id(id)
				.tuiYear(tuiYear)
				.semester(semester)
				.tuiId(tuiId)
				.schType(schType)
				.status(status)
				.build();
		tuitionRepository.addTuition(tuitionDTO);
		request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
		
		
	}


	private void registProPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String name= request.getParameter("name");
		String birth=request.getParameter("birthDate");
		String gender= request.getParameter("gender");
		String address= request.getParameter("address");
		String tel= request.getParameter("tel");
		String email= request.getParameter("email");
		String passwrod=request.getParameter("password");
		int deptId=Integer.parseInt( request.getParameter("deptId"));
		
		
//		ProfessorDTO professorDTO=ProfessorDTO.builder()
//				.name(name)
//				.birthDate(birth)
//				.gender(gender)
//				.address(address)
//				.tel(tel)
//				.email(email)
//				.build();
//		System.out.println( professorDTO.toString());
//		if(professorDTO==null) {
//			response.sendRedirect(request.getContextPath()+"/user/login");
//			}
//		else {
//			staffRepository.addUserStaff(professorDTO, passwrod);
//			request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
//			}
//		}
		
	}


	private void registStuPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		String name= request.getParameter("name");
		String birth=request.getParameter("birthDate");
		String gender= request.getParameter("gender");
		String address= request.getParameter("address");
		String tel= request.getParameter("tel");
		String email= request.getParameter("email");
		int dept_id=Integer.parseInt( request.getParameter("deptId"));
		String entranceDate=request.getParameter("entranceDate");
		String password=request.getParameter("password");
		
		
		StudentDTO studentDTO=StudentDTO.builder()
				.name(name)
				.birth_date(birth)
				.gender(gender)
				.address(address)
				.tel(tel)
				.email(email)
				.dept_id(dept_id)
				.entrance_date(entranceDate)
				.build();
		System.out.println( studentDTO.toString());
		if(studentDTO==null) {
			response.sendRedirect(request.getContextPath()+"/user/login");
			}
		else {
			staffRepository.addUserStudent(studentDTO, password);
			request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
			}
		}
		
	


	private void registStaffPage(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException, ServletException {
	String name= request.getParameter("name");
	String birth=request.getParameter("birthDate");
	String gender= request.getParameter("gender");
	String address= request.getParameter("address");
	String tel= request.getParameter("tel");
	String email= request.getParameter("email");
	String password=request.getParameter("password");

	
	
	StaffDTO staffDTO=StaffDTO.builder()
			.name(name)
			.birthDate(birth)
			.gender(gender)
			.address(address)
			.tel( tel)
			.email(email)
			.build();
	System.out.println( staffDTO.toString());
	if(staffDTO==null) {
		response.sendRedirect(request.getContextPath()+"/user/login");
		}
	else {
		staffRepository.addUserStaff(staffDTO, password);
		request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
		}
	}


	private void noticePage(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws ServletException, IOException {
		// 공지사항 getAll
		UserDTO userDTO=(UserDTO) session.getAttribute("verifiedUser");
		
		
		int page = 1; // 기본 페이지 번호 
		int pageSize = 10; // 한 페이지당 보여질 게시글에 수  
		
		try {
			 String pageStr = request.getParameter("page");
			 if(pageStr != null ) {
				 page = Integer.parseInt(pageStr);
			 }
		} catch (Exception e) {
			page = 1; 
		}
		
		int offset = (page - 1) * pageSize; // 시작 위치 계산( offset 값 계산)
 		List<NoticeDTO> noticeList = noticeRepository.SelectNoitceAllLimit10(pageSize, offset);
		
		// 전체 게시글 수 조회 
		int totalBoards = noticeRepository. selectNoticeCountAll();
		// 총 페이지 수 계산 -->  [1][2][3][...]
		int totalPages = (int) Math.ceil((double)totalBoards / pageSize);
		
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("currentPage", page);
		
		// 현재 로그인한 사용자 ID 설정 
		if(session != null) {
 			 UserDTO user = (UserDTO)session.getAttribute("principal");
 			 if(user != null) {
 				 request.setAttribute("userId", user.getId());
 			 }
		}
		request.getRequestDispatcher("/WEB-INF/views/temp/notice.jsp").forward(request, response);
	
	}
	

}
