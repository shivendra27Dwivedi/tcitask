package com.tcilab.tci.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;




@Entity
@Table(name = "employee")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "amount")
	private BigDecimal amount;
	
	@Column(name = "currency")
	private String currency;
	
	@Column(name = "joining_date")
	private Date joiningDate;
	
	@Column(name = "exit_date")
	private Date exitDate;
	
	
	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false)
	private DepartmentEntity department;
	

	public EmployeeEntity() {
		
	}
	


	public EmployeeEntity(Integer id, String empName, BigDecimal amount, String currency, Date joiningDate,
			Date exitDate, DepartmentEntity department) {
		super();
		this.id = id;
		this.empName = empName;
		this.amount = amount;
		this.currency = currency;
		this.joiningDate = joiningDate;
		this.exitDate = exitDate;
		this.department = department;
	}










	public DepartmentEntity getDepartment() {
		return department;
	}










	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}










	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Date getExitDate() {
		return exitDate;
	}
	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}


	@Override
	public String toString() {
		return "EmployeeDto [empName=" + empName + ", amount=" + amount + ", currency=" + currency + ", joiningDate="
				+ joiningDate + ", exitDate=" + exitDate + "]";
	}
	
	

}
