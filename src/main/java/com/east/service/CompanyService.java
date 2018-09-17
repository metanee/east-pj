package com.east.service;

import java.util.Set;

import com.east.model.Company;
import com.east.model.Employee;
import com.east.model.User;
import com.east.model.UserRole;

public interface CompanyService {

	Company createCompany(Company company, Set<UserRole> userRoles);
	Company findByUsername(String username);
	Company findByEmail (String email);
	 

	Company save(Company company);
	 
	Company findById(Long id);
	
	void updateUserPaymentInfo(Employee employee, Company company, User user);

}
