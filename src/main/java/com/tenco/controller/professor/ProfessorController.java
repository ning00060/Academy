package com.tenco.controller.professor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.professor.ProfessorRepository;
import com.tenco.Repo.professor.ProfessorRepositoryImpl;
import com.tenco.model.professor.StudentIdNameDTO;
import com.tenco.model.subject.SubjectDTO;
import com.tenco.model.user.UserDTO;

@WebServlet("/professor/*")
public class ProfessorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfessorRepository professorRepository;

	@Override
	public void init() throws ServletException {
		professorRepository = new ProfessorRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		String action = request.getPathInfo();

		switch (action) {
		// 교수 계정 로그인 후 홈 화면에서 학생 점수 입력 탭 클릭시 -> 강의목록 조회하기 폼으로 이동 처리
		case "/select":
			request.getRequestDispatcher("/WEB-INF/views/professor/select.jsp").forward(request, response);
			break;

		// 내 강의 목록 리스트에서 학생 성적을 입력할 강의를 선택
		case "/selectsubject":
			moveentergrade(request, response, session);

			break;

		// 강의목록 조회하기 폼에서 개설년도, 개설학기 값을 받고 세션에서 교수 id를 받아 내 강의 목록 조회
		case "/mysubject":
			readMySubject(request, response, session);
			break;

		// 학생 성적 입력 폼에서 입력받은 값을 DB에 저장하기
		case "/inputgrade":
			enterStudentGrade(request, response, session);
			break;

		default:
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
	}
	
	private void moveentergrade(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		String subjectId = request.getParameter("subjectId");
		List<StudentIdNameDTO> studentList = new ArrayList<>();
		request.setAttribute("studentList", studentList);
		request.getRequestDispatcher("/WEB-INF/views/professor/subjectstudent.jsp").forward(request, response);

	}

	private void enterStudentGrade(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		int midExam = Integer.parseInt(request.getParameter("midExamScore"));
		int finalExam = Integer.parseInt(request.getParameter("finalExamScore"));
		int convertedMark = Integer.parseInt(request.getParameter("grade"));
		professorRepository.insertStudentsGradesByStudentId(studentId, midExam, finalExam, convertedMark);
		
	}

	private void readMySubject(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		System.out.println("내 강의 조회 메서드 진입");

		String year = request.getParameter("year");
		String semester = request.getParameter("semester");
		UserDTO user = (UserDTO) session.getAttribute("principal");
		if (user != null) {
			request.setAttribute("professorId", user.getId());
		}

		List<SubjectDTO> subjectList = professorRepository.selectAllSubjectByProfessorIdYearSemester(
				Integer.parseInt(user.getId()), Integer.parseInt(year), Integer.parseInt(semester));
		request.setAttribute("subjectList", subjectList);
		request.setAttribute("UserDTO", user);

		request.getRequestDispatcher("/WEB-INF/views/professor/mysubject.jsp").forward(request, response);
	}

}
