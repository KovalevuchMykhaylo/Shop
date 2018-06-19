package com.shop.controller;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.shop.entity.Item;
import com.shop.entity.User;
import com.shop.filter.ItemFilter;
import com.shop.service.BrandService;
import com.shop.service.CategoryService;
import com.shop.service.ItemService;
import com.shop.service.UserService;

@Controller
public class IndexController {

	private ItemService itemService;
	
	private UserService userService;
	
	private CategoryService categoryService;
	
	private BrandService brandService;
	
	@Autowired
	public IndexController(ItemService itemService, UserService userService, CategoryService categoryService,
			BrandService brandService) {
		this.itemService = itemService;
		this.userService = userService;
		this.categoryService = categoryService;
		this.brandService = brandService;
	}
	
	@ModelAttribute("filter")
	public ItemFilter getFilter(){
		return new ItemFilter();
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/")
	public String index(Model model, @CookieValue(defaultValue="0", name="userId") Long id, HttpServletResponse response, @PageableDefault Pageable pageable, Principal principal, @ModelAttribute("filter")ItemFilter filter) {
		if(principal!=null) {
			User user = userService.findUserByEmail(principal.getName());
			id = user.getId();
			response.addCookie(new Cookie("userId", String.valueOf(id)));
		}
		model.addAttribute("category", categoryService.findAll());
		model.addAttribute("brand", brandService.findProjection());
		model.addAttribute("page", itemService.findPage(pageable, filter));
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/shopping")
	public String shopping(Model model, @CookieValue(defaultValue = "0", name = "userId") Long userId) {
		BigDecimal totalPrice = new BigDecimal(0); 
		List<Item> items = itemService.findAllByUserId(userId);
		for (Item item : items) { 
			totalPrice = totalPrice.add(item.getPrice()); 
		}
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("items", items);
		return "user/shopping";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/buy/{itemId}")
	public String buy(@CookieValue(defaultValue="0", name="userId") Long userId, @PathVariable Long itemId){
		userService.addToShoppingCart(userId, itemId);
		return "redirect:/";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/del/{itemId}")
	public String remove(@CookieValue(defaultValue = "0", name = "userId") Long userId, @PathVariable Long itemId) {
		userService.removeToShoppingCart(userId, itemId);
		return "redirect:/shopping";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/iNeedIt")
	public String iNeedIt(@CookieValue(defaultValue = "0", name = "userId") Long userId, Principal principal) {
		userService.sendMail("Shop", principal.getName());
		userService.removeAllToShoppingCart(userId);
		return "user/success";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}	
	
	@GetMapping("/cancel")
	public String cansel(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/";
	}	
	
	
}
