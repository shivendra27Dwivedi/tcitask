package com.tcilab.tci.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcilab.tci.dto.CurrencyGroupDto;
import com.tcilab.tci.dto.EmployeeDTO;
import com.tcilab.tci.dto.EmployeeDto;
import com.tcilab.tci.entity.EmployeeEntity;
import com.tcilab.tci.repository.DepartmentRepository;
import com.tcilab.tci.repository.EmployeeRepository;
import com.tcilab.tci.service.EmployeeService;

@RestController
@RequestMapping("/tci")
public class EmployeeController {
	
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private EmployeeService  employeeService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@PostMapping("/employee-bonus")
	public ResponseEntity<?> addEmployees(@RequestBody List<EmployeeDto> employees){
		
		System.out.println(employees.get(0).getEmpName());
		
	//	List<EmployeeEntity> listEmployee =   employees.stream().map(o -> modelMapper.map(o, EmployeeEntity.class)).collect(Collectors.toList());
		employeeService.addEmployees(employees);
		return new ResponseEntity<>("Employee data",HttpStatus.OK);
	}
	
	@GetMapping("/employee-bonus")
	public Map<String, List<CurrencyGroupDto>> getBonus(
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		List<CurrencyGroupDto> result = new ArrayList<>();
		try {
			List<EmployeeEntity> employees = employeeRepository.findByJoiningDateBeforeAndExitDateAfter(date, date);

			Map<String, List<EmployeeDTO>> groupedEmployees = employees.stream().collect(Collectors.groupingBy(
					EmployeeEntity::getCurrency,
					Collectors.mapping(e -> new EmployeeDTO(e.getEmpName(), e.getAmount()), Collectors.toList())));

			for (Map.Entry<String, List<EmployeeDTO>> entry : groupedEmployees.entrySet()) {
				CurrencyGroupDto dto = new CurrencyGroupDto();
				dto.setCurrency(entry.getKey());
				dto.setEmployees(entry.getValue());
				result.add(dto);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Collections.singletonMap("data", result);
	}
	

}
