package com.east.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.east.model.Company;
import com.east.model.Employee;
import com.east.model.User;
import com.east.model.UserRole;
import com.east.repository.CompanyRepository;
import com.east.repository.EmployeeRepository;
import com.east.repository.RoleRepository;
import com.east.repository.UserRepository;
import com.east.service.CompanyService;
import com.east.service.UserService;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;


	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Company createCompany(Company company, Set<UserRole> userRoles) {
		Company localCompany = companyRepository.findByUsername(company.getUsername());
		if(localCompany != null) {
			LOG.info("User with username {} already exist. Nothing will be done.", company.getUsername());
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
				
			}
			
			company.setEmployeeList(new ArrayList<Employee>());


			company.getUserRoles().addAll(userRoles);
			
			
			localCompany = companyRepository.save(company);
		}
		// TODO Auto-generated method stub
		return localCompany;
	}

	@Override
	public Company findByUsername(String username) {
		// TODO Auto-generated method stub
		return companyRepository.findByUsername(username);
	}

	@Override
	public Company findByEmail(String email) {
		// TODO Auto-generated method stub
		return companyRepository.findByEmail(email);
	}

	@Override
	public Company save(Company company) {
		// TODO Auto-generated method stub
		return companyRepository.save(company);
	}

	
	@Override
	public Company findById(Long id) {
		// TODO Auto-generated method stub
		return companyRepository.findOne(id);
	}


	@Override
	public void addEmployeeFromUser(Employee employee, Company company, User user) {
		employee.setCompany(company);
		employee.setUser(user);
		company.getEmployeeList().add(employee);
		
		save(company);		
	}

	@Override
	public List<Company> findAll() {
		  List<Company> companyList =  companyRepository.findAll();
		 return companyList;
	}

}
