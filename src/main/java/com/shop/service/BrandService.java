package com.shop.service;

import java.util.List;

import com.shop.dto.NameIdCountProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.shop.entity.Brand;

public interface BrandService {

	void saveBrand(Brand brand);
	
	Brand findByOne(Long brandId);
	
	Brand findByName(String name);
	
	void deleteBrand(Long brandId);

	Page<Brand> findPage(Pageable pageable);

	List<Brand> findAll();

	List<NameIdCountProjection> findProjection();
}
