package com.tenco.controller.professor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.professor.ProfessorRepository;
import com.tenco.Repo.professor.ProfessorRepositoryImpl;
import com.tenco.model.student.StudentIdNameDTO;
import com.tenco.model.subject.SubjectDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/professor/*")
public class ProfessorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfessorRepository professorRepository;

	@Override
	public void init() throws ServletException {
		professorRepository = new ProfessorRepositoryImpl();
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();

		switch (action) {
		// 교수 계정 로그인 후 홈 화면에서 학생 점수 입력 탭 클릭시 -> 강의목록 조회하기 폼으로 이동 처리
		case "/goinputpage":
			request.getRequestDispatcher("/WEB-INF/views/professor/select.jsp").forward(request, response);
			break;
			
		// 강의목록 조회하기 폼에서 개설년도, 개설학기 교수 id를 받아 내 강의 목록 조회 후 내 강의 목록 폼으로 이동
		case "/mysubject":
			readMySubject(request, response);
			break;

		// 내 강의 목록 리스트에서 학생 성적을 입력할 강의를 선택 후 학생 성적 입력 폼으로 이동
		case "/selectsubject":
			moveentergrade(request, response);
			break;

		// 학생 성적 입력 폼에서 성적 입력 후 입력받은 값을 DB에 저장하기
			// TODO : 하나식 입력? 전부 입력?  현재화면 그대로? 이전화면? 회의 필요
		case "/inputgrade":
			enterStudentGrade(request, response);
			break;

		default:
			break;
		}

	}

	
	private void moveentergrade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String subjectId = request.getParameter("subjectId");
		List<StudentIdNameDTO> studentList = new ArrayList<>();
		request.setAttribute("studentList", studentList);
		request.getRequestDispatcher("/WEB-INF/views/professor/subjectstudent.jsp").forward(request, response);

	}

	private void enterStudentGrade(HttpServletRequest request, HttpServletResponse response) {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		int midExam = Integer.parseInt(request.getParameter("midExamScore"));
		int finalExam = Integer.parseInt(request.getParameter("finalExamScore"));
		int convertedMark = Integer.parseInt(request.getParameter("grade"));
		professorRepository.insertStudentsGradesByStudentId(studentId, midExam, finalExam, convertedMark);
		
	}


	private void readMySubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("내 강의 조회 메서드 진입");

		String year = request.getParameter("year");
		String semester = request.getParameter("semester");
		String professorId = request.getParameter("professorId");
		List<SubjectDTO> subjectList = professorRepository.selectAllSubjectByProfessorIdYearSemester(Integer.parseInt(professorId), Integer.parseInt(year), Integer.parseInt(semester));
		request.setAttribute("subjectList", subjectList);
		
		request.getRequestDispatcher("/WEB-INF/views/professor/mysubject.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		
	}

}
