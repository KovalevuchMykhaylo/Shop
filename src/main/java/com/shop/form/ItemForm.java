package com.shop.form;

import org.springframework.web.multipart.MultipartFile;

import com.shop.entity.Brand;
import com.shop.entity.Category;
import com.shop.entity.Country;
import com.shop.entity.Item;

public class ItemForm {
	
	private Long id;
	
	private String name;
	
	private String price;
	
	private String description;
	
	private MultipartFile file;
	
	private Long brandId;

	private Long categoryId;
	
	private Long countryId;
	
	private Brand brand;
	
	private Category category;
	
	private Country country;
	
	private byte[] img;

	public ItemForm() {
	}

	public ItemForm(Item item) {
		this.id = item.getId();
		this.name = item.getName();
		this.price = item.getPrice().toString();
		this.description = item.getDescription();
		this.img = item.getImg();
		this.brand = item.getBrand();
		this.category = item.getCategory();
		this.country = item.getCountry();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
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

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}
	
}
