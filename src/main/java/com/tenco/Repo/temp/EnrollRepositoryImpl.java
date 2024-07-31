package com.tenco.Repo.temp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.temp.EnrollRepository;
import com.tenco.model.temp.EnrollDTO;
import com.tenco.util.DBUtil;

public class EnrollRepositoryImpl implements EnrollRepository{
		private static final String SELECT_BY_STUDENT_ID=" select student_id,sc.subject_id,su.name,p.name,p.dept_id,day,period,room_id "
				+ " from tb_enroll as e "
				+ " join tb_student as s on e.student_id=s.id "
				+ " join tb_subject as  su on e.subject_id=su.id "
				+ " join tb_sub_schedule as sc on sc.subject_id=su.id "
				+ " left outer join tb_professor as p on su.professor_id=p.id "
				+ " where student_id=? ";
	
	
	
	@Override
	public List<EnrollDTO> selectByStudentId(int id) {
		List<EnrollDTO> enrollList= new ArrayList<>();
		try (Connection conn=DBUtil.getConnection()){
			PreparedStatement pstmt=conn.prepareStatement(SELECT_BY_STUDENT_ID);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				EnrollDTO enrollDTO=EnrollDTO.builder()
						.studentId(rs.getInt("student_id"))
						.subjectId(rs.getInt("subject_id"))
						.subjectName(rs.getString("su.name"))
						.professorName(rs.getString("p.name"))
						.deptId(rs.getInt("p.dept_id"))
						.day(rs.getInt("day"))
						.period(rs.getInt("period"))
						.roomId(rs.getString("room_id"))
						.build();
				enrollList.add(enrollDTO);
						
			}
			System.out.println(enrollList.toString()+"=enroll");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return enrollList;
	}

}
