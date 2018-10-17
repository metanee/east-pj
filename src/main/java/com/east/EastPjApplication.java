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
		user1.setIdcard("1100701904680");
		user1.setGender("ชาย");
		user1.setPhone("0800800080");
		user1.setRole("1");
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
		user2.setIdcard("11007019046804546546");
		user2.setRole("3");
		Role role2 = new Role();
		role2.setRoleId(3);
		role2.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user2,null, role2));
		
		userService.createUser(user2, userRoles);
		userRoles.clear();		
		
		User user5 = new User();
		user5.setFirstName("Jhon");
		user5.setLastName("Adams");
		user5.setUsername("a");
		user5.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user5.setEmail("JAdamdsfsdfs@gmail.com");
		user5.setIdcard("5500705904680");
		user5.setGender("ชาย");
		user5.setPhone("0800800080");
		user5.setRole("1");
		Role role5 = new Role();
		role5.setRoleId(5);
		role5.setName("ROLE_USER");
		userRoles.add(new UserRole(user5,null, role5));
		
		userService.createUser(user5, userRoles);
		userRoles.clear();
		
		
		User user6 = new User();
		user6.setFirstName("Jhon");
		user6.setLastName("Adams");
		user6.setUsername("b");
		user6.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user6.setEmail("sdasdsadw@gmail.com");
		user6.setIdcard("6600706904680");
		user6.setGender("ชาย");
		user6.setPhone("0800800080");
		user6.setRole("1");

		
		Role role6 = new Role();
		role6.setRoleId(6);
		role6.setName("ROLE_USER");
		userRoles.add(new UserRole(user6,null, role6));
		
		userService.createUser(user6, userRoles);
		userRoles.clear();
		
		User user7 = new User();
		user7.setFirstName("Jhon");
		user7.setLastName("Adams");
		user7.setUsername("c");
		user7.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user7.setEmail("JAdasddsdsdms@gmail.com");
		user7.setIdcard("7700707904780");
		user7.setGender("ชาย");
		user7.setPhone("0800800080");
		user7.setRole("1");

		
		Role role7 = new Role();
		role7.setRoleId(7);
		role7.setName("ROLE_USER");
		userRoles.add(new UserRole(user7,null, role7));
		
		userService.createUser(user7, userRoles);
		userRoles.clear();
		
		User user8 = new User();
		user8.setFirstName("Jhon");
		user8.setLastName("Adams");
		user8.setUsername("d");
		user8.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user8.setEmail("JAdasdsadwdwdms@gmail.com");
		user8.setIdcard("8800708904680");
		user8.setGender("ชาย");
		user8.setPhone("0800800080");
		user8.setRole("1");

		
		Role role8 = new Role();
		role8.setRoleId(8);
		role8.setName("ROLE_USER");
		userRoles.add(new UserRole(user8,null, role8));
		
		userService.createUser(user8, userRoles);
		userRoles.clear();
		
		User user9 = new User();
		user9.setFirstName("Jhon");
		user9.setLastName("Adams");
		user9.setUsername("e");
		user9.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user9.setEmail("JAdasdsdwdms@gmail.com");
		user9.setIdcard("9900709904680");
		user9.setGender("ชาย");
		user9.setPhone("0800800080");
		user9.setRole("1");

		
		Role role9 = new Role();
		role9.setRoleId(9);
		role9.setName("ROLE_USER");
		userRoles.add(new UserRole(user9,null, role9));
		
		userService.createUser(user9, userRoles);
		userRoles.clear();
		
		User user10 = new User();
		user10.setFirstName("Jhon");
		user10.setLastName("Adams");
		user10.setUsername("f");
		user10.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user10.setEmail("JAdsdwdwdams@gmail.com");
		user10.setIdcard("1010007010904680");
		user10.setGender("ชาย");
		user10.setPhone("0800800080");
		user10.setRole("1");

		
		Role role10 = new Role();
		role10.setRoleId(10);
		role10.setName("ROLE_USER");
		userRoles.add(new UserRole(user10,null, role10));
		
		userService.createUser(user10, userRoles);
		userRoles.clear();
		
		User user11 = new User();
		user11.setFirstName("Jhon");
		user11.setLastName("Adams");
		user11.setUsername("g");
		user11.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user11.setEmail("JAdasdwdwdms@gmail.com");
		user11.setIdcard("1111007011904680");
		user11.setGender("ชาย");
		user11.setPhone("0800800080");
		user11.setRole("1");

		
		Role role11 = new Role();
		role11.setRoleId(11);
		role11.setName("ROLE_USER");
		userRoles.add(new UserRole(user11,null, role11));
		
		userService.createUser(user11, userRoles);
		userRoles.clear();
		
		User user12 = new User();
		user12.setFirstName("Jhon");
		user12.setLastName("Adams");
		user12.setUsername("h");
		user12.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user12.setEmail("JAdasdwdwdaaams@gmail.com");
		user12.setIdcard("1212007012904680");
		user12.setGender("ชาย");
		user12.setPhone("0800800080");
		user12.setRole("1");

		
		Role role12 = new Role();
		role12.setRoleId(12);
		role12.setName("ROLE_USER");
		userRoles.add(new UserRole(user12,null, role12));
		
		userService.createUser(user12, userRoles);
		userRoles.clear();
		
		User user13 = new User();
		user13.setFirstName("Jhon");
		user13.setLastName("Adams");
		user13.setUsername("i");
		user13.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user13.setEmail("JAdasdwdwdddavdms@gmail.com");
		user13.setIdcard("1313007013904680");
		user13.setGender("ชาย");
		user13.setPhone("0800800080");
		user13.setRole("1");

		
		Role role13 = new Role();
		role13.setRoleId(13);
		role13.setName("ROLE_USER");
		userRoles.add(new UserRole(user13,null, role13));
		
		userService.createUser(user13, userRoles);
		userRoles.clear();
		
		User user14 = new User();
		user14.setFirstName("Jhon");
		user14.setLastName("Adams");
		user14.setUsername("m");
		user14.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user14.setEmail("dwdwd@gmail.com");
		user14.setIdcard("1414007014904680");
		user14.setGender("ชาย");
		user14.setPhone("0800800080");
		user14.setRole("1");

		
		Role role14 = new Role();
		role14.setRoleId(14);
		role14.setName("ROLE_USER");
		userRoles.add(new UserRole(user14,null, role14));
		
		userService.createUser(user14, userRoles);
		userRoles.clear();
		
		User user15 = new User();
		user15.setFirstName("Jhon");
		user15.setLastName("Adams");
		user15.setUsername("k");
		user15.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user15.setEmail("cxsads@gmail.com");
		user15.setIdcard("1515007015904680");
		user15.setGender("ชาย");
		user15.setPhone("0800800080");
		user15.setRole("1");

		
		Role role15 = new Role();
		role15.setRoleId(15);
		role15.setName("ROLE_USER");
		userRoles.add(new UserRole(user15,null, role15));
		
		userService.createUser(user15, userRoles);
		userRoles.clear();
		
		User user16 = new User();
		user16.setFirstName("Jhon");
		user16.setLastName("Adams");
		user16.setUsername("l");
		user16.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user16.setEmail("JAdasdwdwdmsdwdws@gmail.com");
		user16.setIdcard("1616007016904680");
		user16.setGender("ชาย");
		user16.setPhone("0800800080");
		user16.setRole("1");

		
		Role role16 = new Role();
		role16.setRoleId(16);
		role16.setName("ROLE_USER");
		userRoles.add(new UserRole(user16,null, role16));
		
		userService.createUser(user16, userRoles);
		userRoles.clear();
		
		User user17 = new User();
		user17.setFirstName("Metanee");
		user17.setLastName("Saeheng");
		user17.setUsername("pioer01");
		user17.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user17.setEmail("cxsads@gmail.com");
		user17.setIdcard("1717007017904680");
		user17.setGender("ชาย");
		user17.setPhone("0800800080");
		user17.setRole("1");

		
		Role role17 = new Role();
		role17.setRoleId(17);
		role17.setName("ROLE_USER");
		userRoles.add(new UserRole(user17,null, role17));
		
		userService.createUser(user17, userRoles);
		userRoles.clear();
		
		Company company1 = new Company();
		company1.setFirstName("Owner");
		company1.setUsername("Owner");
		company1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		company1.setEmail("Owner@gmail.com");
		company1.setRole("2");
		Role role3 = new Role();
		role3.setRoleId(2);
		role3.setName("ROLE_OWNER");
		userRoles.add(new UserRole(null,company1, role3));
		companyService.createCompany(company1, userRoles);
		userRoles.clear();
		
		Company company2 = new Company();
		company2.setFirstName("sadawd");
		company2.setUsername("aaa");
		company2.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		company2.setEmail("aaaa@gmail.com");
		company2.setRole("2");
		Role role4 = new Role();
		role4.setRoleId(3);
		role4.setName("ROLE_OWNER");
		userRoles.add(new UserRole(null,company2, role4));
		companyService.createCompany(company2, userRoles);

		
	}
}
