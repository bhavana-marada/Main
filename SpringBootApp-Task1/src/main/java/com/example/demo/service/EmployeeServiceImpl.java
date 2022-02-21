package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bo.EmployeeBoImpl;
import com.example.demo.dao.EmployeeRepository;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.mapper.EmployeeMapper;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeBoImpl employeeBo;
    
	@Autowired
	private EmployeeMapper employeemapper;
	
//	@Autowired
//	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmp(EmployeeDto employee) {
		
		logger.info(" saved data in service layer");
		return employeeBo.saveEmployee(employee);
	}

	@Override
	public List<Employee> getEmployees() throws EmployeeNotFoundException{
		
		logger.info("fetched data of Employees in service layer");
		List<Employee> emp = employeemapper.fromDtoList(employeeBo.getEmployees());
		if(emp.isEmpty()) {
			throw new EmployeeNotFoundException("employee not found");
		}
		else {
			return emp;
		}
	}
	
	@Override
	public String healthCheck(int id) {
		logger.info("health check of Employees in service layer");
		return employeeBo.healthCheck(id);
	}

	@Override
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException{
		
		logger.info("fetched data of given employee id in service layer");
		return employeemapper.convertToEntity(employeeBo.getEmployeeById(id));
	}
	
	

}
