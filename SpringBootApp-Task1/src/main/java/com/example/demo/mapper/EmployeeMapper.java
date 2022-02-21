package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;


@Mapper(componentModel = "spring")
public interface EmployeeMapper {
	EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

	
	EmployeeDto convertToDto(Employee employee);
	Employee convertToEntity(EmployeeDto employeeDto);
	List<EmployeeDto> toDtoList(List<Employee> employees);
	List<Employee> fromDtoList(List<EmployeeDto> employeesDto);
	
//	AccountDto toAccountDto(Account account); //convertTODto
//	Account toAccount(AccountDto accountdto); //convertToEntity
//	List<AccountDto> accountsToAccountDtos(List<Account> acounts); //toDtoList
//	List<Account> accountDtosToAccounts(List<AccountDto> accountdtos); //fromDtoList
//	

}