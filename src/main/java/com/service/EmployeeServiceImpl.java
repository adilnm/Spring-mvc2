package com.service;

import java.util.ArrayList;
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
		EmployeeDTO employeeDTO = new EmployeeDTO();
		EmployeeEntity employeeEntity = employeeDao.authenticate(emailId, password);
		if (employeeEntity != null) {
			BeanUtils.copyProperties(employeeEntity, employeeDTO);
			return employeeDTO;
		}

		return null;
	}

	@Override
	public List<EmployeeDTO> findAllEmployees() {
		List<EmployeeEntity> allEmployees = employeeDao.findAllEmployees();
		List<EmployeeDTO> employeeDtoList = new ArrayList();
		for (EmployeeEntity employee : allEmployees) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			BeanUtils.copyProperties(employee, employeeDTO);
			employeeDtoList.add(employeeDTO);
		}
		return employeeDtoList;
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

	@Override
	public EmployeeDTO show(int employee_id) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		EmployeeEntity employeeEntity = employeeDao.show(employee_id);
		if (employeeEntity != null) {
			BeanUtils.copyProperties(employeeEntity, employeeDTO);
			return employeeDTO;
		}

		return null;
	}

	@Override
	public boolean update(int employeeId, String empName, String emailId, String password, int salary) {
		boolean success = employeeDao.update(employeeId, empName, emailId, password, salary);
		return success;

	}

	@Override
	public boolean delete(int employeeId) {
		boolean success = employeeDao.delete(employeeId);
		return false;
	}

	@Override
	public EmployeeDTO search(String employeeName) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		EmployeeEntity employeeEntity = employeeDao.search(employeeName);
		if (employeeEntity != null) {
			BeanUtils.copyProperties(employeeEntity, employeeDTO);
			return employeeDTO;
		}

		return null;
	}

	@Override
	public String forget(String emailId) {
		String password = employeeDao.forget(emailId);
		return password;
	}

}
