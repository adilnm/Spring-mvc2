package com.service;

import com.dto.EmployeeDTO;

public interface EmployeeService {
	
	EmployeeDTO authenticate(String emailId,String password);
	
	//List<Employee>findEmployee(emailId,password);

}
