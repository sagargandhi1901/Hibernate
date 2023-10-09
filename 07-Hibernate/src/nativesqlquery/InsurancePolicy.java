package nativesqlquery;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQuery(name="GET_ALL_POLICY_TYPE",query = "SELECT POLICYID,POLICYNAME,POLICYTYPE FROM INSURANCEPOLICY WHERE POLICYTYPE =:type")
@NamedNativeQuery(name="GET_ALL_POLICIES",query="select * from insurancepolicy",resultClass = InsurancePolicy.class)
@NamedNativeQuery(name="DELETE_POLICY_BY_ID",query = "delete from insurancepolicy where policyid=:id")
public class InsurancePolicy implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyId;

	@Column(length = 20)
	private String policyName;

	@Column(length = 20)
	private String policyType;

	@Column(length = 20)
	private String company;

	private Integer tenure;

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	@Override
	public String toString() {
		return "InsurancePolicy [policyId=" + policyId + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", company=" + company + ", tenure=" + tenure + "]";
	}

}
