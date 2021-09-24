package com.irreporter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String [] args){
		// Create a configuration instance
		Configuration configuration = new Configuration();
		// Provide configuration file
		configuration.configure("hibernate.cfg.xml");
		// Build a SessionFactory
		SessionFactory factory = configuration.buildSessionFactory();
		// Get current session, current session is already associated with Thread
		Session session = factory.getCurrentSession();
		// Begin transaction, if you would like save your instances, your calling of save must be associated with a transaction
		session.getTransaction().begin();
		// Create employee

		// Save

		// Commit, calling of commit will cause save an instance of employee
		session.getTransaction().commit();
	}
}
