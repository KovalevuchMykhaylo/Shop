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

import com.shop.entity.Country;
import com.shop.service.CountryService;
import com.shop.validators.CountryValidator;

@Controller
@RequestMapping("/admin/country")
@SessionAttributes("country")
public class AdminCountryController {
	
	private final CountryService countryService;

	@Autowired
	public AdminCountryController(CountryService countryService) {
		this.countryService = countryService;
	}

	@InitBinder("country")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new CountryValidator(countryService));
	}
	
	@ModelAttribute("country")
	public Country getForm() {
		return new Country();
	}	
	
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable) {
		model.addAttribute("page", countryService.findPage(pageable));
		return"admin/adminCountry";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id")Long id, Model model, @PageableDefault Pageable pageable) {
		model.addAttribute("country", countryService.findByOne(id));
		return show(model,pageable);
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id, Model model, @PageableDefault Pageable pageable) {
		countryService.deleteCountry(id);
		return"redirect:/admin/country";
	}
	
	@PostMapping
	public String save(@ModelAttribute("country") @Valid Country country, BindingResult br, Model model, @PageableDefault Pageable pageable, SessionStatus status) {
		if(br.hasErrors()) return show(model, pageable);
		countryService.saveCountry(country);
		return cancel(status);
	}
	
	@RequestMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return"redirect:/admin/country";
	}
}
