package com.vn.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vn.model.Room;


public class RoomMapper implements RowMapper<Room>{

	@Override
	public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
		Room room = new Room();
		room.setRoomId(rs.getInt("room_id"));
		room.setName(rs.getString("name"));
		room.setBuilding(rs.getInt("building"));
		return room;
	}

	
}
