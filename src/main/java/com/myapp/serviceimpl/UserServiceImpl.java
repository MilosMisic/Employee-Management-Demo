package com.myapp.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.myapp.dao.UserDAO;
import com.myapp.model.User;
import com.myapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	UserDAO userDao;

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public void add(User user) {
		this.userDao.add(user);

	}

	@Override
	@Transactional
	public boolean validateLogin(User user) {
		return this.userDao.validateLogin(user);
	}

}
