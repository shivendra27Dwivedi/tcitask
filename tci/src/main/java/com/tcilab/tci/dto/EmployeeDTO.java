package com.tcilab.tci.dto;

import java.math.BigDecimal;

public class EmployeeDTO {
	private String empName;
	private BigDecimal amount;

	// getters and setters

	public EmployeeDTO(String empName, BigDecimal amount) {
		this.empName = empName;
		this.amount = amount;
	}
	// Standard getters and setters

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

}