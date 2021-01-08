package com.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeDao;
import com.dto.EmployeeDTO;
import com.entity.EmployeeEntity;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public EmployeeDTO authenticate(String emailId, String password) {
		System.out.println("i m from service" + emailId + "" + password);
		EmployeeDTO employeeDTO = new EmployeeDTO();
		EmployeeEntity employeeEntity = employeeDao.authenticate(emailId, password);
		if (employeeEntity != null) {
			BeanUtils.copyProperties(employeeEntity, employeeDTO);
			return employeeDTO;
		}

		return null;
	}

	@Override
	public List<EmployeeEntity> findAllEmployees() {
		List<EmployeeEntity> allEmployees = employeeDao.findAllEmployees();
		return allEmployees;
	}

	@Override
	public boolean register(String empName, String emailId, String password, int salary) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		int result = employeeDao.register(empName, emailId, password, salary);
		if (result != 0) {

			return true;
		}

		return false;
	}

}
