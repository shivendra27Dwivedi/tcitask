package com.tcilab.tci.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
public class EmployeeDto {
	private String empName;
	private BigDecimal amount;
	private String currency;
	private Date joiningDate;
	private Date exitDate;
	private String department;
	
	public EmployeeDto() {
		
	}
	
	
	
	public EmployeeDto(String empName, BigDecimal amount, String currency, Date joiningDate, Date exitDate,
			String department) {
		super();
		this.empName = empName;
		this.amount = amount;
		this.currency = currency;
		this.joiningDate = joiningDate;
		this.exitDate = exitDate;
		this.department = department;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
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
