package com.ecommerce.utl;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.ecommerce.model.User;
import com.ecommerce.model.AdminOrder;
import com.ecommerce.model.UserOrder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	 
	 public static SessionFactory getSessionFactory() {
	  if (sessionFactory == null) {
	   try {
	    Configuration configuration = new Configuration();

	    // Hibernate settings equivalent to hibernate.cfg.xml's properties
	    Properties settings = new Properties();
	    settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	    settings.put(Environment.URL, "jdbc:mysql://localhost:3306/demo?useSSL=false&"
	    		+ "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
	    settings.put(Environment.USER, "root");
	    settings.put(Environment.PASS, "1234");
	    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

	    settings.put(Environment.SHOW_SQL, "true");

	    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

	    settings.put(Environment.HBM2DDL_AUTO, "validate");

	    configuration.setProperties(settings);
	    configuration.addAnnotatedClass(User.class);
	    configuration.addAnnotatedClass(AdminOrder.class);
	    configuration.addAnnotatedClass(UserOrder.class);

	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	      .applySettings(configuration.getProperties()).build();
	    System.out.println("Hibernate Java Config serviceRegistry created");
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;

	   } catch (Exception e) {
	    e.printStackTrace();
	   }
	  }
	  return sessionFactory;
	 }
}
