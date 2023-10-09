package bulkoperationselect;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import util.HibernateUtil;

public class SelectRecordApp2 {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		try {

			Query query = session.createQuery("SELECT ename,esalary FROM in.ineuron.Model.Employee where eno<=:id");
			query.setParameter("id", 20);
			List<Object[]> list = query.getResultList();
			System.out.println("NAME"+"\t"+"salary");
			list.forEach(row -> {
				for (Object obj : row)
					System.out.print(obj+"\t");
				System.out.println();
			});

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

}
