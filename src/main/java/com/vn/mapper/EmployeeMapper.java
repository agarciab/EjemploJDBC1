package com.vn.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.vn.model.Employee;

@Component
public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setEmployeeId(rs.getInt("employee_id"));
		emp.setName(rs.getString("name"));
		emp.setRoom(rs.getInt("room"));
		emp.setTelf(rs.getInt("telf"));
		return emp;
	}

	
}
