package com.app.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.app.Utility.HibernateUtility;
import com.app.model.Certification;
import com.app.model.Student;

public class TestMTM {

	public void save() {
		Student s1 = new Student();
		s1.setName("Mangesh Shinde");
		Student s2 = new Student();
		s2.setName("Mahesh Shinde");

		Certification c1 = new Certification();
		c1.setCourse("JAVA");
		Certification c2 = new Certification();
		c2.setCourse("Python");
		Certification c3 = new Certification();
		c3.setCourse("Web");
		/*
		 * Certification c4= new Certification(); c4.setCourse("Testing");
		 */
		List<Certification> courses1 = new ArrayList<Certification>();
		courses1.add(c1);
		courses1.add(c2);
		List<Certification> courses2 = new ArrayList<Certification>();
		courses2.add(c3);
		courses2.add(c1);

		s1.setCertifications(courses1);
		s2.setCertifications(courses2);

		Session session = HibernateUtility.getSessionFactory().openSession();
		session.save(s1);
		session.save(s2);
		session.beginTransaction().commit();
		System.out.println("Saved!");
		session.close();
	}

	public static void main(String[] args) {
		TestMTM test = new TestMTM();
		test.save();
	}
}
