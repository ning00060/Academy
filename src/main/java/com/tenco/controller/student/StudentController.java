package com.tenco.controller.student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.tenco.Repo.interfaces.student.StudentRepository;
import com.tenco.Repo.student.StudentRepositoryImpl;
import com.tenco.model.student.AnswerDTO;
import com.tenco.model.student.StudentDTO;
import com.tenco.model.user.UserDTO;

@WebServlet("/student/*")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentRepository studentRepository;  
	
    public StudentController() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	studentRepository = new StudentRepositoryImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
	switch (action) {
	case "/uploadAnswer":
		uploadAnswer(request, response);
		break;

	default:
		break;
	}
	}
	
	/**
	 * 강의 평가 설문 제출 post 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void uploadAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int[] answer = new int[10];	
		double avg = 0.0;
		String subjectId = request.getParameter("subjectId");
		String content = request.getParameter("Content");
		
		for(int i=0; i<10; i++) {
			answer[i] = Integer.parseInt(request.getParameter("que"+(i+1)));
			avg += answer[i];
		}
		
		avg = avg / 10;
		System.out.println(avg);
		HttpSession session = request.getSession();
		
		StudentDTO studentDTO = (StudentDTO)session.getAttribute("studentDTO");
		AnswerDTO answerDTO = AnswerDTO.builder()
										.stuId(studentDTO.getId())
										.subId(Integer.parseInt(subjectId))
										.answer(answer)
										.content(content)
										.avg(avg)
										.build();
		
		
		int result = studentRepository.addEvaluationAnswer(answerDTO);
		response.sendRedirect(request.getContextPath()+"/user/readmysubject?year=2023&semester=1&studentId=2023000001");
		
	}

}
