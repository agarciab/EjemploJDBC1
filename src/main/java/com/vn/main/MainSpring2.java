package com.vn.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vn.conf.Config;
import com.vn.dao.EmployeeDao;
import com.vn.model.Employee;

public class MainSpring2 {

	public static void main(String[] args) {
		// Crear context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Config.class);
		context.refresh();
		
		// Recuperar el bean
		EmployeeDao empDao = context.getBean(EmployeeDao.class);
		
		// Usar el bean
		for (Employee emp:empDao.getEmployeesGreaterThanId(5)) {
			System.out.println(emp);
		}
		
		// Tancar context
		context.close();
	}

}
