package com.whx.dao;

import com.whx.entities.Guidecase;

public interface GuidecaseDao {
	
	public void save(Guidecase guidecase);

	public void delete(Guidecase guidecase);

	public void delete(String guidecaseNo);

	public void update(Guidecase guidecase);

	public Guidecase findById(String guidecaseNo);

	public boolean exists(String guidecaseNo);
	
}
