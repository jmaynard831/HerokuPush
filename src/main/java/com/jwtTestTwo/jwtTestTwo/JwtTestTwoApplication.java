package com.jwtTestTwo.jwtTestTwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jwtTestTwo.jwtTestTwo.auth.ApplicationUserDAO;
import com.jwtTestTwo.jwtTestTwo.todo.TodoDAO;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses= {ApplicationUserDAO.class,TodoDAO.class})
public class JwtTestTwoApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(JwtTestTwoApplication.class, args);
	}

}
