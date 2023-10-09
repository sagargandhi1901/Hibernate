package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Employee;

public class TestApp {
	public static void main(String[] args) {
		
		// Step 1 : creating a configuration object
		Configuration cfg = new Configuration();
		
		// step 2 : configure hibernate.cfg.xml
		cfg.configure();
		
		// step 3 : create session factory object
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		// step 4 : get the session object from session factory
		Session session = sessionFactory.openSession();
		
		// step 5 : begin transaction with a session
		Transaction transaction = session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setEmpId(20);
		employee.setEmpName("Diksha");
		employee.setEmpSalary(20000.0);
		
		// step 6 : perform database operation (saving the data)
		session.save(employee);
		
		// step 7 : perform transaction operations
		transaction.commit();
		
		// step 8 : close the session
		session.close();
	}
}