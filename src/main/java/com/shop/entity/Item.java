package com.shop.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item", indexes = @Index(columnList = "name"))
public class Item extends Base{
	
	@Column(name="price", columnDefinition="DECIMAL(5,2)")
	private BigDecimal price;
	
	@Column(name="description", length=400)
	private String description;
	
	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "file_data", columnDefinition = "MEDIUMBLOB")
	private byte[] img;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Brand brand;

	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Country country;
	
	@ManyToMany(mappedBy="items")
	private List<ShopingCart> shopingCarts = new ArrayList<>();

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<ShopingCart> getShopingCarts() {
		return shopingCarts;
	}

	public void setShopingCarts(List<ShopingCart> shopingCarts) {
		this.shopingCarts = shopingCarts;
	}

}
