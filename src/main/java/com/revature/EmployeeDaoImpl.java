package com.revature;

import java.sql.*;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



public class EmployeeDaoImpl implements EmployeeDao{
	private Configuration cfg;
	private SessionFactory factory;

	
	public EmployeeDaoImpl() {
		cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
		
	}
	

	public void addEmployee(Employee employee) throws SQLException {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		session.save(employee);
		t.commit();
		session.close();
		
		
	}

	public void updateEmployee(Employee employee) throws SQLException {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		session.saveOrUpdate(employee);
		t.commit();
		session.close();
	
	}

	public void deleteEmployee(Employee employee) throws SQLException {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		session.remove(employee);
		t.commit();
		session.close();
		
		
	}

	public List<Employee> getAllEmployee() throws SQLException {
		Session session = factory.openSession();
		Query<Employee> q = session.createQuery("from Employee");
	    List<Employee> resultList = q.list();
	    return resultList;
	
	}

	public Employee getEmployeeById(int id) throws SQLException {
		Session session = factory.openSession();
		
		Employee emp = (Employee)session.get(Employee.class, id);
		
		return emp;
	}
}