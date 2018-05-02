package com.whx.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.whx.dao.UserDao;
import com.whx.entities.User;
import com.whx.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDao userDao;
	
	public UserServiceImpl() {
		System.out.println("UserServiceImpl()");
	}

	public void addUser(User user) {
		if(!exists(user.getAccount()))
			userDao.save(user);
	}

	public void deleteUser(User user) {
		userDao.delete(user);
	}
	
	public void deleteUser(String account) {
		userDao.delete(account);
	}

	public void updateUser(User user) {
		userDao.update(user);
	}
	
	public User getUser(String account) {
		return userDao.findById(account);
	}
	
	//@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		return userDao.findAll();
	}
	
	public List<String> getAllUserCategories() {
		return userDao.getCategories();
	}
	
	public boolean exists(String account) {
		return userDao.exists(account);
	}
}