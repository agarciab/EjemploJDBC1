package com.vn.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.vn.dao.EmployeeDao;
import com.vn.model.Employee;

@Repository
public class EmployeeDaoImpl extends AbstractDao<Employee, Integer> implements EmployeeDao {
	
	@Autowired
	private BeanPropertyRowMapper<Employee> employeeMapper;
	
	@Override
	public List<Employee> getEmployeesGreaterThanId(Integer id) {
		String sql = "SELECT * FROM Employee WHERE employee_id > :employeeId";
		Employee emp = new Employee();
		emp.setEmployeeId(id);
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(emp);
		return namedParameterjdbcTemplate.query(sql, namedParameters, employeeMapper);
	}

	@Override
	public Employee findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Employee t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Employee t) {
		// TODO Auto-generated method stub
		
	}
	

}
