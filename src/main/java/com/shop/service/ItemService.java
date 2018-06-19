package com.shop.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.shop.dto.ItemDto;
import com.shop.entity.Item;
import com.shop.filter.ItemFilter;
import com.shop.form.ItemForm;

public interface ItemService {
	
	void saveItem(Item item);
	
	Item findOne(Long itemId);
	
	Item findByName(String name);
	
	void saveItemFromForm(ItemForm itemForm) throws IOException;
	
	ItemForm findForm(Long id);

	void delete(Long id);

	Page<ItemDto> findPage(Pageable pageable, ItemFilter filter);
	
	Page<ItemDto> findAdminPage(Pageable pageable);

	Integer findCount(Long userId);

	List<Item> findAllByUserId(Long userId);
}
