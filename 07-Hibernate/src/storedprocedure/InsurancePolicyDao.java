package storedprocedure;

import java.util.List;

public interface InsurancePolicyDao {
	
	public List<InsurancePolicy> getPoliciesByTenure(int start, int end);
	
	public String[] getPolicyById(int id);
}
