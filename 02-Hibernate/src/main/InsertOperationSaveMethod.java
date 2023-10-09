package main;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Employee;
import util.HibernateUtil;

public class InsertOperationSaveMethod {
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
				employee.setEmpId(20);
				employee.setEmpName("Diksha");
				employee.setEmpSalary(20000.0);
				
				Serializable serializable = session.save(employee);
				System.out.println("Returned id value is :: " + serializable);
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