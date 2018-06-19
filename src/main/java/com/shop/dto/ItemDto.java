package com.shop.dto;

import org.apache.tomcat.util.codec.binary.Base64;

import com.shop.entity.Item;

public class ItemDto {
	
	private Long id;
	
	private String name;
	
	private String price;

	private String img;

	public ItemDto() {
	}	

	public ItemDto(Item item) {
		this.id = item.getId();
		this.name = item.getName();
		this.price = item.getPrice().toString();
		this.img = new String(Base64.encodeBase64(item.getImg()));
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	
}
