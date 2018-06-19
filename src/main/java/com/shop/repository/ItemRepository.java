package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item>{

	Item findByName(String name); 
	
	Item findByCountryId(Long countryId);
	
	Item findByCategoryId(Long categoryId);
	
	Item findByBrandId(Long brandId);
	
	@Query("SELECT sc.count FROM User u JOIN u.shopingCart sc WHERE u.id=?1")
	Integer findCount(Long id);

	@Query("SELECT i FROM Item i JOIN i.shopingCarts sc JOIN sc.users u WHERE u.id=?1")
	List<Item> findAllByUserId(Long userId);
	
}
