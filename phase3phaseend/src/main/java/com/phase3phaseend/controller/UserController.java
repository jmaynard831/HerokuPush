package com.phase3phaseend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.phase3phaseend.entity.User;
import com.phase3phaseend.exception.ReadingFromDatabaseException;
import com.phase3phaseend.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userservice;

	@GetMapping("/register")
	public String registerUser() {
		return "register";
	}

	@PostMapping("/register")
	public ModelAndView registerUser(@RequestParam("name") String username, @RequestParam("pass") String password,
			ModelMap model) {
		try {
			User u = User.builder().username(username).password(password).build();
			if (userservice.saveUser(u)) {
				model.addAttribute(u);
				return new ModelAndView("success_register", model);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/login")
	public String loginUser() {
		return "login";
	}

	@PostMapping("/login")
	public RedirectView login(@RequestParam("name") String username, @RequestParam("pass") String password,
			RedirectAttributes ra) throws ReadingFromDatabaseException {

		try {
			User u = User.builder().username(username).password(password).build();
			u = userservice.login(u);
			if (u != null) {
				RedirectView rv = new RedirectView("/creation", true);
				ra.addFlashAttribute("user", u);
				return rv;
			}
		} catch (Throwable e) {
			throw new ReadingFromDatabaseException("Error reading user from Database.", e);
		}
		ra.addFlashAttribute("username", username);
		return new RedirectView("/error", true);
		
	}

}
