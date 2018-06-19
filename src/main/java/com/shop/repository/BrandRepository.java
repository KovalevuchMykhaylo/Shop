package com.shop.repository;

import com.shop.dto.NameIdCountProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.entity.Brand;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{
	
	Brand findByName(String name);

	@Query("select b.id as id, b.name as name from Brand b")
	List<NameIdCountProjection> findProjection();


}
