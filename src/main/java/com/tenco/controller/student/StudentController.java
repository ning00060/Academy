package com.tenco.controller.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.student.EnrollSearchRepository;
import com.tenco.Repo.interfaces.student.StudentRepository;
import com.tenco.Repo.student.EnrollSearchRepositoryImpl;
import com.tenco.Repo.student.StudentRepositoryImpl;
import com.tenco.model.student.AnswerDTO;
import com.tenco.model.student.EnrollSearchDTO;
import com.tenco.model.student.EnrollSearchListDTO;
import com.tenco.model.student.StudentDTO;
import com.tenco.model.student.breakappDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student/*")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentRepository studentRepository;  
    private EnrollSearchRepository enrollSearchRepository;
	
    public StudentController() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	studentRepository = new StudentRepositoryImpl();
    	enrollSearchRepository = new EnrollSearchRepositoryImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		case "/breakApp":
			request.getRequestDispatcher("/WEB-INF/views/student/breakapp.jsp").forward(request, response);
			break;
			
		case "/breakSearch":
			HandlerbreakSearch(request, response);
			break;
		
		case "/subjectList":
			request.getRequestDispatcher("/WEB-INF/views/student/breakapp.jsp\"").forward(request, response);
			break;
			
		case "/enrollSearch":
			// 대학교 강의 목록 조회 페이지로 이동한다.
			request.getRequestDispatcher("/WEB-INF/views/student/enrollRepository.jsp").forward(request, response);
			break;

		default:
			break;
		}
	}

	/**
	 *  휴학 정보 조회
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void HandlerbreakSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		StudentDTO studentDTO = (StudentDTO)session.getAttribute("studentDTO");
		request.setAttribute("studentDTO", studentDTO);
		
		System.out.println(studentDTO.toString());
		breakappDTO breakappDTO = studentRepository.searchBreakapp(studentDTO.getId());
		request.setAttribute("breakappDTO", breakappDTO);
		System.out.println(breakappDTO.toString());
		
		request.getRequestDispatcher("/WEB-INF/views/student/breakappsearch.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
	switch (action) {
	case "/uploadAnswer":
		uploadAnswer(request, response);
		break;
		
	case "/breakPost":
		System.out.println("@@");
		breakPost(request, response);
		break;
		
	case "/enrollSearch":
		// 검색 할 시 정보를 출력한다.
		System.out.println("~~");
		enrollSearch(request,response);
		break;
	
	case "/enrolment":
		// 수강 신청 버튼 클릭 시 
		System.out.println("수강 신청 버튼 클릭 시 작동");
		enrolment(request, response);
	
	case "/enrollSearchList":
		// 수강신청 목록 보러가기 페이지로 이동한다.
		System.out.println("수강신청 목록 보러가기 페이지로 이동한다.");
		enrollSearchList(request, response);

	default:
		break;
	}
	
	}
	/**
	 * 수강신청 완료 리스트
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void enrollSearchList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		StudentDTO studentDTO = (StudentDTO)session.getAttribute("studentDTO");
		request.setAttribute("studentDTO", studentDTO);
		List<EnrollSearchListDTO> enrollSearchListDTO = enrollSearchRepository.searchEnrollList(studentDTO.getId());
		request.setAttribute("EnrollSearchListDTO", enrollSearchListDTO);
		System.out.println("enrollSearchListDTO.toString() : " + enrollSearchListDTO.toString());
		request.getRequestDispatcher("/WEB-INF/views/student/enrollRepository3.jsp").forward(request, response);
	}

	/**
	 * 수강신청 버튼 클릭 시 수강신청 목록으로 들어간다.
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void enrolment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		StudentDTO studentDTO = (StudentDTO) session.getAttribute("studentDTO");
		request.setAttribute("studentDTO", studentDTO);
		System.out.println(studentDTO.toString());
		
		String b = request.getParameter("subjectnumber");
		System.out.println(b); // 데이터통신 <-- 과목 번호
		int c = Integer.parseInt(b);
		
		enrollSearchRepository.InsertEnroll(studentDTO.getId(), c);
	
		//수강신청 버튼 클릭 시 학생 번호, 과목 번호를 수강신청 테이블로 전송시킨다.
		request.getRequestDispatcher("/WEB-INF/views/student/enrollRepository.jsp").forward(request, response);
		// request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
	}

	/**
	 * 수강신청 과목 리스트
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void enrollSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject = request.getParameter("subject");
		System.out.println("subject :" + subject);
		
		String department = request.getParameter("department");
		System.out.println("department :" + department);
		
		String subjectname = request.getParameter("subjectname");
		System.out.println("subjectList :" + subjectname);
		
		List<EnrollSearchDTO> searchDTO = new ArrayList<EnrollSearchDTO>();
		searchDTO = enrollSearchRepository.searchSubject(subject, department, subjectname);
		request.setAttribute("subjectList", searchDTO);
		
		System.out.println(searchDTO.toString());
		
		request.getRequestDispatcher("/WEB-INF/views/student/enrollRepository2.jsp").forward(request, response);
	}

	/**
	 * 휴학 신청 버튼 클릭 시 
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void breakPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String year0 = request.getParameter("year0");
		System.out.println("year0 " + year0);
		
		String semester0 = request.getParameter("semester0");
		System.out.println("semester0 " + semester0);
		
		String year = request.getParameter("year");
		System.out.println("year " + year);
		
		String semester = request.getParameter("semester");
		System.out.println("semester " + semester);
		
		String bre = request.getParameter("bre");
		System.out.println("bre " + bre);
		
		HttpSession session = request.getSession();
		StudentDTO studentDTO = (StudentDTO) session.getAttribute("studentDTO");
		
		breakappDTO breakappDTO1 = breakappDTO.builder()
											.student_id(studentDTO.getId())
											.student_grade(studentDTO.getGrade())
											.from_year(Integer.parseInt(year0))
											.from_semester(Integer.parseInt(semester0))
											.to_year(Integer.parseInt(year))
											.to_semester(Integer.parseInt(semester))
											.type(bre)
											.build();
		
		int result = studentRepository.addBreakapp(breakappDTO1);
		response.sendRedirect(request.getContextPath()+"/user/a");
	}

	/**;
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
