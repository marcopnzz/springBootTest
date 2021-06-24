package com.rest.service;

import java.util.List;

import com.rest.model.User;

public interface IUserService {
	
	public List<User> getUsers();

	public User saveUser(User user);

	public User getUser(Long id);

	public boolean deleteUser(Long id);
}
