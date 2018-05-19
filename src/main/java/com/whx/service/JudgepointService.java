package com.whx.service;

import java.util.List;

import com.whx.entities.Judgepoint;

public interface JudgepointService {
	
	public void addJudgepoint(Judgepoint judgePoint);

	public void deleteJudgepoint(Judgepoint judgePoint);

	public void deleteJudgepoint(int judgePointId);

	public void updateJudgepoint(Judgepoint judgePoint);

	public Judgepoint getJudgepointById(int judgePointId);

	public List<Judgepoint> getJudgepointsByTitle(String title);// 支持模糊查询

	public boolean exists(int judgePointId);
	
}
