package com.service;

import java.util.List;

import com.dto.EmployeeDTO;

public interface EmployeeService {

	EmployeeDTO authenticate(String emailId, String password);

	EmployeeDTO show(int employee_id);

	List<EmployeeDTO> findAllEmployees();

	boolean register(String empName, String emailId, String password, int salary);

	boolean update(int employeeId, String empName, String emailId, String password, int salary);

	boolean delete(int employeeId);

	EmployeeDTO search(String employeeName);

	String forget(String emailId);

	// List<Employee>findEmployee(emailId,password);

}
