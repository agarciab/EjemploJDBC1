package com.vn.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vn.conf.Config;
import com.vn.dao.BuildingDao;
import com.vn.model.Building;

public class MainSpring3 {

	public static void main(String[] args) {
		// Crear context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Config.class);
		context.refresh();
		
		// Recuperar el bean
		BuildingDao buildingDao = context.getBean(BuildingDao.class);
		
		// Usar el bean
		Building greenRay = buildingDao.findById(101);
		System.out.println(greenRay);
		System.out.println("\n\n\n\n");
		
		Building b = new Building();
		b.setBuildingId(102);
		b.setName("Empire State");
		buildingDao.save(b);
		
		greenRay.setName("Green Day");
		buildingDao.save(greenRay);
		
		for (Building building: buildingDao.findAll()) {
			System.out.println(building);
		}
		
		buildingDao.delete(b);
		
		System.out.println("\n\n\n\n");
		for (Building building: buildingDao.findAll()) {
			System.out.println(building);
		}
		
		// Tancar context
		context.close();
	}

}
