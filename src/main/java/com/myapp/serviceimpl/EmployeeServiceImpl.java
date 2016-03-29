package com.myapp.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.myapp.dao.EmployeeDAO;
import com.myapp.model.Employee;
import com.myapp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO employeeDao;

	public void setEmployeeDao(EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		this.employeeDao.addEmployee(employee);

	}

	@Override
	@Transactional
	public List<Employee> getEmployees() {
		return this.employeeDao.getEmployees();

	}

	@Override
	@Transactional
	public void removeEmployee(int id) {
		this.employeeDao.removeEmployee(id);
	}

	@Override
	@Transactional
	public void editEmployee(Employee employee) {
		this.employeeDao.editEmployee(employee);

	}

	@Override
	@Transactional
	public Employee getEmployee(int id) {
		return this.employeeDao.getEmployee(id);

	}

	@Override
	@Transactional
	public Employee getLatestEmployee() {
		return this.employeeDao.getLatestEmployee();

	}

}
