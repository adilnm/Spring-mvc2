package com.dao;

import java.util.List;

import com.entity.EmployeeEntity;

public interface EmployeeDao {

	EmployeeEntity authenticate(String emailId, String password);

	List<EmployeeEntity> findAllEmployees();

	int register(String empName, String emailId, String password, int salary);

}
