package bulkoperationselect;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.query.Query;

import util.HibernateUtil;

public class SelectRecordApp {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		/*
		 * using getResultList() to retrive the records try { Query<Employee> query =
		 * session.
		 * createQuery("FROM in.ineuron.Model.Employee WHERE eno>=:id1 AND eno<=:id2");
		 * query.setParameter("id1", 7); query.setParameter("id2", 10);
		 * 
		 * List<Employee> empRecords = query.getResultList();
		 * empRecords.forEach(System.out::println);
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } finally {
		 * HibernateUtil.closeSession(session); HibernateUtil.closeSessionFactory(); }
		 */

		/*
		 * using list() to retrive the records try {
		 * 
		 * Query<Employee> query =
		 * session.createQuery("FROM in.ineuron.Model.Employee"); List<Employee>
		 * employees = query.list(); employees.forEach(employee ->
		 * System.out.println(employee));
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } finally {
		 * HibernateUtil.closeSession(session); HibernateUtil.closeSessionFactory(); }
		 */

		
		/* using iterate() to retrieve the records */
		try {
			Query query = session.createQuery("FROM in.ineuron.Model.Employee");
			Iterator<Employee> itr = query.iterate();
			while (itr.hasNext()) {
				System.out.println(itr.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

}
