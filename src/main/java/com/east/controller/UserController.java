package com.east.controller;

import java.util.HashMap;
import java.util.HashSet;
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
import com.east.model.Role;
import com.east.model.User;
import com.east.model.UserRole;
import com.east.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MailConstructor mailConstructor;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="/newUser", method=RequestMethod.POST)
	public ResponseEntity newUserPost(
			HttpServletRequest request,
			@RequestBody HashMap<String, String> mapper
			) throws Exception {
		String username = mapper.get("username");
		String userEmail = mapper.get("email");
		
		if(userService.findByUsername(username) != null) {
			return new ResponseEntity("usernameExists", HttpStatus.BAD_REQUEST);
		}
		
		if(userService.findByEmail(userEmail) != null) {
		return new ResponseEntity("emailExists", HttpStatus.BAD_REQUEST);
	}
		User user = new User();
		user.setUsername(username);
		user.setEmail(userEmail);
		
		String password = SecurityUtility.randomPassword();
		String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encryptedPassword);
		Role role = new Role();
		role.setRoleId(1);
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user,null,role));
		userService.createUser(user, userRoles);
		
		SimpleMailMessage email = mailConstructor.constructNewUserEmail(user, password);
		mailSender.send(email);
		return new ResponseEntity("User Added Successfully", HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/forgetPassword", method=RequestMethod.POST)
	public ResponseEntity forgetPasswordPost(
			HttpServletRequest request,
			@RequestBody HashMap<String, String> mapper
			) throws Exception {
		User user = userService.findByEmail(mapper.get("email"));
		
		
		if(user == null) {
		return new ResponseEntity("Email not found", HttpStatus.BAD_REQUEST);
	}
		
		String password = SecurityUtility.randomPassword();
		String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encryptedPassword);
		userService.save(user);
		
		SimpleMailMessage email = mailConstructor.constructNewUserEmail(user, password);
		mailSender.send(email);
		return new ResponseEntity("Email sent!", HttpStatus.OK);
		
	}
}
