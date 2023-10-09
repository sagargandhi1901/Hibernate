package main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import model.Employee;
import util.HibernateUtil;

public class SelectOperation {
	public static void main(String[] args) {
		Session session = null;
		Employee employee = null;
		
		try {
			session = HibernateUtil.getSession();
			if (session != null) {
//				employee = session.load(Employee.class, 20);
				employee = session.get(Employee.class, 20);
			}
			
			if (employee != null) {
				System.out.println(employee);
			} else {
				System.out.println("Employee record not available for given id");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}
}