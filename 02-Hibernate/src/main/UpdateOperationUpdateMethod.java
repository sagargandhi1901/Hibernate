package main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Employee;
import util.HibernateUtil;

public class UpdateOperationUpdateMethod {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Boolean flag = false;
		Transaction transaction = null;

		// updating the total object based on id
		Employee employee = new Employee();
		employee.setEmpId(10);
		employee.setEmpName("Gandhi");
		employee.setEmpSalary(24455.7);

		try {
			transaction = session.beginTransaction();
			session.update(employee);
			flag = true;

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