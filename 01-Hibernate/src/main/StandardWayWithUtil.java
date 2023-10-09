package main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Employee;
import util.HibernateUtil;

public class StandardWayWithUtil {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
			}
			
			if (transaction != null) {
				Employee employee = new Employee();
				employee.setEmpId(10);
				employee.setEmpName("Sagar");
				employee.setEmpSalary(20000.0);
				
				session.save(employee);
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag == true) {
				transaction.commit();
			} else {
				transaction.rollback();
			}
			
			HibernateUtil.closeSession(session);
		}
	}
}