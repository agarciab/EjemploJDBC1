package com.vn.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.vn.dao.EmployeeDao;
import com.vn.mapper.EmployeeMapper;
import com.vn.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Override
	public List<Employee> getEmployeesGreaterThanId(Integer id) {
		String sql = "SELECT * FROM Employee WHERE employee_id > :employeeId";
		Employee emp = new Employee();
		emp.setEmployeeId(id);
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(emp);
		return jdbcTemplate.query(sql, namedParameters, employeeMapper);
	}
	

}
