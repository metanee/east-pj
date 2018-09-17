package com.east.controller;

import java.security.Principal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.east.model.Company;
import com.east.model.Employee;
import com.east.model.User;
import com.east.service.CompanyService;
import com.east.service.EmployeeService;
import com.east.service.UserService;

@RestController
@RequestMapping("/employee")
public class EmployeeController  {

	@Autowired
	CompanyService companyService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired 
	UserService userService;
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity addNewCreditCardPost (
			@RequestBody HashMap<String, Object> mapper,
			Principal principal) {
		Employee employee = new Employee();
		int id =  (Integer) mapper.get("userId");
		System.out.println(id);
		Company company = companyService.findByUsername(principal.getName());
		User user = userService.findById(Long.valueOf(id));
		System.out.println(user.getEmail());
		companyService.updateUserPaymentInfo(employee, company ,user );
		
		
		return new ResponseEntity("Payment Added(Updated) Successfully!", HttpStatus.OK);
	}
	
	
}
