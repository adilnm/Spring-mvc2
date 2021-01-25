package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.EmployeeEntity;

public class EmployeeORMDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public EmployeeEntity authenticate(String emailId, String password) {
		String hql = " from EmployeeEntity e where e.emailId =:emailId and e.password =:password ";
		// Query query = getSession().createQuery(hql); //Hibernate Query....in place of
		// Query you can also use TypedQuery
		TypedQuery<EmployeeEntity> query = getSession().createQuery(hql);
		query.setParameter("emailId", emailId);
		query.setParameter("password", password);
		EmployeeEntity employeeEntity = null;
		try {
			// employeeEntity = (EmployeeEntity) query.getSingleResult();

			employeeEntity = query.getSingleResult();// (if u use TypedQuery then casting will not be required
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeEntity;
	}

	@Override
	public List<EmployeeEntity> findAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int register(String empName, String emailId, String password, int salary) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EmployeeEntity show(int employee_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(int employeeId, String empName, String emailId, String password, int salary) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int employeeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EmployeeEntity search(String employeeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String forget(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

}
