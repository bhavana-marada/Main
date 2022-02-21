package com.example.demo.exception;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {

	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status ,WebRequest request )
	{
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(error->error.getDefaultMessage()).collect(Collectors.toList());
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler(EmployeeNotFoundException.class)
//	public ResponseEntity<String> handleNameNotFoundException(EmployeeNotFoundException exception)
//	{
//		return new ResponseEntity<String>("No Account details available",HttpStatus.NOT_FOUND);
//	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> employeeNotFound(EmployeeNotFoundException exception) {
	return new ResponseEntity<String>("No Employees available",HttpStatus.NOT_FOUND);
	}
}