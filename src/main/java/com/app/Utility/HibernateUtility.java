 package com.app.Utility;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.app.model.Address;
import com.app.model.Certification;
import com.app.model.Employee;
import com.app.model.Pancard;
import com.app.model.Person;
import com.app.model.Student;

public class HibernateUtility {
	public static SessionFactory getSessionFactory() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
		properties.setProperty("hibernate.connection.username", "root");
		properties.setProperty("hibernate.connection.password", "root");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");

		Configuration cfg = new Configuration();
		cfg.setProperties(properties);

//		cfg.addAnnotatedClass(Person.class);
//		cfg.addAnnotatedClass(Pancard.class);
//		cfg.addAnnotatedClass(Employee.class);
//		cfg.addAnnotatedClass(Address.class);
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Certification.class);
		StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
		registryBuilder.applySettings(cfg.getProperties());
		ServiceRegistry serviceRegistry=registryBuilder.build();
		
		SessionFactory sessionFactory=cfg.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
}
