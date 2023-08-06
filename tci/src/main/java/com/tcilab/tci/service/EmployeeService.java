package com.tcilab.tci.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcilab.tci.dto.EmployeeDto;
import com.tcilab.tci.entity.DepartmentEntity;
import com.tcilab.tci.entity.EmployeeEntity;
import com.tcilab.tci.repository.DepartmentRepository;
import com.tcilab.tci.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public void addEmployees(List<EmployeeDto> employees) {
		for (EmployeeDto employee : employees) {
            EmployeeEntity employeeEntity = new EmployeeEntity();
			DepartmentEntity department = departmentRepository.findByName(employee.getDepartment());
			if (department == null) {
				department = new DepartmentEntity();
				department.setName(employee.getDepartment());
				department = departmentRepository.save(department);
			}
			
			employeeEntity.setEmpName(employee.getEmpName());
			employeeEntity.setCurrency(employee.getCurrency());
			employeeEntity.setAmount(employee.getAmount());
			employeeEntity.setExitDate(employee.getExitDate());
			employeeEntity.setJoiningDate(employee.getJoiningDate());
			employeeEntity.setDepartment(department);

			employeeRepository.save(employeeEntity);
		}
	}
	
	
	
	

}
