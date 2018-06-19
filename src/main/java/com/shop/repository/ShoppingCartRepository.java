package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.ShopingCart;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShopingCart, Long>{

}
