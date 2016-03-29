package com.myapp.dao;

import java.util.List;

import com.myapp.model.Employee;

public interface EmployeeDAO {

	void addEmployee(Employee employee);

	List<Employee> getEmployees();

	void removeEmployee(int id);

	void editEmployee(Employee employee);

	Employee getEmployee(int id);

	Employee getLatestEmployee();
}
