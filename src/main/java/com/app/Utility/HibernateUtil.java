package com.app.Utility;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	public SessionFactory getSession() {
		Properties prop=new Properties();
		prop.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		prop.setProperty("hibernate.connection.url", "mysql:jdbc://localhost:3306/test");
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		prop.setProperty("hibernate.connection.username", "root");
		prop.setProperty("hibernate.connection.password", "root");
		prop.setProperty("hibernate.hbm2ddl.auto", "update");
		prop.setProperty("hibernate.show_sql", "true");
		
		Configuration confg=new Configuration();
		confg.setProperties(prop);
		
		StandardServiceRegistryBuilder serviceRegistryBuilder=new StandardServiceRegistryBuilder();
		serviceRegistryBuilder.applySettings(confg.getProperties());
		ServiceRegistry service=serviceRegistryBuilder.build();
		
		SessionFactory session=confg.buildSessionFactory(service);
		return session;
	}
}
