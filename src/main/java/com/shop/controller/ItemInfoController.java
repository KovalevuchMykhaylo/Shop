package com.shop.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.entity.Item;
import com.shop.service.ItemService;

@Controller
@RequestMapping("/iteminfo/{id}")
public class ItemInfoController {
	
	private ItemService itemService;

	@Autowired
	public ItemInfoController(ItemService itemService) {
		this.itemService = itemService;
	}

	@RequestMapping
	public String show(@PathVariable("id") Long id, Model model) {
		Item item = itemService.findOne(id);
		model.addAttribute("item", item);
		String img = "";
		if(item.getImg()!=null) {
			img = new String(Base64.encodeBase64(item.getImg()));
		}
		model.addAttribute("img", img);
		return "itemInfo";
	}
}
