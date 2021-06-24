package com.rest.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.model.User;
import com.rest.repository.UserRepository;

@Service
@Transactional
public class UserService implements IUserService {
	@Autowired
	UserRepository userRepo;

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			user = userRepo.findById(id).
					orElseThrow(() -> new Exception("user not found for this id :: " + id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	@Transactional
	public boolean deleteUser(Long id) {
		// TODO Auto-generated method stub
		if( this.getUser(userRepo, id) == true) {
			userRepo.deleteById(id);
			System.out.println("Zio canaglio eliminato");
			return true;
		}else {
			return false;
		}
	};
	
	private static boolean getUser(UserRepository repo,long id) {
		User us = repo.getOne(id);
		if(us == null) {
			return false;
		}else {
			System.out.println("Zio canaglio");
			return true;
		}
	}

}
