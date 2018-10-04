package com.east.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.east.model.Comment;
import com.east.model.Company;
import com.east.model.Employee;
import com.east.model.User;
import com.east.service.CommentService;
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
	CommentService commmentService;
	
	@Autowired 
	UserService userService;
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity addNewCreditCardPost (
			@RequestBody HashMap<String, Object> mapper,
			Principal principal) {
		Employee employee = new Employee();
		int id =  (Integer) mapper.get("userId");
		//System.out.println(id);
		Company company = companyService.findByUsername(principal.getName());
		User user = userService.findById(Long.valueOf(id));
		//System.out.println(user.getEmail());
		companyService.addEmployeeFromUser(employee, company ,user );
		
		
		return new ResponseEntity("Payment Added(Updated) Successfully!", HttpStatus.OK);
	}
	

	@RequestMapping(value="/comment", method=RequestMethod.POST)
	public ResponseEntity commentPost (
			@RequestBody HashMap<String, Object> mapper,
			Principal principal) {
		Comment comment = new Comment();
		int userId =  (Integer) mapper.get("userId");
		int employeeId =  (Integer) mapper.get("employeeId");
		
		//System.out.println(id);
		Company company = companyService.findByUsername(principal.getName());
		User user = userService.findById(Long.valueOf(userId));
		Employee employee = employeeService.findOne(Long.valueOf(employeeId));
		System.out.println(company.getId());
		System.out.println(user.getId());
		System.out.println(employee.getEmployeeId());
		
		//System.out.println(user.getEmail());
		commmentService.CreateComment(employee,company, user ,comment );
		
		
		return new ResponseEntity("Payment Added(Updated) Successfully!", HttpStatus.OK);
	}
	
	@RequestMapping("/getEmployeeList")
	public List<Employee> getUserPaymentList(
			Principal principal
			){
		Company company = companyService.findByUsername(principal.getName());
		//System.out.println(company.getEmail());
		List<Employee> userPaymentList = company.getEmployeeList();
		//System.out.println(userPaymentList);
		
		return userPaymentList;
	}
	
	@RequestMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") Long id){
		Employee employee = employeeService.findOne(id);
		//System.out.println(employee.getEmployeeId());
		return employee;
	}
	
}
