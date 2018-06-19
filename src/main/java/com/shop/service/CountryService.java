package com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.shop.entity.Country;

public interface CountryService {
	
	void saveCountry(Country country);
	
	Country findByOne(Long countryId);
	
	Country findByName(String name);
	
	void deleteCountry(Long countryId);

	Page<Country> findPage(Pageable pageable);

	List<Country> findAll();

}
