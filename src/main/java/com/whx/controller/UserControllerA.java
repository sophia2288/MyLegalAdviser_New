package com.whx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whx.entities.User;
import com.whx.service.UserService;

@Controller
public class UserControllerA {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/testA")
	public ModelAndView testMVCA() {
		System.out.println("testMVCA()");
		List<User> list = userService.getAllUsers();
		System.out.println("list.size():" + list.size());
		ModelAndView modelAndView = new ModelAndView("testA");
		modelAndView.addObject("info", "whx_A");
		return modelAndView;
	}
	
	@RequestMapping(value = "/addUser")
	public ModelAndView addUser() {
		User user= new User();
		user.setAccount("sharp520@sina.com");
		user.setPassword("whx657654");
		user.setCategory("律师");
		user.setPhone("65686981");
		user.setConcerns("民间借贷纠纷，婚姻家庭");
		user.setContributions((short) 32);
		
		userService.addUser(user);
		
		List<User> list = userService.getAllUsers();
		System.out.println("list.size():" + list.size());
		ModelAndView modelAndView = new ModelAndView("testA");
		modelAndView.addObject("info", "whx_A");
		return modelAndView;
	}
	
	@RequestMapping(value = "/createUser")
	public String createUser(Model model) {
		List<String> categories = userService.getAllUserCategories();
		model.addAttribute("categories", categories);
		model.addAttribute("user", new User());
		return "CreateUserForm";
	}
	
	@RequestMapping(value = "/saveUser")
	public String saveUser(@ModelAttribute User user,Model model) {
		user.setContributions((short)0);
		userService.addUser(user);
		model.addAttribute("userN", user);
		return "UserDetails";
	}
}