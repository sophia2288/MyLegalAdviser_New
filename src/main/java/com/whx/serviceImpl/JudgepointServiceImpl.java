package com.whx.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whx.dao.JudgepointDao;
import com.whx.entities.Judgepoint;
import com.whx.service.JudgepointService;

@Service
public class JudgepointServiceImpl implements JudgepointService{

	@Autowired
	private JudgepointDao judgepointDao;
	
	public JudgepointServiceImpl() {
		System.out.println("JudgepointServiceImpl()");
	}
	
	public void addJudgepoint(Judgepoint judgePoint) {
		if(!exists(judgePoint.getJudgePointId()))
			judgepointDao.save(judgePoint);
	}

	public void deleteJudgepoint(Judgepoint judgePoint) {
		if(exists(judgePoint.getJudgePointId()))
			judgepointDao.delete(judgePoint);
	}

	public void deleteJudgepoint(int judgePointId) {
		if(exists(judgePointId))
			judgepointDao.delete(judgePointId);
	}

	public void updateJudgepoint(Judgepoint judgePoint) {
		if(exists(judgePoint.getJudgePointId()))
			judgepointDao.update(judgePoint);
	}

	public Judgepoint getJudgepointById(int judgePointId) {
		return judgepointDao.findById(judgePointId);
	}

	public List<Judgepoint> getJudgepointsByTitle(String title) {
		return judgepointDao.findByTitle(title);
	}

	public boolean exists(int judgePointId) {
		return judgepointDao.exists(judgePointId);
	}

}
