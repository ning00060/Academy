package com.tenco.Repo.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.student.StudentRepository;
import com.tenco.model.student.StudentDTO;
import com.tenco.model.subject.UsersSubjectDTO;
import com.tenco.util.DBUtil;

public class StudentRepositoryImpl implements StudentRepository {
	
	
	private final static String SELECT_ALL_SUBJECT_BY_SID_YEAR_SEMESTER = 
			" SELECT er.student_id, sj.name, pf.name as professor_name, sj.room_id, "
			+ " dp.name as department_name, sj.major_type, sj.year, sj.semester, sj.grades "
			+ " FROM tb_subject as sj "
			+ " left join tb_professor as pf on sj.professor_id = pf.id "
			+ " left join tb_department as dp on sj.dept_id = dp.id "
			+ " left join tb_enroll as er on sj.id = er.subject_id "
			+ " where er.student_id = ? and (sj.year = ? and sj.semester = ?) ";
	
	private final static String SELECT_ALL_QUESTION_FOR_EVALUATION = " select * from tb_question where id = 1 ";
	
	@Override
	public StudentDTO studentInfo(int id) {
		
		String sql = " select s.*, d.id as d_number, d.name as d_name, d.college_id as d_id "
				+ " from tb_student as s "
				+ " join tb_department as d "
				+ " on s.dept_id = d.id where s.id = ? ";
		StudentDTO studentDTO = null;
		
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				studentDTO = StudentDTO.builder()
				.id(rs.getInt("id"))
				.name(rs.getString("name"))
				.birth_date(rs.getString("birth_date"))
				.gender(rs.getString("gender"))
				.address(rs.getString("address"))
				.tel(rs.getString("tel"))
				.email(rs.getString("email"))
				.dept_id(rs.getInt("dept_id"))
				.grade(rs.getInt("grade"))
				.semester(rs.getInt("semester"))
				.entrance_date(rs.getString("entrance_date"))
				.graduation_date(rs.getString("graduation_date"))
				
				.d_number(rs.getInt("d_number"))
				.d_name(rs.getString("d_name"))
				.d_id(rs.getInt("d_id"))
				.build();
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("StudentRepositoryImpl 에서 오류발생");
		}
	System.out.println("@@" + studentDTO.toString());
		return studentDTO; 
	}



	@Override
	public List<UsersSubjectDTO> readMySubject(int studentId, int year, int semester) {
		List<UsersSubjectDTO> subjectList = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_SUBJECT_BY_SID_YEAR_SEMESTER)) {

			pstmt.setInt(1, studentId);
			pstmt.setInt(2, year);
			pstmt.setInt(3, semester);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				subjectList.add(UsersSubjectDTO.builder()
						.studentId(rs.getInt("id")).subjectName(rs.getString("name"))
						.professorName(rs.getString("professor_name")).roomId(rs.getInt("room_id"))
						.departmentName(rs.getString("department_name")).majorType(rs.getString("major_type"))
						.year(rs.getString("year")).semester(rs.getString("semester"))
						.grades(rs.getString("grades")).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectList;
	}



	@Override
	public StudentDTO search(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
