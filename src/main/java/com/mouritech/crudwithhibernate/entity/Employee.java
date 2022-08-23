package com.mouritech.crudwithhibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "employee_info")
@NamedQueries(
		{
			@NamedQuery(
					name="searchEmployeeByName",
					query = "from Employee e where e.empName = :name"
					),
			@NamedQuery(
					name="searchEmployeeByEmail",
					query = "from Employee e where e.empEmail = :email"
					)
		})
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employeeid")
	private Long empId;
	
	@Column(name = "employeename")
	@Size(min=3)
	private String empName;
	
	@Column(name = "employeeemail")
	@Email
	private String empEmail;
	
	@Column(name = "employeemobno")
	@Pattern(regexp = "[0-9]", message="mobile number contains only digits")
	private String empMobileNo;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String empName, String empEmail, String empMobileNo) {
		super();
		this.empName = empName;
		this.empEmail = empEmail;
		this.empMobileNo = empMobileNo;
	}

	public Employee(Long empId, String empName, String empEmail, String empMobileNo) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empMobileNo = empMobileNo;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpMobileNo() {
		return empMobileNo;
	}

	public void setEmpMobileNo(String empMobileNo) {
		this.empMobileNo = empMobileNo;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empMobileNo="
				+ empMobileNo + "]";
	}
	
	
	
	

}
