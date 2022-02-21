package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.service.EmployeeService;
import com.example.demo.util.EmployeeConstants;

@RestController
@RequestMapping("/employees")

public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeservice;
	
	@Autowired
	private EmployeeMapper employeemapper;
	
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@PostMapping(value=EmployeeConstants.POST)
	public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeDto employee) 
	{
		Employee saveemployee = employeemapper.convertToEntity(employeeservice.createEmp(employee)); 
    	logger.info("saved details in controller");	 
		return new ResponseEntity<Employee>(saveemployee,HttpStatus.CREATED);
	}

	@GetMapping(value=EmployeeConstants.GET) 
	public ResponseEntity<List<Employee>> getAllEmployees() 
	{
		List<Employee> allemp = employeeservice.getEmployees();
		logger.info("fetched the details of employee in controller ");
		return new ResponseEntity<List<Employee>>(allemp , HttpStatus.OK);
	}
	
	@GetMapping(EmployeeConstants.GETFORHEALTH)
	public ResponseEntity<String> healthCheck(@PathVariable int id){
		String str = employeeservice.healthCheck(id);
		logger.info("HealthCheck Successful");
		return new ResponseEntity<String>(str, HttpStatus.CREATED);
	}
	
	
//	@GetMapping(value="/employee/{id}")
//	public ResponseEntity<Employee> getEmployeeById(@Valid @PathVariable int id) throws EmployeeNotFoundException
//	{   
//		logger.info("fetched the details of Employee with ID !");
//		return new ResponseEntity<Employee>(employeeservice.getEmployeeById(id),HttpStatus.OK);
//	}
	
	@GetMapping(EmployeeConstants.GETBYID)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) throws EmployeeNotFoundException {
	Employee employee= employeeservice.getEmployeeById(id);
	return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}

}
