package com.vasea.daoIntf;

import java.util.List;

import com.vasea.entities.Users;

public interface UserIntf {

	public void save(Users user);
	public void update(Users user);
	public void delete(int id);
	public Users findById(int id);
	List<String> findUsername();
	
	public Users finfByUsername(String username);
	List<Users> findAll();
	
}
