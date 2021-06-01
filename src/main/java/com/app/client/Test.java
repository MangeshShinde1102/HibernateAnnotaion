package com.app.client;

import org.hibernate.Session;

import com.app.Utility.HibernateUtility;
import com.app.model.Pancard;
import com.app.model.Person;

public class Test {

	public void save() {
		Person person=new Person();
		person.setName("Mangesh");
		
		Pancard pancard=new Pancard();
		pancard.setPanNo("MANG1994Uni");
		person.setPancard(pancard);
//		pancard.setPerson(person);
		
		Session session=HibernateUtility.getSessionFactory().openSession();
		session.save(person);
		
		session.beginTransaction().commit();
		System.out.println("Saved");
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public void selectAll() {
		Session session=HibernateUtility.getSessionFactory().openSession();
		session.createCriteria(Person.class).list().forEach(System.out::println);
		session.close();
	}
	public static void main(String[] args) {
		Test t = new Test();
		t.save();
		t.selectAll();
	}

}
