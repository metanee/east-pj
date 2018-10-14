package com.east.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.east.cpn.MailConstructor;
import com.east.cpn.SecurityUtility;
import com.east.model.Company;
import com.east.model.Role;
import com.east.model.User;
import com.east.model.UserRole;
import com.east.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private MailConstructor mailConstructor;
	
	@RequestMapping(value="/newCompany", method=RequestMethod.POST)
	public ResponseEntity newUserPost(
			HttpServletRequest request,
			@RequestBody HashMap<String, String> mapper
			) throws Exception {
		String username = mapper.get("username");
		String userEmail = mapper.get("email");
		String address = mapper.get("address");
		String companyName = mapper.get("companyName");
		
		if(companyService.findByUsername(username) != null) {
			return new ResponseEntity("usernameExists", HttpStatus.BAD_REQUEST);
		}
		
		if(companyService.findByEmail(userEmail) != null) {
		return new ResponseEntity("emailExists", HttpStatus.BAD_REQUEST);
	}
		Company company = new Company();
		company.setUsername(username);
		company.setEmail(userEmail);
		company.setAddress(address);
		company.setCompanyName(companyName);
		
		String password = SecurityUtility.randomPassword();
		String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
		company.setPassword(encryptedPassword);
		Role role = new Role();
		role.setRoleId(2);
		role.setName("ROLE_OWNER");
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(null,company,role));
		companyService.createCompany(company, userRoles);
		
		SimpleMailMessage email = mailConstructor.constructNewCompanyEmail(company, password);
		mailSender.send(email);
		return new ResponseEntity("User Added Successfully", HttpStatus.OK);
		
	}

	@RequestMapping("/getCurrentCompany")
	public Company getCurrentCompany(Principal principal) {
		
		String username = principal.getName();
		Company company = new Company();
		if (null != username) {
			company = companyService.findByUsername(username);
		}
		return company;

 }
	
	@RequestMapping(value="/companyList")
	public List<Company> getBookList() {
	 List<Company> companyList = companyService.findAll();

		System.out.println("55555555555555555555"+companyList);
		return companyList;
	}

}