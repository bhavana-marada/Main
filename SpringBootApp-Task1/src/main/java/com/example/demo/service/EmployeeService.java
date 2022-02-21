package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFoundException;



public interface EmployeeService {
	public EmployeeDto createEmp(EmployeeDto employee) ;
	
	//public Employee getEmployeeById(int id); //throws EmployeeNotFoundException;
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException;
	
	public List<Employee> getEmployees();
	
	public String healthCheck(int id);
	
}
