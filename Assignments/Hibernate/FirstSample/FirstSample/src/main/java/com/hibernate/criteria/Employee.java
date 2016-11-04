package com.hibernate.criteria;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ 
	@NamedQuery(name = "getAllEmployee", query = "from Employee")

})
@Entity
@Table(name = "EMP")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SALARY")
	private float salary;
	
	@Column(name = "COMMISSION")
	private float commission;
	
	@Column(name = "ROLE")
	private String role;
	
	@Column(name = "DEPT_NO")
	private int deptNo;
	
	@Column(name = "HIRED_DATE")
	private Date hiredDate;
	
	@Column(name = "MANAGER_ID")
	private Integer managerID;

	public Employee() {
	}

	public Employee(String name, float salary, float commission, String role, int deptNo, Date hiredDate,
			int managerID) {
		super();
		this.name = name;
		this.salary = salary;
		this.commission = commission;
		this.role = role;
		this.deptNo = deptNo;
		this.hiredDate = hiredDate;
		this.managerID = managerID;
	}

	public Employee(String name, float salary, float commission, String role, int deptNo) {
		super();
		this.name = name;
		this.salary = salary;
		this.commission = commission;
		this.role = role;
		this.deptNo = deptNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public float getCommission() {
		return commission;
	}

	public void setCommission(float commission) {
		this.commission = commission;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public Date getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(Date hiredDate) {
		this.hiredDate = hiredDate;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", commission=" + commission + ", role="
				+ role + ", deptNo=" + deptNo + ", hiredDate=" + hiredDate + ", managerID=" + managerID + "]";
	}
	

}
