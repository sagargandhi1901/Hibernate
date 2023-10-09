package main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Employee;
import util.HibernateUtil;

public class UpdateOperationLoadAndThenUpdate {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Boolean flag = false;
		Transaction transaction = null;
		Employee employee = null;

		try {
			int id = 10;
			employee = session.get(Employee.class, id);
			if (employee != null) {
				transaction = session.beginTransaction();
				employee.setEmpName("Dev");
				employee.setEmpSalary(30000.0);
				session.update(employee);
				flag = true;
			} else {
				System.out.println("Recor not found for the id :: " + id);
				System.exit(0);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object updated...");
			} else {
				transaction.rollback();
				System.out.println("object failed to update...");
			}
		}
	}
}