package com.shop.service.impl;

import java.util.List;

import com.shop.dto.NameIdCountProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shop.entity.Brand;
import com.shop.repository.BrandRepository;
import com.shop.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{

	private BrandRepository brandRepository;
	
	@Autowired 
	public  BrandServiceImpl(BrandRepository brandRepository) {
		this.brandRepository = brandRepository; 
	}
	
	
	@Override
	public void saveBrand(Brand brand) {
		brandRepository.save(brand); 
		
	}

	@Override
	public Brand findByOne(Long brandId) {
		return brandRepository.findOne(brandId);
	}

	@Override
	public Brand findByName(String name) {
		return brandRepository.findByName(name);
	}

	@Override
	public void deleteBrand(Long brandId) {
		brandRepository.delete(brandId);
		
	}

	@Override
	public Page<Brand> findPage(Pageable pageable) {
		return brandRepository.findAll(pageable);
	}


	@Override
	public List<Brand> findAll() {
		return brandRepository.findAll();
	}

	@Override
	public List<NameIdCountProjection> findProjection() {
		return brandRepository.findProjection();
	}
}
