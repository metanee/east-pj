package com.east;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.east.cpn.SecurityUtility;
import com.east.model.Company;
import com.east.model.Role;
import com.east.model.User;
import com.east.model.UserRole;
import com.east.service.CompanyService;
import com.east.service.UserService;

@SpringBootApplication
public class EastPjApplication implements CommandLineRunner{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyService companyService;

	public static void main(String[] args) {
		SpringApplication.run(EastPjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setFirstName("Jhon");
		user1.setLastName("Adams");
		user1.setUsername("j");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("JAdams@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1,null, role1));
		
		userService.createUser(user1, userRoles);
		userRoles.clear();
		
		User user2 = new User();
		user2.setFirstName("Admin");
		user2.setLastName("Admin");
		user2.setUsername("Admin");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user2.setEmail("Admin@gmail.com");
		
		Role role2 = new Role();
		role2.setRoleId(0);
		role2.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user2,null, role2));
		
		userService.createUser(user2, userRoles);
		userRoles.clear();		
		
		Company company1 = new Company();
		company1.setFirstName("Owner");
		company1.setLastName("Owner");
		company1.setUsername("Owner");
		company1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		company1.setEmail("Owner@gmail.com");
		
		Role role3 = new Role();
		role3.setRoleId(3);
		role3.setName("ROLE_Owner");
		userRoles.add(new UserRole(null,company1, role3));
		companyService.createCompany(company1, userRoles);
		userRoles.clear();
		
		Company company2 = new Company();
		company2.setFirstName("sadawd");
		company2.setLastName("wdwad");
		company2.setUsername("aaa");
		company2.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		company2.setEmail("aaaa@gmail.com");
		
		Role role4 = new Role();
		role4.setRoleId(3);
		role4.setName("ROLE_Owner");
		userRoles.add(new UserRole(null,company2, role4));
		companyService.createCompany(company2, userRoles);

		
	}
}
