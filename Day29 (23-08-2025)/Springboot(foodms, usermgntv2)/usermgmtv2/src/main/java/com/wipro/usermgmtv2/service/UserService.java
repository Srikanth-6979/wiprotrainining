package com.wipro.usermgmtv2.service;

import java.util.List;

import com.wipro.usermgmtv2.entity.User;

public interface UserService {

	List<User> findAll();
	User findById(int id);
	void save(User user);
	void deleteById(int id);
//	String login(User user);
	User validateUser(String email, String password);
}