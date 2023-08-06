package com.tcilab.tci.dto;

import java.util.List;

public class CurrencyGroupDto {
	private String currency;
	private List<EmployeeDTO> employees;

	public CurrencyGroupDto() {
	}

	public CurrencyGroupDto(String currency, List<EmployeeDTO> employees) {
		this.currency = currency;
		this.employees = employees;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public List<EmployeeDTO> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDTO> employees) {
		this.employees = employees;
	}

	
}
