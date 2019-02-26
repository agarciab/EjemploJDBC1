package com.vn.dao;

import java.util.List;

import com.vn.model.Room;

public interface RoomDao {

	public Room findById(Integer id);
	
	public List<Room> findAll();
	
	public int countByBuilding(Integer buildingId); 
}
