package com.demo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.bean.Profile;
import com.demo.bean.User;
import com.demo.service.UserService;

@Controller
@RequestMapping("app")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@GetMapping("create-user")
	public ModelAndView createUserView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user-creation");
		mav.addObject("user", new User());
		mav.addObject("allProfiles", userService.getAllProfiles());
		return mav;
	}

	@PostMapping("create-user")
	public ModelAndView createUser(@Valid User user, Errors result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			logger.info("Validation errors while submitting form.");
			mav.setViewName("user-creation");
			mav.addObject("user", user);
			mav.addObject("allProfiles", userService.getAllProfiles());
			return mav;
		}
		userService.addUser(user);
		mav.addObject("allUsers", userService.getAllUserArticles());
		mav.setViewName("user-info");
		logger.info("Form submitted successfully.");
		return mav;
	}
	
	@RequestMapping(value="create-profile", method=RequestMethod.GET)
	public String createProfileView(Model model) {
		Profile profile = new Profile();
		profile.setDescription("Por Defecto");
		model.addAttribute("profile", profile);
		return "profile-creation";
	}
	
	@RequestMapping(value="create-profile", method=RequestMethod.POST)
	public String createProfile(@Valid Profile profile, BindingResult result, Model model) {
		if (result.hasErrors()) {
			logger.info("Validation errors while submitting form.");
			return "profile-creation";
		}
		userService.addProfile(profile);
		model.addAttribute("user", new User());
		model.addAttribute("allProfiles", userService.getAllProfiles() );
		logger.info("Form submitted successfully.");
		return "redirect:/app/create-user";
	}
	
	@RequestMapping(value="delete-user/{userId}", method=RequestMethod.GET)
	public String deleteUser(@PathVariable String userId) {
		System.out.println("userId: " + userId);
		userService.deleteUser(userId);
		return "redirect:/app/create-user";
	}
}
