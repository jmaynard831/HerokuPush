package com.jwtTestTwo.jwtTestTwo.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwtTestTwo.jwtTestTwo.email.SendEmail;

@Service
public class ApplicationUserService implements UserDetailsService {

	
	private ApplicationUserDAO applicationUserDAO;

	private SendEmail sendEmail;
	
	public ApplicationUserService(ApplicationUserDAO applicationUserDAO, SendEmail sendEmail) {
		super();
		this.applicationUserDAO = applicationUserDAO;
		this.sendEmail = sendEmail;
	}

	public void saveUser(String username, String password) {
		applicationUserDAO.save(new ApplicationUser(username,password));
		sendEmail.SendEmailToUser(username);
	}
	
//	public void saveUserRole(String username, String password,String role) {
//		applicationUserDAO.save(new ApplicationUser(username,password,role));
//	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<ApplicationUser> user = applicationUserDAO.findByUsername(username);
		user.orElseThrow(()-> new UsernameNotFoundException(username+ " is not found."));
		return user.map(MyUserDetails::new).get();
	}

}
