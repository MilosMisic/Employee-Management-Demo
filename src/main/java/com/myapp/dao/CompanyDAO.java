package com.myapp.dao;

import java.util.List;

import com.myapp.model.Company;

public interface CompanyDAO {

	public List<Company> getCompanies();

	public void addCompany(Company company);

	public Company getLatestCompany();

}
