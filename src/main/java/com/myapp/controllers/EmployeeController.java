package com.myapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.model.Employee;
import com.myapp.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute() Employee employee) {
		this.employeeService.addEmployee(employee);
		return "index";
	}

	@RequestMapping(value = "/deleteEmployee{id}", method = RequestMethod.POST)
	public String deleteEmployee(@PathVariable("id") int id) {
		this.employeeService.removeEmployee(id);
		return "index";
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
	public String editEmployee(@ModelAttribute() Employee employee) {
		this.employeeService.editEmployee(employee);
		return "index";
	}

	@RequestMapping("/getEmployee")
	@ResponseBody
	public List<Employee> getEmployee() {
		return this.employeeService.getEmployees();
	}

	@RequestMapping(value = "/getSingleEmployee{id}")
	@ResponseBody
	public Employee getSingleEmployee(@PathVariable("id") int id) {
		return this.employeeService.getEmployee(id);
	}

	@RequestMapping(value = "/getLatestEmployee")
	@ResponseBody
	public Employee getLatestEmployee() {
		return this.employeeService.getLatestEmployee();
	}

}
