package com.vn.dao;

import java.util.List;

import com.vn.model.Employee;

public interface EmployeeDao {

	public List<Employee> getEmployeesGreaterThanId(Integer id);
}
