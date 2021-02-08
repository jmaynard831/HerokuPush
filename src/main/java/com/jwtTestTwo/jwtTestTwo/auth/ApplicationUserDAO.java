package com.jwtTestTwo.jwtTestTwo.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserDAO extends JpaRepository<ApplicationUser, Integer>{	
	 Optional<ApplicationUser> findByUsername(String username);
}
