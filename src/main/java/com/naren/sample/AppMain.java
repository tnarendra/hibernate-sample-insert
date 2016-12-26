package com.naren.sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.sample.entity.Address;
import com.naren.sample.entity.Student;

public class AppMain {

	public static void main(String[] args) {

		Student student = new Student();
		student.setFirstName("FirstName");
		student.setLastName("LastName");
		student.setCellNumber(1234567890);
		
		Address address = new Address();
		address.setStreet("First Street");
		address.setState("MD");
		address.setZip(11111);
		student.setAddress(address);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();
		session.save(student);
		session.save(address);
		session.getTransaction().commit();
		session.close();
	}

}
