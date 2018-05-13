package com.whx.service;

import com.whx.entities.Brief;

public interface BriefService {
	
	public void addBrief(Brief brief);

	public void deleteBrief(Brief brief);

	public void deleteBrief(String briefId);

	public void updateBrief(Brief brief);
	
	public Brief getBrief(String briefId);
	
	public boolean exists(String briefId);

	public boolean existsN(String briefName);// 检测指定名称的案由是否存在
	
}
