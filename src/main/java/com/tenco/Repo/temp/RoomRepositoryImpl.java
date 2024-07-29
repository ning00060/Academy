package com.tenco.Repo.temp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.temp.RoomRepository;
import com.tenco.model.temp.RoomDTO;
import com.tenco.model.temp.TuitionDTO;
import com.tenco.util.DBUtil;

public class RoomRepositoryImpl implements RoomRepository{
	private static final String SELECT_ROOM_ALL="select * from tb_room ";
	private static final String SELECT_ROOM_BY_ID="select * from tb_room where id=? ";
	private static final String SELECT_ROOM_BY_COOLEGE="select * from tb_room where college_id=? ";
	private static final String ADD_ROOM="insert into tb_room values(?, ?) ";
	private static final String UPDATE_ROOM="update tb_room set id=? or college_id=? where id=? ";
	private static final String DELETE_ROOM="delete from tb_room where id=? ";
	
	
	
	@Override
	public List<RoomDTO> selectRoomAll() {
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
	public RoomDTO selectRoomById(String id) {
		RoomDTO roomDTO = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ROOM_BY_ID)) {
				pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				roomDTO=RoomDTO.builder()
						.id(rs.getString("id"))
						.collegeId(rs.getInt("college_id"))
						.build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return roomDTO;
	}

	@Override
	public void addRoom(RoomDTO roomDTO) {
		
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(ADD_ROOM)){
				pstmt.setString(1, roomDTO.getId());
				pstmt.setInt(2, roomDTO.getCollegeId());
				pstmt.executeUpdate();
				conn.commit();
				System.out.println("add커밋됨:" +roomDTO.toString() );
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateRoom(RoomDTO roomDTO, String id) {
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(UPDATE_ROOM)){
				pstmt.setString(3, roomDTO.getId());
				pstmt.setInt(2, roomDTO.getCollegeId());
				pstmt.setString(1, id);
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
	public void deleteRoom(String id) {
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(DELETE_ROOM)){
				pstmt.setString(1, id);
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
	public List< RoomDTO> selectRoomByCollegeId(int id) {
		List<RoomDTO> roomList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ROOM_BY_COOLEGE)) {
				pstmt.setInt(1, id);
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

}
