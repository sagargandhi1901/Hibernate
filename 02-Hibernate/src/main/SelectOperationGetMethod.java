package main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import model.Employee;
import util.HibernateUtil;

public class SelectOperationGetMethod {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Employee employee = null;
		int id = 20;

		try {
			if (session != null)
				employee = session.get(Employee.class, id);
			if (employee != null)
				System.out.println(employee);
			else
				System.out.println("Employee record not available for the given id :: " + id);
		} catch (HibernateException e) {
			System.out.println(employee);
			System.out.println("Employee record not found for the given id :: " + id);
		}
	}
}