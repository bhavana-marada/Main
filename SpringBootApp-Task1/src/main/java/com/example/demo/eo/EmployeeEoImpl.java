package com.example.demo.eo;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.dao.EmployeeRepository;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFoundException;

@Component
public class EmployeeEoImpl implements EmployeeEo{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	Logger logger = LoggerFactory.getLogger(EmployeeEoImpl.class);

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employee) {
		
		logger.info("saved details in EO Layer");
		return employeeRepository.save(employee);
	}

	@Override
	public List<EmployeeDto> getEmployees() {
		
		logger.info("saved details in EO Layer");
		return employeeRepository.findAll();
	}

	@Override
	public String healthCheck(int id) {
		logger.info("Health check in EO");
		Optional<EmployeeDto> s = employeeRepository.findById(id);
		if(s.isPresent()) {
			return ("HealthCheck-Success");
		}
		else {
			return ("HealthCheck-Failure");
		}
	}
	
	@Override
	public EmployeeDto getEmployeeById(int id) throws EmployeeNotFoundException{
		logger.info("fetched data of given emp id in EO");
		Optional<EmployeeDto> employee =  employeeRepository.findById(id);
		EmployeeDto s = null;
		if(employee.isPresent()) {
			s = employee.get();
				logger.info("retrieve all method in progress");
			return s;
		}
		else {
			//logger.info("No Records Found");
			throw new EmployeeNotFoundException("No Records Found");

		}
    }
	
	

	

}
