package com.service;

import java.util.List;

import com.dto.EmployeeDTO;
import com.entity.EmployeeEntity;

public interface EmployeeService {

	EmployeeDTO authenticate(String emailId, String password);

	List<EmployeeEntity> findAllEmployees();

	boolean register(String empName, String emailId, String password, int salary);

	// List<Employee>findEmployee(emailId,password);

}
