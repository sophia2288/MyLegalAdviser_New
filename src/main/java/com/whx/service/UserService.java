package com.whx.service;

import java.util.List;

import com.whx.entities.User;

public interface UserService {

	public void addUser(User user);

	public boolean deleteUser(User user);

	public boolean deleteUser(String account);

	public boolean updateUser(User user);
	
	public User getUser(String account);

	public List<User> getAllUsers();
	
	public boolean exists(String account);
	
	public List<String> getAllUserCategories();
}
