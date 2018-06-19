package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shop.entity.Country;
import com.shop.repository.CountryRepository;
import com.shop.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{

	private CountryRepository countryRepository;
	
	@Autowired
	public CountryServiceImpl(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	@Override
	public void saveCountry(Country country) {
		countryRepository.save(country);
		
	}

	@Override
	public Country findByOne(Long countryId) {
		return countryRepository.findOne(countryId);
	}

	@Override
	public Country findByName(String name) {
		return countryRepository.findByName(name);
	}

	@Override
	public void deleteCountry(Long countryId) {
		countryRepository.delete(countryId);
		
	}

	@Override
	public Page<Country> findPage(Pageable pageable) {
		return countryRepository.findAll(pageable);
	}

	@Override
	public List<Country> findAll() {
		return countryRepository.findAll();
	}

}
