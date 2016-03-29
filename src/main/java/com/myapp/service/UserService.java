package com.myapp.service;

import com.myapp.model.User;

public interface UserService {
	public void add(User user);

	public boolean validateLogin(User user);
}
