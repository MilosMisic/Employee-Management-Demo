package com.myapp.service;

import java.util.List;

import com.myapp.model.Employee;

public interface EmployeeService {

	void addEmployee(Employee employee);

	List<Employee> getEmployees();

	void removeEmployee(int id);

	void editEmployee(Employee employee);

	Employee getEmployee(int id);

	Employee getLatestEmployee();
}
