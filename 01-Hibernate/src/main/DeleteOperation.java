package main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Employee;
import util.HibernateUtil;

public class DeleteOperation {
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
				Employee employee = session.get(Employee.class, 20);
				if (employee != null) {
					session.delete(employee);
					flag = true;
				} else {
					flag = false;
					System.out.println("Record not available for given id");
				}
			}
		} catch (HibernateException e) {
			flag = false;
			e.printStackTrace();
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		} finally {
			if (flag == true) {
				transaction.commit();
				System.out.println("Object deleted succesfully....");
			} else {
				transaction.rollback();
				System.out.println("Object failed to delete....");
			}
			
			HibernateUtil.closeSession(session);
		}
	}
}