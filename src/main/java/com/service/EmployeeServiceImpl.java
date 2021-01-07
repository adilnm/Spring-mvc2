package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeDao;
import com.dto.EmployeeDTO;



@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao ;

	@Override
	public EmployeeDTO authenticate(String emailId, String password) {
		System.out.println("i m from service"+emailId +"" +password);
		employeeDao.authenticate(emailId, password);
		
		
		
		return null;
	}
	
	
	
	

}
