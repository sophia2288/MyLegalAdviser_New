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

	public boolean deleteUser(User user) {
		return userDao.delete(user);
	}
	
	public boolean deleteUser(String account) {
		return userDao.delete(account);
	}

	public boolean updateUser(User user) {
		return userDao.update(user);
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