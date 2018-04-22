package com.whx.dao;

import java.util.List;
import com.whx.entities.User;

public interface UserDao {
	public void save(User user);

	public boolean delete(User user);

	public boolean delete(String account);

	public boolean update(User user);

	public User findById(String account);

	public List<User> findAll();

	public List<String> getCategories();

	public boolean exists(String account);// 检测用户名是否存在
}
