package com.myapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.model.User;
import com.myapp.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/")
	public String login() {
		return "login";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/addUser")
	public String add(@ModelAttribute("user") User user) {
		this.userService.add(user);
		return "login";
	}

	@RequestMapping("/validateLogin")
	public String validateLogin(@ModelAttribute User user) {

		boolean valid = this.userService.validateLogin(user);

		if (valid) {
			return "redirect:/index";

		} else
			return "/";
	}

}