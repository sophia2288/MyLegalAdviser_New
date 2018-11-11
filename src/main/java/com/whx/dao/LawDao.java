package com.whx.dao;

import com.whx.entities.Law;

public interface LawDao {

	public void save(Law law);

	public void delete(Law law);
	
	public void delete(Integer lawId);

	public void delete(String fullName);

	public void update(Law law);

	public Law findById(Integer lawId);

	public Law findByFullName(String fullName);

	//public Set<Article> getArticles(Law law);

	public boolean exists(Integer lawId);// 检测指定编号的法律文件是否存在

	public boolean exists(String fullName);// 检测指定名称的法律文件是否存在
}
