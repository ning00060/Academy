package com.tenco.Repo.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.student.EnrollSearchRepository;
import com.tenco.model.student.EnrollSearchDTO;
import com.tenco.model.student.EnrollSearchListDTO;
import com.tenco.model.temp.EnrollDTO;
import com.tenco.util.DBUtil;

public class EnrollSearchRepositoryImpl implements EnrollSearchRepository {
	
	@Override
	public List<EnrollSearchDTO> searchSubject(String major, String departname, String subjectname) {

		String sql = " SELECT c.name AS c_name, d.name AS d_name, s.id AS s_number, s.major_type AS s_major_type, s.name AS s_name, p.name AS p_name, "
				+ " s.grades AS s_grade, "
				+ " s.room_id AS s_room_id "
				+ " FROM tb_subject as s "
				+ " JOIN tb_department as d ON s.dept_id = d.id "
				+ " JOIN tb_college as c ON d.college_id = c.id "
				+ " JOIN tb_professor as p ON s.professor_id = p.id "
				+ " where s.major_type like ? and d.name like ? and s.name like ? ";
		
		List<EnrollSearchDTO> enrollSearchDTO = new ArrayList<>();
		
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, major);
			pstmt.setString(2, departname);
			pstmt.setString(3, subjectname);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				enrollSearchDTO.add(EnrollSearchDTO.builder()
						.c_name(rs.getString("c_name"))
						.d_name(rs.getString("d_name"))
						.s_number(rs.getInt("s_number"))
						.s_major_type(rs.getString("s_major_type"))
						.s_name(rs.getString("s_name"))
						.p_name(rs.getString("p_name"))
						.s_grade(rs.getInt("s_grade"))
						.s_room_id(rs.getString("s_room_id"))
						.build());
			}
			
			System.out.println("쿼리 나오나?");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("검색 StudentRepositoryImpl 쪽 오류");
		}
		return enrollSearchDTO;
	} // end of searchSubject()
	
	
	@Override
	public void InsertEnroll(int id1, int id2) {
		String sql = " insert into tb_enroll(student_id, subject_id) values (?, ?) ";
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id1);
			pstmt.setInt(2, id2);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	
	@Override
	public List<EnrollSearchListDTO> searchEnrollList(int number) {
		String sql = " SELECT s.id AS s_number, s.name AS name, p.name AS professor, s.grades AS grades, s.room_id AS room "
				+ " FROM tb_subject as s "
				+ " JOIN tb_professor as p ON s.professor_id = p.id "
				+ " JOIN tb_enroll as e ON s.id = e.subject_id "
				+ " WHERE e.student_id = ? ";
		
		List<EnrollSearchListDTO> enrollSearchListDTO= new ArrayList<>(); 
		
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, number);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				// enrollSearchDTO.add(EnrollSearchDTO.builder()
				enrollSearchListDTO.add(EnrollSearchListDTO.builder()
						.s_number(rs.getInt("s_number"))
						.name(rs.getString("name"))
						.professor(rs.getString("professor"))
						.grades(rs.getInt("grades"))
						.room(rs.getString("room"))
						.build());
				
			}
			
			System.out.println("작동성공");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("작동실패");
		}
		return enrollSearchListDTO;
		
	}


	@Override
	public void DeleteEnroll(int student_id, int subject_id) {
		String sql = " delete from tb_enroll where student_id = ? and subject_id = ? ";
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, student_id);
			pstmt.setInt(2, subject_id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}


	@Override
	public List<EnrollDTO> SearchEnrollList(int student_id) {
		String sql= " select * from tb_enroll where student_id = ? ";
		List<EnrollDTO> enrollDTO = new ArrayList<EnrollDTO>();
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				enrollDTO.add(EnrollDTO.builder()
						.studentId(rs.getInt("student_id"))
						.subjectId(rs.getInt("subject_id"))
						.build());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enrollDTO;
	}
	
}
