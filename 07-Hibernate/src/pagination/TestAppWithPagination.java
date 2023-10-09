package pagination;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import util.HibernateUtil;

public class TestAppWithPagination {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();

		// pagination code
		try {
			Criteria criteria = session.createCriteria(Project.class);
			criteria.setFirstResult(1);
			criteria.setMaxResults(3);
			List<Project> list = criteria.list();
			list.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

}
