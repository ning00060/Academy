package com.tenco.controller.staff;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.mysql.cj.Session;
import com.tenco.Repo.interfaces.staff.StaffRepository;
import com.tenco.Repo.interfaces.student.StudentRepository;
import com.tenco.Repo.interfaces.temp.EnrollRepository;
import com.tenco.Repo.staff.StaffRepositoryImpl;
import com.tenco.Repo.student.StudentRepositoryImpl;
import com.tenco.Repo.temp.EnrollRepositoryImpl;
import com.tenco.model.student.StudentDTO;
import com.tenco.model.temp.EnrollDTO;

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

		switch (action) {

		case "/schedule":
			System.out.println("스케쥴이동");
			schedulePage(request, response);

			break;
		case "/subjectList":
			System.out.println("서브젝트리스트");
			subjectList(request,response);
			
			
			break;

		default:
			break;
		}
		
	}

	private void subjectList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		StudentDTO studentDTO=studentRepository.selectStudentById(2023000001);
		List<EnrollDTO> enrollList=enrollRepository.selectByStudentId( studentDTO.getId());
		request.setAttribute("enrollList", enrollList);
		request.getRequestDispatcher("/WEB-INF/views/temp/schedule.jsp").forward(request, response);
	}


	private void schedulePage(HttpServletRequest request, HttpServletResponse response) {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getPathInfo();

		switch (action) {

		case "/notice":
			System.out.println("notice이동");
			noticePage(request, response);

			break;

		default:
			break;
		}

	}


	private void noticePage(HttpServletRequest request, HttpServletResponse response) {
		request.getParameter("noticeTitle");
		request.getParameter("noticeContent");
		request.getParameter("noticeCreated");
		
	}
	

}
