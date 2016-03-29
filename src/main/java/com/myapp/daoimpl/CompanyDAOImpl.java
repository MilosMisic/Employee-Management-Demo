package com.myapp.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.myapp.dao.CompanyDAO;
import com.myapp.model.Company;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Company> getCompanies() {
		Session hses = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Company> companies = hses.createQuery("from Company").list();
		return companies;
	}

	@Override
	public void addCompany(Company company) {
		Session hses = this.sessionFactory.getCurrentSession();
		hses.persist(company);
	}

	@Override
	public Company getLatestCompany() {
		Session hses = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Company> companies = hses.createQuery("from Company").list();
		Company em = companies.get(companies.size() - 1);
		return em;
	}

}
