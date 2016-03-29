package com.myapp.dao;

import com.myapp.model.User;

public interface UserDAO {

	public void add(User user);

	public boolean validateLogin(User user);
}
