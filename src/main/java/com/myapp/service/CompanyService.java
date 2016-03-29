package com.myapp.service;

import java.util.List;

import com.myapp.model.Company;

public interface CompanyService {

	public List<Company> getCompanies();

	public void addCompany(Company company);

	public Company getLatestCompany();

}
