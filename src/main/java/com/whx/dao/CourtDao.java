package com.whx.dao;

import com.whx.entities.Court;

public interface CourtDao {
	
	public void save(Court court);

	public void update(Court court);

	public void delete(Court court);
	
	public void deleteI(String courtCode);

	public void delete(String name);

	public Court findById(String courtCode);

	public Court findByCourtName(String name);

	public boolean exists(String courtCode);

	public boolean existsN(String name);

}
