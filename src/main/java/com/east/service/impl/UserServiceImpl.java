package com.east.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.east.model.User;
import com.east.model.UserRole;
import com.east.repository.RoleRepository;
import com.east.repository.UserRepository;
import com.east.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	//@Transactional //มีปัญหา
	public User createUser(User user, Set<UserRole> userRoles) {
		User localUser = userRepository.findByUsername(user.getUsername());
		if(localUser != null) {
			LOG.info("User with username {} already exist. Nothing will be done.", user.getUsername());
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
				
			}
			user.getUserRoles().addAll(userRoles);
			localUser = userRepository.save(user);
		}
		// TODO Auto-generated method stub
		return localUser;
	}


	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}


	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}


	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}


	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}


	@Override
	public User findOne(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}


	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
  List<User> userList = (List<User>) userRepository.findAll();
		
		List<User> activeBookList = new ArrayList<>();
		
		for (User user : userList) {
			if(user.isEnabled()) {
				activeBookList.add(user);
			}
		}
		
		return activeBookList;
	}


	@Override
	public void removeOne(Long id) {
		userRepository.delete(id);
		
	}


	/*@Override
	public List<User> blurrySearch(String keyword) {
		List<User> userSearch = userRepository.findByIdcardContaining(keyword);
		return userSearch;
	}*/


	@Override
	public User findByIdcard(String idcard) {
		User user = userRepository.findByIdcard(idcard);
		return user;
	}
	
	
}
