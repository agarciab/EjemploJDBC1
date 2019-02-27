package com.vn.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vn.conf.Config;
import com.vn.dao.BuildingDao;
import com.vn.dao.EmployeeDao;
import com.vn.dao.RoomDao;
import com.vn.model.Building;
import com.vn.model.Employee;
import com.vn.model.Room;

public class MainSpring4 {

	public static void main(String[] args) {
		// Crear context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Config.class);
		context.refresh();
		
		// Recuperar el bean
		BuildingDao buildingDao = context.getBean(BuildingDao.class);
		RoomDao roomDao = context.getBean(RoomDao.class);
		EmployeeDao employeeDao = context.getBean(EmployeeDao.class);
		
		// Usar el bean
		// Añadir un nuevo edificio – Empire State
		Building b = new Building();
		b.setBuildingId(102);
		b.setName("Empire State");
		buildingDao.save(b);
		
		// Añadir 3 habitaciones al Empire State
		Room r1 = new Room();
		r1.setRoomId(204);
		r1.setName("Hab 1");
		r1.setBuilding(102);
		roomDao.save(r1);
		
		Room r2 = new Room();
		r2.setRoomId(205);
		r2.setName("Hab 2");
		r2.setBuilding(102);
		roomDao.save(r2);
		
		Room r3 = new Room();
		r3.setRoomId(206);
		r3.setName("Hab 3");
		r3.setBuilding(102);
		roomDao.save(r3);
		
		// Añadir 2 empleados por habitacion
		for (int i=0; i<6; i++) {
			Employee e = new Employee();
			e.setEmployeeId(20 + i);
			e.setName("Emp " + i+1);
			e.setTelf(1000 + i);
			e.setRoom(204 + i/2);
			employeeDao.save(e);
		}
		
		// Cambiar el numero de telefono de Mohamed a 1000
		Employee emp = employeeDao.findByName("Mohamed");
		emp.setTelf(1000);
		employeeDao.save(emp);
		
		// Eliminar a Salvador
		emp = employeeDao.findByName("Salvador");
		employeeDao.delete(emp);
		
		// Eliminar la habitacion 203
		employeeDao.reubicarEmpleados(203, 201);
		Room r =roomDao.findById(203);
		roomDao.delete(r);
		
		System.out.println("Edificios: ");
		for (Building building: buildingDao.findAll()) {
			System.out.println(building);
		}
		
		System.out.println("Rooms: ");
		for (Room room: roomDao.findAll()) {
			System.out.println(room);
		}
		
		System.out.println("Empleados: ");
		for (Employee e: employeeDao.findAll()) {
			System.out.println(e);
		}
		
		
		// Tancar context
		context.close();
	}

}
