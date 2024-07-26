package com.tenco.Repo.temp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.temp.DepartmentRepository;
import com.tenco.model.temp.DepartmentDTO;
import com.tenco.model.temp.RoomDTO;
import com.tenco.util.DBUtil;

public class DepartmentRepositoryImpl implements DepartmentRepository{
	private static final String SELECT_DEPARTMENT_ALL="select * from tb_department ";
	private static final String SELECT_DEPARTMENT_BY_ID="select * from tb_department where id=? ";
	private static final String ADD_DEPARTMENT="insert into tb_department values(?, ?,?) ";
	private static final String UPDATE_DEPARTMENT="update tb_department set id=? or name=? or college_id=? where id=? ";
	private static final String DELETE_DEPARTMENT="delete from tb_department where id=? ";

	@Override
	public List<DepartmentDTO> selectDepartmentAll() {
		List<RoomDTO> roomList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ROOM_ALL)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				roomList.add(RoomDTO.builder()
						.id(rs.getString("id"))
						.collegeId(rs.getInt("college_id"))

						.build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return roomList;
	}

	@Override
	public DepartmentDTO selectDepartmentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDepartment(DepartmentDTO departmentDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDepartment(DepartmentDTO departmentDTO, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDepartment(int id) {
		// TODO Auto-generated method stub
		
	}

}
