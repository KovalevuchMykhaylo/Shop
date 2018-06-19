package com.shop.controller.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.shop.dto.Quantity;
import com.shop.service.ItemService;

@ControllerAdvice
public class ShoppingController {
	
	private final ItemService itemsService;

	@Autowired
	public ShoppingController(ItemService itemsService) {
		this.itemsService = itemsService;
	}

	@ModelAttribute("quantity")
	public Quantity getQuantity(@CookieValue(defaultValue="0", name="userId") Long userId){
		int count = itemsService.findCount(userId);
		return new Quantity(count);
	}
}
