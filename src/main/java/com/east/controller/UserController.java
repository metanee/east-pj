package com.east.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.east.config.SecurityConfig;
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
		String idcard = mapper.get("idcard");
		
		if(userService.findByUsername(username) != null) {
			return new ResponseEntity("usernameExists", HttpStatus.BAD_REQUEST);
		}
		
		if(userService.findByEmail(userEmail) != null) {
		return new ResponseEntity("emailExists", HttpStatus.BAD_REQUEST);
	}
		if(userService.findByIdcard(idcard) != null) {
			return new ResponseEntity("idcardExists", HttpStatus.BAD_REQUEST);
		}
		User user = new User();
		user.setUsername(username);
		user.setEmail(userEmail);
		user.setIdcard(idcard);
		user.setRole("1");
		
		String password = SecurityUtility.randomPassword();
		String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encryptedPassword);
		Role role = new Role();
		role.setRoleId(1);
		role.setName("ROLE_USER");
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
	
	@RequestMapping(value="/passwordUserInfo", method=RequestMethod.POST)
	public ResponseEntity passwordinfo(
				@RequestBody HashMap<String, Object> mapper
			) throws Exception{
		int id = (Integer) mapper.get("id");
		String newPassword = (String) mapper.get("new_pass");
		String currentPassword = (String) mapper.get("old_pass");
		String email = (String) mapper.get("email");
		User currentUser = userService.findById(Long.valueOf(id));
		SecurityConfig securityConfig = new SecurityConfig();
		
		
		BCryptPasswordEncoder passwordEncoder = SecurityUtility.passwordEncoder();
		String dbPassword = currentUser.getPassword();
		
		if(null != currentPassword)
		if(passwordEncoder.matches(currentPassword, dbPassword)) {
			if(newPassword != null && !newPassword.isEmpty() && !newPassword.equals("")) {
				currentUser.setPassword(passwordEncoder.encode(newPassword));
			}
			currentUser.setEmail(email);
		} else {
			return new ResponseEntity("Incorrect current password!", HttpStatus.BAD_REQUEST);
		}
		userService.save(currentUser);
		return new ResponseEntity("Update Success", HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateUserInfo", method=RequestMethod.POST)
	public ResponseEntity profileInfo(
				@RequestBody HashMap<String, Object> mapper
			) throws Exception{
		
		int id = (Integer) mapper.get("id");
		String email = (String) mapper.get("email");
		//String username = (String) mapper.get("username");
		
		String firstName = (String) mapper.get("firstName");
		String lastName = (String) mapper.get("lastName");
		String gender = (String) mapper.get("gender");
		String birthDay = (String) mapper.get("birthDay");
		String nationality = (String) mapper.get("nationality");
		String address = (String) mapper.get("address");
		String religion = (String) mapper.get("religion");
		String education = (String) mapper.get("education");
		String institute = (String) mapper.get("institute");
		String faculty = (String) mapper.get("faculty");
		String branch = (String) mapper.get("branch");
		String startyearEducation = (String) mapper.get("startyearEducation");
		String endyearEducation = (String) mapper.get("endyearEducation");
		String gpaEducation = (String) mapper.get("gpaEducation");
		String startmonthJobexp = (String) mapper.get("startmonthJobexp");
		String startyearhJobexp = (String) mapper.get("startyearhJobexp");
		String endyearJobexp = (String) mapper.get("endyearJobexp");
		String endmonthJobexp = (String) mapper.get("endmonthJobexp");
		String companyNameJobexp = (String) mapper.get("companyNameJobexp");
		String careerJobexp = (String) mapper.get("careerJobexp");
		String salaryJobexp = (String) mapper.get("salaryJobexp");
		String descriptionJobexp = (String) mapper.get("descriptionJobexp");
		String phone = (String) mapper.get("phone");
		
		
		User currentUser = userService.findById(Long.valueOf(id));
		
		if(currentUser == null) {
			throw new Exception ("User not found");
		}
		
		/*if(userService.findByEmail(email) != null) {
			if(userService.findByEmail(email).getId() != currentUser.getId()) {
				return new ResponseEntity("Email not found!", HttpStatus.BAD_REQUEST);
			}
		}*/
		
		/*if(userService.findByUsername(username) != null) {
			if(userService.findByUsername(username).getId() != currentUser.getId()) {
				return new ResponseEntity("Username not found!", HttpStatus.BAD_REQUEST);
			}
		}*/
		
		currentUser.setFirstName(firstName);
		currentUser.setLastName(lastName);
		currentUser.setGender(gender);
		currentUser.setBirthDay(birthDay);
		currentUser.setNationality(nationality);
		currentUser.setAddress(address);
		currentUser.setReligion(religion);
		currentUser.setEducation(education);
		currentUser.setInstitute(institute);
		currentUser.setFaculty(faculty);
		currentUser.setBranch(branch);
		currentUser.setStartyearEducation(startyearEducation);
		currentUser.setEndyearEducation(endyearEducation);
		currentUser.setGpaEducation(gpaEducation);
		currentUser.setStartmonthJobexp(startmonthJobexp);
		currentUser.setEndmonthJobexp(endmonthJobexp);
		currentUser.setStartyearhJobexp(startyearhJobexp);
		currentUser.setEndyearJobexp(endyearJobexp);
		currentUser.setCompanyNameJobexp(companyNameJobexp);
		currentUser.setCareerJobexp(careerJobexp);
		currentUser.setSalaryJobexp(salaryJobexp);
		currentUser.setDescriptionJobexp(descriptionJobexp);
		currentUser.setPhone(phone);
		
		//currentUser.setUsername(username);
		Role role = new Role();
		role.setRoleId(1);
		role.setName("ROLE_USER");
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(currentUser,null,role));
		
		userService.save(currentUser);
		
		return new ResponseEntity("Update Success", HttpStatus.OK);
	}
	
	@RequestMapping(value="/add/image", method=RequestMethod.POST)
	public ResponseEntity updateImagePost(
			@RequestParam("id") Long id,
			HttpServletResponse response, HttpServletRequest request
			){
		try {
			User user = userService.findOne(id);
			String idcard = user.getIdcard();
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> it = multipartRequest.getFileNames();
			MultipartFile multipartFile = multipartRequest.getFile(it.next());
			String fileName = id+idcard+".png";
			
			//Files.delete(Paths.get("src/main/resources/static/image/user/"+fileName));
			
			byte[] bytes = multipartFile.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/user/"+fileName)));
			stream.write(bytes);
			stream.close();
			user.setPartImage("http://localhost:8080/image/user/"+fileName);
			userService.save(user);
			return new ResponseEntity("Upload Success!", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Upload failed!", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value="/getCurrentUser")
	public User getCurrentUser(Principal principal) {
		String username = principal.getName();
		User user = new User();
		if (null != username) {
			user = userService.findByUsername(username);
		}
		System.out.println(user);
		System.out.println(username);

		return user;
	}
	
	@RequestMapping(value="/userList")
	public List<User> getBookList() {
	 List<User> userList = userService.findAll();

		System.out.println("55555555555555555555"+userList);
		return userList;
	}
	
	@RequestMapping("/{id}")
	public User getUser(@PathVariable("id") Long id){
		User user = userService.findOne(id);
		System.out.println("666666666666666666666666666666666666666666666666666666666666");
		return user;
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public ResponseEntity remove(
			@RequestBody String id
			) throws IOException {
		userService.removeOne(Long.parseLong(id));
		//String fileName = id+".png";
		
		//Files.delete(Paths.get("src/main/resources/static/image/book/"+fileName));
		
		return new ResponseEntity("Remove Success!", HttpStatus.OK);
	}
	
	/*@RequestMapping(value="/searchUser", method=RequestMethod.POST)
	public List<User> searchBook (@RequestBody HashMap<String, Object> mapper) {
		
		String idcard = (String) mapper.get("searchText");
		if (idcard != null) {
			System.out.println(idcard);
			List<User> userSearch = userService.blurrySearch(idcard);
			return userSearch;
		}else {
			return userService.findAll();
		}
		
	}*/
}
