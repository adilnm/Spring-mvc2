package com.dao;

import java.util.List;

import com.entity.EmployeeEntity;

public interface EmployeeDao {

	EmployeeEntity authenticate(String emailId, String password);

	List<EmployeeEntity> findAllEmployees();

	int register(String empName, String emailId, String password, int salary);

	EmployeeEntity show(int employee_id);

	boolean update(int employeeId, String empName, String emailId, String password, int salary);

	boolean delete(int employeeId);

	EmployeeEntity search(String employeeName);

	String forget(String emailId);

}
