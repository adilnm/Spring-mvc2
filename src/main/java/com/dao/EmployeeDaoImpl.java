package com.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.entity.EmployeeEntity;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
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
		
		String sql="select * from employee";
		List<EmployeeEntity> employeeEntityList=jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(EmployeeEntity.class));
		
		return employeeEntityList;
	}

}
