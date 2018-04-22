package com.whx.dao;

import java.util.List;
import java.util.Set;

import com.whx.entities.Article;
import com.whx.entities.Law;

public interface LawDao {

	public void save(Law law);

	public boolean delete(Law law);

	public boolean delete(String fullName);

	public boolean update(Law law);

	public Law findById(int lawId);

	public Law findByFullName(String fullName);

	public Set<Article> getArticles(Law law);

	public boolean exists(int lawId);// 检测指定编号的法律文件是否存在

	public boolean exists(String fullName);// 检测指定名称的法律文件是否存在
}
