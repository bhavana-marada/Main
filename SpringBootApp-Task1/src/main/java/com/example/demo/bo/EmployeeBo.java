package com.example.demo.bo;

import java.util.List;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.exception.EmployeeNotFoundException;

public interface EmployeeBo {
	
	public EmployeeDto saveEmployee(EmployeeDto employee);

	public List<EmployeeDto> getEmployees();
	
	public String healthCheck(int id);
	
	public EmployeeDto  getEmployeeById(int id) throws EmployeeNotFoundException ;
}
