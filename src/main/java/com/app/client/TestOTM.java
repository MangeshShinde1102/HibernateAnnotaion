package com.app.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.app.Utility.HibernateUtility;
import com.app.model.Address;
import com.app.model.Employee;

public class TestOTM {

	public void save() {
		Session session = HibernateUtility.getSessionFactory().openSession();
		Employee employee = new Employee();
		employee.setName("Mangesh Shinde");

		Address address1 = new Address();
		address1.setCity("Pune");
		address1.setPinCode(445206);
		address1.setEmployee(employee);

		Address address2 = new Address();
		address2.setCity("Nagpur");
		address2.setPinCode(445727);
		address2.setEmployee(employee);

		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address1);
		addresses.add(address2);

		employee.setAddresses(addresses);
		session.save(employee);
		session.beginTransaction().commit();
		System.out.println("Success Saved");
		session.close();
	}

	@SuppressWarnings("unchecked")
	public void selectAll() {
		Session session = HibernateUtility.getSessionFactory().openSession();
		List<Employee> employees= session.createCriteria(Employee.class).list();
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		/*
		 * for (Employee employee : employees) { System.out.println(employee.getName());
		 * List<Address> addresses=employee.getAddresses(); for(Address
		 * address:addresses) { System.out.println(address.getCity());
		 * System.out.println(address.getPinCode()); } }
		 */
	}

	public static void main(String[] args) {
		TestOTM test = new TestOTM();
		test.save();
		test.selectAll();
	}
}
