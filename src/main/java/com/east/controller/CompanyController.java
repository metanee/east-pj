package com.east.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.east.model.Company;
import com.east.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	
	@Autowired
	CompanyService companyService;

	@RequestMapping("/getCurrentCompany")
	public Company getCurrentCompany(Principal principal) {
		
		String username = principal.getName();
		Company company = new Company();
		if (null != username) {
			company = companyService.findByUsername(username);
		}
		return company;

 }

}