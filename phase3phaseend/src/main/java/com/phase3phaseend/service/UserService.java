package com.phase3phaseend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3phaseend.dao.UserDAO;
import com.phase3phaseend.entity.User;
import com.phase3phaseend.exception.SaveToDatabaseException;

@Service
public class UserService {

	public static User LoggedIn = null;

	@Autowired
	private UserDAO userdao;

	public boolean saveUser(User u) throws SaveToDatabaseException {
		try {
			userdao.save(u);
			return true;
		} catch (Throwable e) {
			throw new SaveToDatabaseException("Error saving User to database.", e);
		}

		//return false;
	}

	public User login(User u) {

		List<User> userlist = (List<User>) userdao.findAll();

		User match = userlist.stream()
				.filter(x -> x.getUsername().equals(u.getUsername()) && x.getPassword().equals(u.getPassword()))
				.findFirst().get();

		if (match != null) {
			LoggedIn = u;
			return match;
		} else {
			return null;
		}
	}

}
