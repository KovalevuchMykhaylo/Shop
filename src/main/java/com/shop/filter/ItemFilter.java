package com.shop.filter;

import java.util.ArrayList;
import java.util.List;

public class ItemFilter {
	
	private List<Long> brandIds = new ArrayList<>();

	private List<Long> categoryIds = new ArrayList<>();

	public List<Long> getBrandIds() {
		return brandIds;
	}

	public void setBrandIds(List<Long> brandIds) {
		this.brandIds = brandIds;
	}

	public List<Long> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}
	
	
	

}
