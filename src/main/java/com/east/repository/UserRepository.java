package com.east.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.east.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByIdcardContaining(String keyword);
	
	User findByUsername(String username);
	User findByEmail(String email);
	List<User> findAll();
}
