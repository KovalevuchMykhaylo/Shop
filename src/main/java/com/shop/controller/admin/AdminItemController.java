package com.shop.controller.admin;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.shop.form.ItemForm;
import com.shop.service.BrandService;
import com.shop.service.CategoryService;
import com.shop.service.CountryService;
import com.shop.service.ItemService;
import com.shop.validators.ItemValidator;

@Controller
@RequestMapping("/admin/item")
@SessionAttributes("item")
public class AdminItemController {
	
	private ItemService itemService;
	
	private BrandService brandService;
	
	private CategoryService categoryService;
	
	private CountryService countryService;
	
	@Autowired
	public AdminItemController(ItemService itemService, BrandService brandService, CategoryService categoryService,
			CountryService countryService) {
		this.itemService = itemService;
		this.brandService = brandService;
		this.categoryService = categoryService;
		this.countryService = countryService;
	}

	@InitBinder("item")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new ItemValidator(itemService));
	}
	
	@ModelAttribute("item")
	public ItemForm getForm() {
		return new ItemForm();
	}	
	
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable) {
		model.addAttribute("page", itemService.findAdminPage(pageable));
		model.addAttribute("brands", brandService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("countries", countryService.findAll());
		return"admin/adminItem";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id")Long id, Model model, @PageableDefault Pageable pageable) {
		model.addAttribute("item", itemService.findForm(id));
		return show(model,pageable);
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id, Model model, @PageableDefault Pageable pageable) {
		itemService.delete(id);
		return"redirect:/admin/item";
	}
	
	@PostMapping
	public String save(@ModelAttribute("item") @Valid ItemForm itemForm, BindingResult br, Model model, @PageableDefault Pageable pageable, SessionStatus status) throws IOException {
		if(br.hasErrors()) return show(model, pageable);
		itemService.saveItemFromForm(itemForm);
		return cancel(status);
	}
	
	@RequestMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return"redirect:/admin/item";
	}

}
