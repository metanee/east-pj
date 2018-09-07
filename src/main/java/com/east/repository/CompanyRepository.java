package com.east.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.east.model.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {
	
	Company findByUsername(String username);
	Company findByEmail(String email);
	List<Company> findAll();


}
