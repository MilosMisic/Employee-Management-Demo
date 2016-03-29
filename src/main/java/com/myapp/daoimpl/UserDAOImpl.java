package com.myapp.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.myapp.dao.UserDAO;
import com.myapp.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(User user) {
		Session hses = this.sessionFactory.getCurrentSession();
		hses.persist(user);
	}

	@Override
	public boolean validateLogin(User user) {
		Session hses = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<User> users = hses.createQuery("from User").list();
		for (User u : users) {
			if (u.getUsername().equals(user.getUsername()) && (u.getPassword().equals(user.getPassword()))) {
				return true;
			}
		}
		return false;
	}

}
