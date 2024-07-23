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
	public StudentDTO search(int id) {
		
		String sql = " select * from tb_student where id = ? ";
		StudentDTO studentDTO = null;
		
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				studentDTO = StudentDTO.builder()
				.id(rs.getInt("id"))
				.name(rs.getString("name"))
//				.birth_date(rs.getString("birth_date"))
//				.gender(rs.getString("gender"))
//				.tel(rs.getString("tel"))
//				.email(rs.getString("email"))
//				.dept_id(rs.getInt("dept_id"))
//				.grade(rs.getInt("grade"))
//				.semester(rs.getInt("semester"))
//				.entrance_date(rs.getString("entrance_date"))
				.build();	
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return studentDTO; 
		
	}

}
