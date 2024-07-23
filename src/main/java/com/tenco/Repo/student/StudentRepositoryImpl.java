package com.tenco.Repo.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tenco.Repo.interfaces.student.StudentRepository;
import com.tenco.model.student.StudentDTO;

import com.tenco.util.DBUtil;

public class StudentRepositoryImpl implements StudentRepository {

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

}
