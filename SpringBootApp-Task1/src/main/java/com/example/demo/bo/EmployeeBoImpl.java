package com.example.demo.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.eo.EmployeeEo;
import com.example.demo.exception.EmployeeNotFoundException;


@Component
public class EmployeeBoImpl implements EmployeeBo {
	
	@Autowired
	private EmployeeEo employeeEo;
	
	Logger logger = LoggerFactory.getLogger(EmployeeBoImpl.class);

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employee) {
		
		logger.info("save data in BO layer");
		return employeeEo.saveEmployee(employee);
	}

	@Override
	public List<EmployeeDto> getEmployees() {
		
		logger.info("fetched details of employees in BO");
		return employeeEo.getEmployees();
	}
	
	@Override
	public String healthCheck(int id) {
	logger.info("healthcheck in BO ");
	return employeeEo.healthCheck(id);
	}

	@Override
	public EmployeeDto getEmployeeById(int id)  throws EmployeeNotFoundException {
		
		logger.info("fetched of given employee id in BO");
		return employeeEo.getEmployeeById(id);
	}

}

