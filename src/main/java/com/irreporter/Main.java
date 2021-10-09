package com.irreporter;

import com.irreporter.models.Incident;
import com.irreporter.models.enums.Status;
import com.irreporter.models.enums.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.irreporter.service.IncidentServiceImpl;


	/**
	 * Function creates dummy incidents, for demonstration purposes.
	 *
	 * @throws Exception
	 */

	public class Main {
		public static void incidentFactory() throws Exception {
			IncidentServiceImpl incidentService = new IncidentServiceImpl();


			String[] incidentTitles = new String[]{"Theft of Funds", "Bribe", "Bad road", "Low labour"};
			String[] incidentComments = new String[]{"Money allocated to health workers", "Officer Bribes", "The road to Kireka", "Poor pay to traffic officers"};
			Type[] incidentTypes = new Type[]{Type.RED_FLAG, Type.RED_FLAG, Type.INTERVENTION, Type.INTERVENTION};
			Status[] incidentStatuses = new Status[]{Status.DRAFT, Status.REJECTED,Status.UNDER_INVESTIGATION,Status.RESOLVED };

			for (int i = 0; i < incidentTitles.length; i++) {
				Incident incident = new Incident();
				incident.setTitle(incidentTitles[i]);
				incident.setComment(incidentComments[i]);
				incident.setType(incidentTypes[i]);
				incident.setStatus(incidentStatuses[i]);
				incidentService.saveIncident(incident);
			}
		}

		public static void main(String[] args) {
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
			try {
				incidentFactory();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Incident incident = new Incident();
			incident.setTitle("Robbery");
			incident.setComment("IT should be fined");
			incident.setType(Type.RED_FLAG);
			session.save(incident);
			// session.getTransaction().commit();

			// Commit, calling of commit will cause save an instance of employee
			session.getTransaction().commit();

		}
	}

