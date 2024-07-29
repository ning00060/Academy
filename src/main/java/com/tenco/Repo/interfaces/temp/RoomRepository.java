package com.tenco.Repo.interfaces.temp;

import java.util.List;

import com.tenco.model.temp.RoomDTO;

public interface RoomRepository {
	
	List< RoomDTO> selectRoomAll();
	RoomDTO selectRoomById(String id);
	List< RoomDTO> selectRoomByCollegeId(int id);
	void addRoom(RoomDTO roomDTO);
	void updateRoom(RoomDTO roomDTO,String id);
	void deleteRoom(String id);
	
}
