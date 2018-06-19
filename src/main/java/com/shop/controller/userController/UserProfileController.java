package com.shop.controller.userController;

import java.io.IOException;
import java.security.Principal;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.shop.entity.User;
import com.shop.form.UserUpdateForm;
import com.shop.service.UserService;

@Controller
@RequestMapping("/user/profile")
public class UserProfileController {

	private UserService userService;

	@ModelAttribute("updatedUser")
	public UserUpdateForm getForm() {
		return new UserUpdateForm();
	}

	@Autowired
	public UserProfileController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping
	public String show(Model model, Principal principal) {
		User user = userService.findUserByEmail(principal.getName());
		model.addAttribute("user", user);
		if(user.getFileData()!=null) {
			String img = new String(Base64.encodeBase64(user.getFileData()));
			System.out.println(img);
			model.addAttribute("img", img);
		}
		return "user/profile";
	}

	@RequestMapping("/edit")
	public String edit(Model model, Principal principal) {
		User user = userService.findUserByEmail(principal.getName());
		model.addAttribute("user", user);
		return "user/profileEdit";
	}

	@PostMapping("/edit")
	public String update(@ModelAttribute("updatedUser") UserUpdateForm userUpdateForm, Principal principal, SessionStatus status)
			throws IOException {
		User userFromdb = userService.findUserByEmail(principal.getName());
		userFromdb.setFirstName(userUpdateForm.getFirstName());
		userFromdb.setSecondName(userUpdateForm.getSecondName());
		userFromdb.setPhoneNumber(userUpdateForm.getPhoneNumber());
		if (!userUpdateForm.getFile().isEmpty() && userUpdateForm.getFile() != null) {
			userFromdb.setFileData(userUpdateForm.getFile().getBytes());
			System.out.println("New img");
		}
		userService.saveService(userFromdb);
		status.setComplete();
		return "redirect:/user/profile";
	}

}
