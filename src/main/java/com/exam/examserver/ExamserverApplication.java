package com.exam.examserver;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.exam.examserver.Service.UserService;
import com.exam.examserver.entity.Role;
import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Set;
import java.util.HashSet;


@SpringBootApplication
public class ExamserverApplication  {
//	@Autowired
//private UserService userService;

	public static void main(String[] args) {

			SpringApplication.run(ExamserverApplication.class, args);

	}
//	@Override
//	public void run(String... args) throws Exception {
		// Create a new user
//		User user = new User();
//		user.setFirstname("Mahipat");
//		user.setLastname("Singh");
//		user.setUsername("Mahi12");
//		user.setPassword("abc@123");
//		user.setEmail("xyz@gmail.com");
//		user.setProfile("default.png");
//		user.setId(88L);
//
//		// Create a new role
//		Role role2 = new Role();
//		role2.setRoleName("Admin");
//		role2.setRoleId(86L);
//
//		// Create a new UserRole
//
//
//		// Add the UserRole to the User's set of userRoles
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//
//		userRole.setRole(role2);
//		userRole.setUser(user);
//		userRoleSet.add(userRole);
//
//// Save the User and UserRole
//		User savedUser = this.userService.createUser(user, userRoleSet);
//		if (savedUser != null) {
//			System.out.println("User created successfully: " + savedUser.getUsername());
//		} else {
//			System.out.println("User creation failed.");
//		}
//	}

}
