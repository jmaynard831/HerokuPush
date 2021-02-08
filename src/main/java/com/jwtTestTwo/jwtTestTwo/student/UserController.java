package com.jwtTestTwo.jwtTestTwo.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwtTestTwo.jwtTestTwo.auth.ApplicationUser;
import com.jwtTestTwo.jwtTestTwo.auth.ApplicationUserService;
import com.jwtTestTwo.jwtTestTwo.todo.TodoController;

@RestController
public class UserController {

	Logger logging = LoggerFactory.getLogger(TodoController.class);
	
	@Autowired
	ApplicationUserService aus;

	@PostMapping("/register")
	public void registerNewUser(@RequestBody ApplicationUser au) {
		logging.info("New User Registered: "+ au.toString());
		System.out.println("Registering new user " + au.getUsername());
		// System.out.println(au.getUsername() + " " + au.getPassword() + " " +
		// au.getRole());
//		if (au.getRole() != null) {
//			aus.saveUserRole(au.getUsername(), au.getPassword(), au.getRole());
//		} else {
			aus.saveUser(au.getUsername(), au.getPassword());
	//	}
	}
}
