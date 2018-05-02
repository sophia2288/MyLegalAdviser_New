package com.whx.service;

import java.util.List;

import com.whx.entities.User;

public interface UserService {

	public void addUser(User user);

	public void deleteUser(User user);

	public void deleteUser(String account);

	public void updateUser(User user);
	
	public User getUser(String account);

	public List<User> getAllUsers();
	
	public boolean exists(String account);
	
	public List<String> getAllUserCategories();
}
