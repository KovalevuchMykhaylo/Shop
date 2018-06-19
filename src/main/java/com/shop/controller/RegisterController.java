package com.shop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.shop.entity.User;
import com.shop.service.UserService;
import com.shop.validators.UserValidator;


@Controller
@RequestMapping("/register")
public class RegisterController {
	
	private UserService userService;
	
	@Autowired
	public RegisterController(UserService userService) {
		this.userService = userService;
	}

	@InitBinder("registerModel")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new UserValidator(userService));
	}
	
	@ModelAttribute("registerModel")
	public User getForm() {
		return new User();
	}
	
	@GetMapping
	public String register(Model model) {
		return "register";
	}
	
	@PostMapping
	public String save(@ModelAttribute("registerModel") @Valid User user, BindingResult br, Model model, SessionStatus status) {
		if(br.hasErrors()) {
			return register(model);
		}
		userService.saveAndEncode(user);
		status.setComplete();
		return "redirect:/login";
	}
	
	@RequestMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/register";
	}

}
