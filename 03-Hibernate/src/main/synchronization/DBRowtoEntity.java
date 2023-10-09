package main.synchronization;

import org.hibernate.Session;

import model.Employee;
import util.HibernateUtil;

public class DBRowtoEntity {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Employee employee = null;

		try {
			employee = session.get(Employee.class, 20);
			if (employee != null) {
				System.out.println("Before any modification :: " + employee);

				System.in.read();//pause the execution(mean while make some change by going to database)
				
				session.refresh(employee);
				System.out.println("After modification in the dbTable :: " + employee);

			} else {
				System.out.println("Record not avaialble...");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
