package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empTab")
public class EmployeeWithGenerators {
	
	/* @Id
	 * @Column(name = "eid")
	 * @GenericGenerator(name="gen1",strategy = "assigned")
	 * @GeneratedValue(generator = "gen1") 
	 * private Integer empId;
	 */

	/* @Id
	 * @GenericGenerator(name="gen1",strategy = "increment")
	 * @GeneratedValue(generator = "gen1") 
	 * private Integer empId;
	 */

	/* @Id
	 * @GenericGenerator(name = "gen1", strategy = "identity")
	 * @GeneratedValue(generator = "gen1")
	 * @Column(name="eid") 
	 * private Integer empId;
	 */
	
	@Id
	@Column(name = "eid")
	private Integer empId;
	
	@Column(name = "ename", length = 99)
	private String empName;
	
	@Column(name = "esal")
	private Double empSalary;
	
	static {
		System.out.println("Employee.class is loading...");
	}
	
	public EmployeeWithGenerators() {
		System.out.println("Employee class zero agrs constructor is used by hibernate...");
	}
	
	public Integer getEmpId() {
		System.out.println("Employee.getEmpId()");
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
		System.out.println("Employee.setEmpId()");
	}
	public String getEmpName() {
		System.out.println("Employee.getEmpName()");
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
		System.out.println("Employee.setEmpName()");
	}
	public Double getEmpSalary() {
		System.out.println("Employee.getEmpSalary()");
		return empSalary;
	}
	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
		System.out.println("Employee.setEmpSalary()");
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}

}
