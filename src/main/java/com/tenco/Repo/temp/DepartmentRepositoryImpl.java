package com.tenco.Repo.temp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.temp.DepartmentRepository;
import com.tenco.model.subject.StaffSubjectDTO;
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
		List<DepartmentDTO> departList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_DEPARTMENT_ALL)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				departList.add(DepartmentDTO.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.collegeId(rs.getInt("college_id"))
						.build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return departList;
	}

	@Override
	public DepartmentDTO selectDepartmentById(int id) {
		DepartmentDTO departmentDTO = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_DEPARTMENT_BY_ID)) {
				pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				departmentDTO=DepartmentDTO.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.collegeId(rs.getInt("college_id"))
						.build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return departmentDTO;
	}

	@Override
	public void addDepartment(DepartmentDTO departmentDTO) {
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(ADD_DEPARTMENT)){
				pstmt.setInt(1, departmentDTO.getId());
				pstmt.setString(2, departmentDTO.getName());
				pstmt.setInt(3, departmentDTO.getCollegeId());

				pstmt.executeUpdate();
				conn.commit();
				System.out.println("add커밋됨:" +departmentDTO.toString() );
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateDepartment(DepartmentDTO departmentDTO, int id) {
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(UPDATE_DEPARTMENT)){
				pstmt.setInt(1, departmentDTO.getId());
				pstmt.setString(2, departmentDTO.getName());
				pstmt.setInt(3, departmentDTO.getCollegeId());
				pstmt.setInt(4, id);
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

	@Override
	public void deleteDepartment(int id) {
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(DELETE_DEPARTMENT)){
				pstmt.setInt(1, id);
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


}
