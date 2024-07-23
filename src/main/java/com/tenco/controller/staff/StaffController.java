package com.tenco.controller.staff;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.tenco.Repo.interfaces.staff.StaffRepository;
import com.tenco.Repo.staff.StaffRepositoryImpl;

@WebServlet("/staff/*")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private static StaffRepository staffRepository;
       

    public StaffController() {
    	staffRepository=new StaffRepositoryImpl();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
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
