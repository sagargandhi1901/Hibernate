package namedquery;

public class TestApp {

	public static void main(String[] args) {

		InsurancePolicyDao dao = null;
		dao = new InsurancePolicyDaoImpl();
		String result = dao.transferPremiumPolicies(25);
		System.out.println(result);
	}
}
