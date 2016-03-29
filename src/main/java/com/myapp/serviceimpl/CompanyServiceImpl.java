package com.myapp.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.myapp.dao.CompanyDAO;
import com.myapp.model.Company;
import com.myapp.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	CompanyDAO companyDao;

	public void setCompanyDao(CompanyDAO companyDao) {
		this.companyDao = companyDao;
	}

	@Override
	@Transactional
	public List<Company> getCompanies() {
		return this.companyDao.getCompanies();

	}

	@Override
	@Transactional
	public void addCompany(Company company) {
		this.companyDao.addCompany(company);
	}

	@Override
	@Transactional
	public Company getLatestCompany() {
		return this.companyDao.getLatestCompany();
	}

}
