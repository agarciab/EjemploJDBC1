package com.vn.dao;

import java.util.List;

import com.vn.model.Employee;

public interface EmployeeDao extends Dao<Employee, Integer> {

	public List<Employee> getEmployeesGreaterThanId(Integer id);
}
