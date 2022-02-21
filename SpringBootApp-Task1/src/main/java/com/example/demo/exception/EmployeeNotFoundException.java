package com.example.demo.exception;

import org.springframework.stereotype.Component;

//@Component
public class EmployeeNotFoundException extends RuntimeException{
	EmployeeNotFoundException()
	{
	}
		public EmployeeNotFoundException(String s)
		{
			super(s);
		}
	}
