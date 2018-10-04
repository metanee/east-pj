package com.east.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.east.model.Employee;
import com.east.repository.CompanyRepository;
import com.east.repository.EmployeeRepository;
import com.east.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Employee findOne(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findOne(id) ;
	}



}
