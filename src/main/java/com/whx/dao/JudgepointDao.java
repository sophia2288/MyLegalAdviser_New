package com.whx.dao;

import java.util.List;

import com.whx.entities.Judgepoint;

public interface JudgepointDao {

	public void save(Judgepoint judgePoint);

	public void delete(Judgepoint judgePoint);

	public void delete(int judgePointId);

	public void update(Judgepoint judgePoint);

	public Judgepoint findById(int judgePointId);

	public List<Judgepoint> findByTitle(String title);// 支持模糊查询

	public boolean exists(int judgePointId);
	
}
