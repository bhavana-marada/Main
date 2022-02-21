package com.example.demo.mapper;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-02T09:47:01+0530",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.3.jar, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDto convertToDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId( employee.getId() );
        employeeDto.setName( employee.getName() );
        employeeDto.setAddress( employee.getAddress() );

        return employeeDto;
    }

    @Override
    public Employee convertToEntity(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employeeDto.getId() );
        employee.setName( employeeDto.getName() );
        employee.setAddress( employeeDto.getAddress() );

        return employee;
    }

    @Override
    public List<EmployeeDto> toDtoList(List<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        List<EmployeeDto> list = new ArrayList<EmployeeDto>( employees.size() );
        for ( Employee employee : employees ) {
            list.add( convertToDto( employee ) );
        }

        return list;
    }

    @Override
    public List<Employee> fromDtoList(List<EmployeeDto> employeesDto) {
        if ( employeesDto == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( employeesDto.size() );
        for ( EmployeeDto employeeDto : employeesDto ) {
            list.add( convertToEntity( employeeDto ) );
        }

        return list;
    }
}
