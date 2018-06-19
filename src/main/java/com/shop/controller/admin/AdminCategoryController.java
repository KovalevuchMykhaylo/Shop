package com.shop.controller.admin;

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

import com.shop.entity.Category;
import com.shop.service.CategoryService;
import com.shop.validators.CategoryValidator;

@Controller
@RequestMapping("/admin/category")
@SessionAttributes("category")
public class AdminCategoryController {

	private final CategoryService categoryService;

	@Autowired
	public AdminCategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@InitBinder("category")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new CategoryValidator(categoryService));
	}

	@ModelAttribute("category")
	public Category getForm() {
		return new Category();
	}

	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable) {
		model.addAttribute("page", categoryService.findPage(pageable));
		return "admin/adminCategory";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") Long id, Model model, @PageableDefault Pageable pageable) {
		model.addAttribute("category", categoryService.findByOne(id));
		return show(model, pageable);
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, Model model, @PageableDefault Pageable pageable) {
		categoryService.deleteCategory(id);
		return "redirect:/admin/category";
	}

	@PostMapping
	public String save(@ModelAttribute("category") @Valid Category category, BindingResult br, Model model,
			@PageableDefault Pageable pageable, SessionStatus status) {
		if (br.hasErrors())
			return show(model, pageable);
		categoryService.saveCategory(category);
		return cancel(status);
	}

	@RequestMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/category";
	}
}
