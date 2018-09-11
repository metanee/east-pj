package com.east.service;

import java.util.List;
import java.util.Set;

import com.east.model.User;
import com.east.model.UserRole;

public interface UserService {

	 User createUser(User user, Set<UserRole> userRoles);
	 
	 User findByUsername(String username);
	 User findByEmail (String email);
	 
	 User save(User user);
	 
	 User findById(Long id);
	 
	User findOne(Long id);
	
	List<User> findAll();


}
