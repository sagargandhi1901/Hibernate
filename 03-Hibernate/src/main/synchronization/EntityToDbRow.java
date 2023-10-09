package main.synchronization;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Employee;
import util.HibernateUtil;

public class EntityToDbRow {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Boolean flag = false;
		Employee employee = null;

		try {
			transaction = session.beginTransaction();
			employee = session.get(Employee.class, 20);
			if (employee != null) {
				System.out.println(employee);
				
				// making a change in the loaded object, which will appear in database after below line executes
				employee.setEmpSalary(5555.5);
				flag = true;
			}else {
				System.out.println("Record not avaialble...");
				System.exit(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("object upated...");
			} else {
				transaction.rollback();
				System.out.println("object failed to update...");
			}
		}
	}

}
