package com.vn.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.vn.dao.RoomDao;
import com.vn.mapper.RoomMapper;
import com.vn.model.Room;

@Repository
public class RoomDaoImpl implements RoomDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public Room findById(Integer id) {
		String sql = "SELECT * FROM Room WHERE room_id=:roomId"; 
		Room room = new Room();
		room.setRoomId(id);
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(room);
		return jdbcTemplate.queryForObject(sql, namedParameters, new RoomMapper());
	}

	@Override
	public List<Room> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countByBuilding(Integer buildingId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
