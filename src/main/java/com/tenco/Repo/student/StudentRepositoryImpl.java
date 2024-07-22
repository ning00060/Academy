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
	public StudentDTO search(String id) {
		
		String sql = " select * from tb_student where id = ? ";
		StudentDTO studentDTO = null;
		
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {

		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null; 
		
	}

}
