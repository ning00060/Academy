package com.tenco.controller.staff;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.eclipse.tags.shaded.org.apache.regexp.RE;

import com.mysql.cj.Session;
import com.tenco.Repo.interfaces.staff.StaffRepository;
import com.tenco.Repo.interfaces.student.StudentRepository;
import com.tenco.Repo.interfaces.temp.EnrollRepository;
import com.tenco.Repo.staff.StaffRepositoryImpl;
import com.tenco.Repo.student.StudentRepositoryImpl;
import com.tenco.Repo.temp.EnrollRepositoryImpl;
import com.tenco.model.staff.StaffDTO;
import com.tenco.model.student.StudentDTO;
import com.tenco.model.temp.EnrollDTO;
import com.tenco.model.user.UserDTO;

@WebServlet("/staff/*")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private static StaffRepository staffRepository;
       private static StudentRepository studentRepository;
       private static EnrollRepository enrollRepository;
       

    public StaffController() {
    	staffRepository=new StaffRepositoryImpl();
    	studentRepository= new StudentRepositoryImpl();
    	enrollRepository=new EnrollRepositoryImpl();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		switch (action) {

		case "/schedule":
			System.out.println("스케쥴이동");
			schedulePage(request, response);

			break;
		case "/subjectList":
			System.out.println("서브젝트리스트");
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




	private void subjectList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
=======
		HttpSession session = request.getSession();
>>>>>>> 61459a7e0d62eb3bd851ee1941e7fa8319ceada5
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
			noticePage(request, response);
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


	private void registProPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
	}


	private void registStuPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
	}


	private void registStaffPage(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException, ServletException {
	String name= request.getParameter("name");
	String birth=request.getParameter("birthDate");
	String gender= request.getParameter("gender");
	String address= request.getParameter("address");
	String tel= request.getParameter("tel");
	String email= request.getParameter("email");
	String passwrod=request.getParameter("password");

	
	
	StaffDTO staffDTO=StaffDTO.builder()
			.name(name)
			.birthDate(birth)
			.gender(gender)
			.address(address)
			.tel(tel)
			.email(email)
			.build();
	System.out.println( staffDTO.toString());
	if(staffDTO==null) {
		response.sendRedirect(request.getContextPath()+"/user/login");
		}
	else {
		staffRepository.addUserStaff(staffDTO, passwrod);
		request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
		}
	}


	private void noticePage(HttpServletRequest request, HttpServletResponse response) {
		request.getParameter("noticeTitle");
		request.getParameter("noticeContent");
		request.getParameter("noticeCreated");
		
	}
	

}
