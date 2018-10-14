package com.east.service;

import com.east.model.Employee;

public interface EmployeeService {

	Employee findOne(Long id); 
	Employee save(Employee employee);
	
	


}
