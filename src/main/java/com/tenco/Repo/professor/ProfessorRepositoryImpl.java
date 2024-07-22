package com.tenco.Repo.professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.professor.ProfessorRepository;
import com.tenco.model.subject.SubjectDTO;
import com.tenco.util.DBUtil;

public class ProfessorRepositoryImpl implements ProfessorRepository{
	
	private final static String SELECT_ALL_SUBJECT_BY_PID_YEAR_SEMESTER = " select sj.id, sj.name, sj.room_id, "
			+ "		dp.name as department_name, sj.major_type, sj.year,"
			+ "        sj.semester, sj.grades"
			+ "from tb_subject as sj"
			+ "left join tb_department as dp on sj.dept_id = dp.id"
			+ "where sj.professor_id = ? and sj.year = ? and sj.semester = ? ";
	
	private final static String INSERT_TB_STUDENT_SUBJECT_DETAIL  = " INSERT INTO tb_student_subject_detail(student_id, mid_exam, final_exam, converted_mark) VALUES(?, ?, ?, ?) ";
	
	private final static String SELECT_STUDENTS_BY_SUBJECT_ID = " select er.student_id, st.student_name ";
	
	//public List<>	
	
	// 교수 id와 강의의 개설년도, 개설학기로 자신의 모든 강의를 조회 / 과목 DTO 리스트로 반환
	@Override
	public List<SubjectDTO> selectAllSubjectByProfessorIdYearSemester(int professorId, int year, int semester) {
		List<SubjectDTO> subjectList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_SUBJECT_BY_PID_YEAR_SEMESTER)) {

			pstmt.setInt(1, professorId);
			pstmt.setInt(2, year);
			pstmt.setInt(3, semester);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				subjectList.add(
						SubjectDTO.builder().id(rs.getInt("id")).name(rs.getString("name"))
								.roomId(rs.getInt("room_id")).departmentName(rs.getString("department_name"))
								.majorType(rs.getString("major_type")).year(rs.getString("year"))
								.semester(rs.getString("semester")).grades(rs.getString("grades")).build());

			}
			System.out.println("교수Id, 개설년도, 개설학기 로 모든 강의 조회 쿼리 실행 -- 강의의 수 : " + subjectList.size());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return subjectList;
	}

}
