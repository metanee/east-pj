package com.east.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.east.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	
	List<Employee> findAll();

}
