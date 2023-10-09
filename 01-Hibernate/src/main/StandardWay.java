package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Employee;

public class StandardWay {
	public static void main(String[] args) {
		
		Configuration cfg = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Integer idValue = null;
		boolean flag = false;
		
		cfg = new Configuration();
		cfg.configure();
		System.out.println(cfg.getProperties());
		
		sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		
		Employee employee = new Employee();
		employee.setEmpId(10);
		employee.setEmpName("Sagar");
		employee.setEmpSalary(20000.0);
		
		try {
			transaction = session.beginTransaction();  		// connection.setAutoCommit(false); is done behind
			idValue = (Integer)session.save(employee);
			System.out.println("generated id value :: " + idValue);
			flag = true;
			
		} catch (Exception ex ) {
			ex.printStackTrace();
		} finally {
			if (flag == true) {
				transaction.commit();
			} else {
				transaction.rollback();
			}
			session.close();
			sessionFactory.close();
		}
	}
}