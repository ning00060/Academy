package com.tenco.controller.staff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.staff.StaffRepository;
import com.tenco.Repo.interfaces.staff.StaffSubjectRepository;
import com.tenco.Repo.interfaces.student.StudentRepository;
import com.tenco.Repo.interfaces.temp.DepartmentRepository;
import com.tenco.Repo.interfaces.temp.EnrollRepository;
import com.tenco.Repo.interfaces.temp.NoticeRepository;
import com.tenco.Repo.interfaces.temp.RoomRepository;
import com.tenco.Repo.interfaces.temp.StudentScholarRepository;
import com.tenco.Repo.interfaces.temp.TuitionRepository;
import com.tenco.Repo.staff.StaffRepositoryImpl;
import com.tenco.Repo.staff.StaffSubjectRepositoryImpl;
import com.tenco.Repo.student.StudentRepositoryImpl;
import com.tenco.Repo.temp.DepartmentRepositoryImpl;
import com.tenco.Repo.temp.EnrollRepositoryImpl;
import com.tenco.Repo.temp.NoticeRepositoryImpl;
import com.tenco.Repo.temp.RoomRepositoryImpl;
import com.tenco.Repo.temp.StudentScholarRepositoryImpl;
import com.tenco.Repo.temp.TuitionRepositoryImpl;
import com.tenco.model.professor.ProfessorDTO;
import com.tenco.model.staff.StaffDTO;
import com.tenco.model.student.StudentDTO;
import com.tenco.model.subject.StaffSubjectDTO;
import com.tenco.model.temp.DepartmentDTO;
import com.tenco.model.temp.NoticeDTO;
import com.tenco.model.temp.RoomDTO;
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
	private static TuitionRepository tuitionRepository;
	private static NoticeRepository noticeRepository;
	private static DepartmentRepository departmentRepository;
	private static StudentScholarRepository studentScholarRepository;
	private static StaffSubjectRepository staffSubjectRepository;
	private static RoomRepository roomRepository;

	@Override
	public void init() throws ServletException {
		staffRepository = new StaffRepositoryImpl();
		studentRepository = new StudentRepositoryImpl();
		enrollRepository = new EnrollRepositoryImpl();
		scholarRepository = new StudentScholarRepositoryImpl();
		tuitionRepository = new TuitionRepositoryImpl();
		noticeRepository = new NoticeRepositoryImpl();
		departmentRepository = new DepartmentRepositoryImpl();
		studentScholarRepository = new StudentScholarRepositoryImpl();
		staffSubjectRepository = new StaffSubjectRepositoryImpl();
		roomRepository =new RoomRepositoryImpl();
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		switch (action) {
		
		case "/schedule":
			schedulePage(request, response);

			break;
		case "/tuition":

			tuition(request, response);

			break;
		case "/tuitionModify":

			request.getRequestDispatcher("/WEB-INF/views/staff/tuition_regist.jsp").forward(request, response);

			break;

		case "/scholarship":
			scholarshipPage(request, response);

			break;
		case "/subjectList":
			subjectList(request, response);

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
		case "/updateStaff":
			request.getRequestDispatcher("/WEB-INF/views/staff/update_staff.jsp").forward(request, response);
			break;
		case "/updateStu":
			request.getRequestDispatcher("/WEB-INF/views/staff/update_stu.jsp").forward(request, response);
			break;
		case "/updatePro":
			request.getRequestDispatcher("/WEB-INF/views/staff/update_pro.jsp").forward(request, response);
			break;
		case "/depart":
			String id1=	request.getParameter("id");
			if(id1!=null) {
			request.setAttribute("id", id1);
			request.getRequestDispatcher("/WEB-INF/views/staff/department.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/WEB-INF/views/staff/department.jsp").forward(request, response);
			}
			break;
		case "/selectDepart":
			request.getRequestDispatcher("/WEB-INF/views/staff/select_depart.jsp").forward(request, response);
			break;
		case "/room":
			String id2=	request.getParameter("id");
			if(id2!=null) {
			request.setAttribute("id", id2);
			request.getRequestDispatcher("/WEB-INF/views/staff/room.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/WEB-INF/views/staff/room.jsp").forward(request, response);
			}
			break;
		case "/selectRoom":
			request.getRequestDispatcher("/WEB-INF/views/staff/select_room.jsp").forward(request, response);
			break;
		case "/subject":
			hopeSubject(request,response,session);

			break;
		case "/selectSubject":
			List<StaffSubjectDTO> hopeList= new ArrayList<>();
					hopeList = staffSubjectRepository.orderHopeclass();
			request.setAttribute("hopeList", hopeList);
			request.getRequestDispatcher("/WEB-INF/views/staff/select_sub.jsp").forward(request, response);
			break;

		default:
			break;
		}

	}

	private void hopeSubject(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		int id =Integer.parseInt( request.getParameter("id"));
		String name=request.getParameter("name");
		int professorId=Integer.parseInt( request.getParameter("professorId"));
		String roomId=request.getParameter("roomId");
		int deptId=Integer.parseInt( request.getParameter("deptId"));
		String majorType=request.getParameter("majorType");
		int year=Integer.parseInt( request.getParameter("year"));
		int semester=Integer.parseInt( request.getParameter("semester"));
		int grades=Integer.parseInt( request.getParameter("grades"));
		StaffSubjectDTO hopeSubject=StaffSubjectDTO.builder()
				.id(id).name(name).professorId(professorId).roomId(roomId)
				.deptId(deptId).majorType(majorType).year(year).semester(semester).grades(grades)
				.build();
		
		if(hopeSubject!=null) {
		request.setAttribute("hopeSubject", hopeSubject);
		request.getRequestDispatcher("/WEB-INF/views/staff/subject.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/staff/subject.jsp").forward(request, response);
		}
	}


	private void scholarshipPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<StudentScholarDTO> studentScholarDTO = scholarRepository.selectStudentScholarAll();
		if (studentScholarDTO != null) {

			request.setAttribute("studentScholarDTO", studentScholarDTO);
			request.getRequestDispatcher("/WEB-INF/views/staff/scholarship.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/user/login");
		}

	}

	private void tuition(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<TuitionDTO> tuiList = tuitionRepository.selectTuitionAll();
		if (tuiList != null) {
			request.setAttribute("tuiList", tuiList);
			request.getRequestDispatcher("/WEB-INF/views/staff/tuition.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/user/login");
		}

	}

	private void subjectList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		StudentDTO studentDTO=studentRepository.selectStudentById(2023000001);
//		List<EnrollDTO> enrollList=enrollRepository.selectByStudentId( studentDTO.getId());
//		request.setAttribute("enrollList", enrollList);
		request.getRequestDispatcher("/WEB-INF/views/temp/schedule.jsp").forward(request, response);
	}

	private void schedulePage(HttpServletRequest request, HttpServletResponse response) {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		switch (action) {

		case "/notice":
			System.out.println("notice이동");
			noticePage(request, response, session);
			break;

		case "/tuition":
			tuitionRegist(request, response);
			break;

		case "/tuitionModify":
			tuitionModify(request, response);
			break;

		case "/tuitionDelete":
			tuitionDelete(request, response);
			break;

		case "/registStu":
			registStuPage(request, response, session);
			break;

		case "/registPro":
			registProPage(request, response, session);
			break;

		case "/registStaff":
			registStaffPage(request, response, session);
			break;
			
		case "/updateStu":
			updateStuPage(request, response, session);
			break;
			
		case "/updatePro":
			updateProPage(request, response, session);
			break;
			
		case "/updateStaff":
			updateStaffPage(request, response, session);
			break;
		case "/depart":
			departPage(request, response, session);
		case "/departModify":
			departModify(request, response, session);
		case "/departDelete":
			departDelete(request, response, session);
			break;
		case "/selectDepart":
			selectDepart(request, response, session);
			break;
		case "/room":
			roomPage(request,response,session);
			break;
		case "/roomModify":
			roomModify(request, response, session);
			break;
		case "/roomDelete":
			roomDelete(request, response, session);
			break;
		case "/selectRoom":
			selectRoom(request, response, session);
			break;
		case "/subject":
			subjectPage(request, response, session);
			break;
		case "/subjectModify":
			subjectModify(request, response, session);
			break;
		case "/subjectDelete":
			subjectDelete(request, response, session);
			break;
		case "/selectSubject":
			selectSubject(request,response,session);
			break;
		default:
			break;
		}

	}

	private void updateStaffPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		int id = Integer.parseInt( request.getParameter("id"));
		int id2 = Integer.parseInt( request.getParameter("id2"));
		int level = Integer.parseInt( request.getParameter("level"));
		String name = request.getParameter("name");
		String birth = request.getParameter("birthDate");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		StaffDTO staffDTO = StaffDTO.builder()
				.id(id).name(name).birthDate(birth).gender(gender).address(address)
				.tel(tel).email(email).build();
		System.out.println(staffDTO.toString());
		if (staffDTO == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
		} else {
			staffRepository.updateUserStaff(staffDTO, password, level,id2);
			request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
		}
	}


	private void updateProPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
		int id = Integer.parseInt( request.getParameter("id"));
		int id2 = Integer.parseInt( request.getParameter("id2"));
		int level = Integer.parseInt( request.getParameter("level"));
		String name = request.getParameter("name");
		java.sql.Date birthDate = java.sql.Date.valueOf(request.getParameter("birthDate"));
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int deptId = Integer.parseInt(request.getParameter("deptId"));

		ProfessorDTO professorDTO=ProfessorDTO.builder()
				.id(id)
				.name(name)
				.birthDate(birthDate)
				.gender(gender)
				.address(address)
				.tel(tel)
				.email(email)
				.deptId(deptId)
				.build();
		if(professorDTO==null) {
			response.sendRedirect(request.getContextPath()+"/user/login");
			}
		else {
			staffRepository.updateUserProfessor(professorDTO, password, level,id2);
			request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
			}
		}


	private void updateStuPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		int id = Integer.parseInt( request.getParameter("id"));
		int id2 = Integer.parseInt( request.getParameter("id2"));
		int level = Integer.parseInt( request.getParameter("level"));
		String name = request.getParameter("name");
		String birth = request.getParameter("birthDate");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		int dept_id = Integer.parseInt(request.getParameter("deptId"));
		int grade = Integer.parseInt(request.getParameter("grade"));
		int semester = Integer.parseInt(request.getParameter("semester"));
		String entranceDate = request.getParameter("entranceDate");
		String password = request.getParameter("password");

		StudentDTO studentDTO = StudentDTO.builder()
				.id(id).name(name).birth_date(birth).gender(gender).address(address)
				.tel(tel).email(email).dept_id(dept_id).grade(grade).semester(semester).entrance_date(entranceDate).build();
		System.out.println(studentDTO.toString());
		if (studentDTO == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
		} else {
			staffRepository.updateUserStudent(studentDTO, password, level, id2);
			request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
		}
	}


	private void selectRoom(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		int search = Integer.parseInt(request.getParameter("search"));
		if (String.valueOf(search) != null) {
			List<RoomDTO> roomList = roomRepository.selectRoomByCollegeId(search);
			request.setAttribute("roomList", roomList);
			request.getRequestDispatcher("/WEB-INF/views/staff/select_room.jsp").forward(request, response);
		}else {
		response.sendRedirect(request.getContextPath() + "/user/login");
		}
	}

	private void roomPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		String id =request.getParameter("id");
		int college_id=Integer.parseInt( request.getParameter("college_id"));

		RoomDTO roomDTO=RoomDTO.builder()
				.id(id).collegeId(college_id)
				.build();
		if(roomDTO !=null) {
		 roomRepository.addRoom(roomDTO);
			response.sendRedirect(request.getContextPath() + "/user/home");
		} else {
			response.sendRedirect(request.getContextPath() + "/user/login");
		}
		
	}
	private void roomDelete(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		String id =request.getParameter("id");
		if (id != null) {
			roomRepository.deleteRoom(id);
			response.sendRedirect(request.getContextPath() + "/user/home");
		} else {
			response.sendRedirect(request.getContextPath() + "/user/login");
		}
		
	}
	private void roomModify(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		String id =request.getParameter("id");
		String id2 =request.getParameter("id2");
		int college_id=Integer.parseInt( request.getParameter("college_id"));
		RoomDTO roomDTO=RoomDTO.builder()
				.id(id).collegeId(college_id)
				.build();
		if(roomDTO !=null) {
		 roomRepository.updateRoom(roomDTO, id2);
			response.sendRedirect(request.getContextPath() + "/user/home");
		} else {
			response.sendRedirect(request.getContextPath() + "/user/login");
		}
	}

	private void selectSubject(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		int search = Integer.parseInt(request.getParameter("search"));
		if (String.valueOf(search) != null) {
			StaffSubjectDTO staffSubjectDTO = staffSubjectRepository.selectSubjectById(search);
			request.setAttribute("staffSubjectDTO", staffSubjectDTO);
			request.getRequestDispatcher("/WEB-INF/views/staff/select_sub.jsp").forward(request, response);
		}else {
		response.sendRedirect(request.getContextPath() + "/user/login");
		}
	}
		
	

	private void subjectDelete(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		if (String.valueOf(id) != null) {
			staffSubjectRepository.deleteSubject(id);
			response.sendRedirect(request.getContextPath() + "/user/home");
		} else {
			response.sendRedirect(request.getContextPath() + "/user/login");
		}
		
	}

	private void subjectModify(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		int id =Integer.parseInt( request.getParameter("id"));
		int id2 =Integer.parseInt( request.getParameter("id2"));
		String name=request.getParameter("name");
		int professorId=Integer.parseInt( request.getParameter("professorId"));
		String roomId=request.getParameter("roomId");
		int deptId=Integer.parseInt( request.getParameter("deptId"));
		String majorType=request.getParameter("majorType");
		int year=Integer.parseInt( request.getParameter("year"));
		int semester=Integer.parseInt( request.getParameter("semester"));
		int grades=Integer.parseInt( request.getParameter("grades"));
		StaffSubjectDTO staffSubjectDTO=StaffSubjectDTO.builder()
				.id(id).name(name).professorId(professorId).roomId(roomId)
				.deptId(deptId).majorType(majorType).year(year).semester(semester).grades(grades)
				.build();
		if(staffSubjectDTO !=null) {
		 staffSubjectRepository.updateSubject(staffSubjectDTO, id2);
			response.sendRedirect(request.getContextPath() + "/user/home");
		} else {
			response.sendRedirect(request.getContextPath() + "/user/login");
		}
	}

	private void subjectPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		String name=request.getParameter("name");
		int professorId=Integer.parseInt( request.getParameter("professorId"));
		String roomId=request.getParameter("roomId");
		int deptId=Integer.parseInt( request.getParameter("deptId"));
		String majorType=request.getParameter("majorType");
		int year=Integer.parseInt( request.getParameter("year"));
		int semester=Integer.parseInt( request.getParameter("semester"));
		int grades=Integer.parseInt( request.getParameter("grades"));
		StaffSubjectDTO staffSubjectDTO=StaffSubjectDTO.builder()
				.name(name).professorId(professorId).roomId(roomId)
				.deptId(deptId).majorType(majorType).year(year).semester(semester).grades(grades)
				.build();
		if(staffSubjectDTO !=null) {
		 staffSubjectRepository.addSubject(staffSubjectDTO);
			response.sendRedirect(request.getContextPath() + "/user/home");
		} else {
			response.sendRedirect(request.getContextPath() + "/user/login");
		}
		
	}

	private void selectDepart(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		int search = Integer.parseInt(request.getParameter("search"));
		if (String.valueOf(search) != null) {
			DepartmentDTO departmentDTO = departmentRepository.selectDepartmentById(search);
			request.setAttribute("departmentDTO", departmentDTO);
			request.getRequestDispatcher("/WEB-INF/views/staff/select_depart.jsp").forward(request, response);
		}
		else{
			response.sendRedirect(request.getContextPath() + "/user/login");
		}
	}

	private void departModify(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		int id =Integer.parseInt( request.getParameter("id"));
		int id2 =Integer.parseInt( request.getParameter("id2"));
		int collegeId=Integer.parseInt( request.getParameter("collegeId"));
		String name=request.getParameter("name");
		DepartmentDTO departmentDTO=DepartmentDTO.builder()
				.id(id).name(name).collegeId(collegeId).build();
		if(departmentDTO !=null) {
		 departmentRepository.updateDepartment(departmentDTO, id2);
			response.sendRedirect(request.getContextPath() + "/user/home");
		}else {
			response.sendRedirect(request.getContextPath() + "/user/login");
		}
	}

	private void departDelete(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		if (String.valueOf(id) != null) {
			departmentRepository.deleteDepartment(id);
			response.sendRedirect(request.getContextPath() + "/user/home");
		} else {
			response.sendRedirect(request.getContextPath() + "/user/login");
		}
	}

	private void departPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		int id =Integer.parseInt( request.getParameter("id"));
		int collegeId=Integer.parseInt( request.getParameter("collegeId"));
		String name=request.getParameter("name");
		DepartmentDTO departmentDTO=DepartmentDTO.builder()
				.id(id).name(name).collegeId(collegeId).build();
		if(departmentDTO !=null) {
		 departmentRepository.addDepartment(departmentDTO);
			response.sendRedirect(request.getContextPath() + "/user/home");
		} else {
			response.sendRedirect(request.getContextPath() + "/user/login");
		}

	}

	private void tuitionDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		tuitionRepository.deleteTution(id);
		request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
	}

	private void tuitionModify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int tuiYear = Integer.parseInt(request.getParameter("tuiYear"));
		int semester = Integer.parseInt(request.getParameter("semester"));
		int tuiId = Integer.parseInt(request.getParameter("tuiId"));
		int schType = Integer.parseInt(request.getParameter("schType"));
		int status = Integer.parseInt(request.getParameter("status"));

		TuitionDTO tuitionDTO = TuitionDTO.builder().id(id).tuiYear(tuiYear).semester(semester).tuiId(tuiId)
				.schType(schType).status(status).build();
		tuitionRepository.updateTution(tuitionDTO, id);
		request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);

	}

	private void tuitionRegist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int tuiYear = Integer.parseInt(request.getParameter("tuiYear"));
		int semester = Integer.parseInt(request.getParameter("semester"));
		int tuiId = Integer.parseInt(request.getParameter("tuiId"));
		int schType = Integer.parseInt(request.getParameter("schType"));
		int status = Integer.parseInt(request.getParameter("status"));

		TuitionDTO tuitionDTO = TuitionDTO.builder().id(id).tuiYear(tuiYear).semester(semester).tuiId(tuiId)
				.schType(schType).status(status).build();
		tuitionRepository.addTuition(tuitionDTO);
		request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);

	}

	private void registProPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		String name = request.getParameter("name");
		java.sql.Date birthDate = java.sql.Date.valueOf(request.getParameter("birthDate"));
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int deptId = Integer.parseInt(request.getParameter("deptId"));

		ProfessorDTO professorDTO=ProfessorDTO.builder()
				.name(name)
				.birthDate(birthDate)
				.gender(gender)
				.address(address)
				.tel(tel)
				.email(email)
				.deptId(deptId)
				.build();
		System.out.println( professorDTO.toString());
		if(professorDTO==null) {
			response.sendRedirect(request.getContextPath()+"/user/login");
			}
		else {
			staffRepository.addUserProfessor(professorDTO, password);
			request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
			}
		}

	

	private void registStuPage(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String birth = request.getParameter("birthDate");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		int dept_id = Integer.parseInt(request.getParameter("deptId"));
		int grade = Integer.parseInt(request.getParameter("grade"));
		int semester = Integer.parseInt(request.getParameter("semester"));
		String entranceDate = request.getParameter("entranceDate");
		String password = request.getParameter("password");

		StudentDTO studentDTO = StudentDTO.builder().name(name).birth_date(birth).gender(gender).address(address)
				.tel(tel).email(email).dept_id(dept_id)
				.grade(grade).semester(semester).entrance_date(entranceDate).build();
		System.out.println(studentDTO.toString());
		if (studentDTO == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
		} else {
			staffRepository.addUserStudent(studentDTO, password);
			request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
		}
	}

	private void registStaffPage(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException, ServletException {
		String name = request.getParameter("name");
		String birth = request.getParameter("birthDate");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		StaffDTO staffDTO = StaffDTO.builder().name(name).birthDate(birth).gender(gender).address(address).tel(tel)
				.email(email).build();
		System.out.println(staffDTO.toString());
		if (staffDTO == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
		} else {
			staffRepository.addUserStaff(staffDTO, password);
			request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
		}
	}

	private void noticePage(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		// 공지사항 getAll
		UserDTO userDTO = (UserDTO) session.getAttribute("verifiedUser");

		int page = 1; // 기본 페이지 번호
		int pageSize = 10; // 한 페이지당 보여질 게시글에 수

		try {
			String pageStr = request.getParameter("page");
			if (pageStr != null) {
				page = Integer.parseInt(pageStr);
			}
		} catch (Exception e) {
			page = 1;
		}

		int offset = (page - 1) * pageSize; // 시작 위치 계산( offset 값 계산)
		List<NoticeDTO> noticeList = noticeRepository.SelectNoitceAllLimit10(pageSize, offset);

		// 전체 게시글 수 조회
		int totalBoards = noticeRepository.selectNoticeCountAll();
		// 총 페이지 수 계산 --> [1][2][3][...]
		int totalPages = (int) Math.ceil((double) totalBoards / pageSize);

		request.setAttribute("noticeList", noticeList);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("currentPage", page);

		// 현재 로그인한 사용자 ID 설정
		if (session != null) {
			UserDTO user = (UserDTO) session.getAttribute("principal");
			if (user != null) {
				request.setAttribute("userId", user.getId());
			}
		}
		request.getRequestDispatcher("/WEB-INF/views/temp/notice.jsp").forward(request, response);

	}

}
