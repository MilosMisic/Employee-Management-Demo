package com.myapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.model.Company;
import com.myapp.service.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	@RequestMapping("/getCompany")
	@ResponseBody
	public List<Company> getEmployee() {
		return this.companyService.getCompanies();
	}

	@RequestMapping("/addCompany")
	public String addEmployee(@ModelAttribute() Company company) {
		this.companyService.addCompany(company);
		return "index";
	}

	@RequestMapping(value = "/getLatestCompany")
	@ResponseBody
	public Company getLatestEmployee() {
		return this.companyService.getLatestCompany();
	}

}