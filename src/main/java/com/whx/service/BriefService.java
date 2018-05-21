package com.whx.service;

import com.whx.entities.Brief;

public interface BriefService {
	
	public void addBrief(Brief brief);

	public void deleteBrief(Brief brief);

	public void deleteBrief(String briefId);

	public void updateBrief(Brief brief);
	
	public Brief getBriefById(String briefId);
	
	public boolean exists(String briefId);

	public boolean existsN(String briefName);
	
}
