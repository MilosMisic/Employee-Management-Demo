package com.myapp.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.myapp.dao.EmployeeDAO;
import com.myapp.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addEmployee(Employee employee) {
		Session hses = this.sessionFactory.getCurrentSession();
		hses.persist(employee);
	}

	@Override
	public List<Employee> getEmployees() {
		Session hses = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Employee> employees = hses.createQuery("from Employee").list();
		return employees;
	}

	@Override
	public void removeEmployee(int id) {
		Session hses = this.sessionFactory.getCurrentSession();
		Employee em = (Employee) hses.load(Employee.class, id);
		hses.delete(em);
	}

	@Override
	public void editEmployee(Employee employee) {
		Session hses = this.sessionFactory.getCurrentSession();
		hses.update(employee);
	}

	@Override
	public Employee getEmployee(int id) {
		Session hses = this.sessionFactory.getCurrentSession();
		Employee em = (Employee) hses.get(Employee.class, id);
		return em;
	}

	@Override
	public Employee getLatestEmployee() {
		Session hses = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Employee> employees = hses.createQuery("from Employee").list();
		Employee em = employees.get(employees.size() - 1);
		return em;
	}

}
