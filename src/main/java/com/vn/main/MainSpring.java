package com.vn.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vn.conf.Config;
import com.vn.dao.RoomDao;

public class MainSpring {

	public static void main(String[] args) {
		// Crear context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Config.class);
		context.refresh();
		
		// Recuperar el bean
		RoomDao roomDao = context.getBean(RoomDao.class);
		
		// Usar el bean
		System.out.println(roomDao.findById(201));
		
		// Tancar context
		context.close();
	}

}
