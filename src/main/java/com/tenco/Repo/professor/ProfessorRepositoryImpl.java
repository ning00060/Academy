package com.tenco.Repo.professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.professor.ProfessorRepository;
import com.tenco.model.student.StudentIdNameDTO;
import com.tenco.model.subject.SubjectDTO;
import com.tenco.util.DBUtil;

public class ProfessorRepositoryImpl implements ProfessorRepository {

	private final static String SELECT_ALL_SUBJECT_BY_PID_YEAR_SEMESTER = " select sj.id, sj.name, sj.room_id, "
			+ "	dp.name as department_name, sj.major_type, sj.year, sj.semester, sj.grades "
			+ " from tb_subject as sj left join tb_department as dp on sj.dept_id = dp.id "
			+ " where sj.professor_id = ? and sj.year = ? and sj.semester = ? ";

	private final static String INSERT_TB_STUDENT_SUBJECT_DETAIL = " insert into tb_stu_sub_detail(student_id, subject_id, mid_exam, final_exam, converted_mark) values(?, ?, ?, ?, ?) ";

	private final static String SELECT_STUDENTS_BY_SUBJECT_ID = " select er.student_id, st.name from tb_enroll as er left join tb_student as st on er.student_id = st.id where er.subject_id = ? ";

	// subjectID로 해당 강의를 수강하는 학생의 학번, 이름 받아오기
	public List<StudentIdNameDTO> selectStudentIdNameBySubjectId(int subjectId) {
		List<StudentIdNameDTO> studentList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_STUDENTS_BY_SUBJECT_ID)) {
			pstmt.setInt(1, subjectId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				studentList
						.add(StudentIdNameDTO.builder().id(rs.getInt("student_id")).name(rs.getString("name")).build());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	public void insertStudentsGradesByStudentId(int studentId, int subjectId, int midExam, int finalExam, int convertedMark) {
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_TB_STUDENT_SUBJECT_DETAIL)) {
				pstmt.setInt(1, studentId);
				pstmt.setInt(2, subjectId);
				pstmt.setInt(3, midExam);
				pstmt.setInt(4, finalExam);
				pstmt.setInt(5, convertedMark);
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
				subjectList.add(SubjectDTO.builder().id(rs.getInt("id")).name(rs.getString("name"))
						.roomId(rs.getString("room_id")).departmentName(rs.getString("department_name"))
						.majorType(rs.getString("major_type")).year(rs.getInt("year")).semester(rs.getInt("semester"))
						.grades(rs.getInt("grades")).build());

			}

			// System.out.println("교수Id, 개설년도, 개설학기 로 모든 강의 조회 쿼리 실행 -- 강의의 수 : " +
			// subjectList.size());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return subjectList;
	}

}
