package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.entity.EmployeeEntity;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public EmployeeEntity authenticate(String emailId, String password) {

		EmployeeEntity employeeEntity = null;

		String sql = "Select * from employee where emailId = ? and password = ? ";
		Object[] data = { emailId, password };
		try {
			employeeEntity = jdbcTemplate.queryForObject(sql, data, new BeanPropertyRowMapper<>(EmployeeEntity.class));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return employeeEntity;
	}

	@Override
	public List<EmployeeEntity> findAllEmployees() {

		String sql = "select * from employee";
		List<EmployeeEntity> employeeEntityList = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<>(EmployeeEntity.class));

		return employeeEntityList;
	}

	@Override
	public int register(String empName, String emailId, String password, int salary) {
		int result = 0;
		String sql = "insert into employee (employeeName, salary, emailId, PASSWORD) values(?,?,?,?)";
		Object[] data = { empName, salary, emailId, password };

		try {
			result = jdbcTemplate.update(sql, data);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return result;
	}

	@Override
	public EmployeeEntity show(int employee_id) {
		EmployeeEntity employeeEntity = null;

		String sql = "Select * from employee where employeeId=?";
		Object[] data = { employee_id };
		try {
			employeeEntity = jdbcTemplate.queryForObject(sql, data, new BeanPropertyRowMapper<>(EmployeeEntity.class));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return employeeEntity;
	}

	@Override
	public boolean update(int employeeId, String empName, String emailId, String password, int salary) {
		EmployeeEntity employeeEntity = null;
		int result = 0;
		String sql = "UPDATE employee SET employeeName = ?, salary = ?, emailId=?, PASSWORD=? WHERE  employeeId = ?";
		Object[] data = { empName, salary, emailId, password, employeeId };
		try {
			result = jdbcTemplate.update(sql, data);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (result == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int employeeId) {
		EmployeeEntity employeeEntity = null;
		int result = 0;
		String sql = "delete from employee where employeeId = ?";
		Object[] data = { employeeId };
		try {
			result = jdbcTemplate.update(sql, data);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(result);
		return false;
	}

	@Override
	public EmployeeEntity search(String employeeName) {
		EmployeeEntity employeeEntity = null;
		String sql = "Select * from employee where employeeName = ?";
		Object[] data = { employeeName };
		try {
			employeeEntity = jdbcTemplate.queryForObject(sql, data, new BeanPropertyRowMapper<>(EmployeeEntity.class));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return employeeEntity;
	}

}
