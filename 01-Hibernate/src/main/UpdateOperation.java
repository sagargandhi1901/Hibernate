package main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Employee;
import util.HibernateUtil;

public class UpdateOperation {
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
				employee.setEmpSalary(15000.0);
				
				session.saveOrUpdate(employee);
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag == true) {
				transaction.commit();
				System.out.println("Record updated succesfully....");
			} else {
				transaction.rollback();
				System.out.println("Record failed to update....");
			}
			
			HibernateUtil.closeSession(session);
		}
	}
}