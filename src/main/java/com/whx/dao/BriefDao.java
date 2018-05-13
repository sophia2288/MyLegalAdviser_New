package com.whx.dao;

import com.whx.entities.Brief;

public interface BriefDao {

	public void save(Brief brief);

	public void update(Brief brief);

	public void delete(Brief brief);
	
	public void deleteI(String briefId);

	public void delete(String briefName);

	public Brief findById(String briefId);

	public Brief findByBriefName(String briefName);

	public boolean exists(String briefId);// 检测指定编号的案由是否存在

	public boolean existsN(String briefName);// 检测指定名称的案由是否存在

}
