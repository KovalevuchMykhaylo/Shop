package com.shop.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shop.dto.ItemDto;
import com.shop.entity.Item;
import com.shop.filter.ItemFilter;
import com.shop.form.ItemForm;
import com.shop.repository.ItemRepository;
import com.shop.service.BrandService;
import com.shop.service.CategoryService;
import com.shop.service.CountryService;
import com.shop.service.ItemService;
import com.shop.specification.ItemSpecification;

@Service
public class ItemServiceImpl implements ItemService {

	private ItemRepository itemRepository;

	private BrandService brandService;

	private CategoryService categoryService;

	private CountryService countryService;

	@Autowired
	public ItemServiceImpl(ItemRepository itemRepository, BrandService brandService, CategoryService categoryService,
			CountryService countryService) {
		this.itemRepository = itemRepository;
		this.brandService = brandService;
		this.categoryService = categoryService;
		this.countryService = countryService;
	}

	@Override
	public void saveItem(Item item) {
		itemRepository.save(item);

	}

	@Override
	public Item findOne(Long itemId) {
		return itemRepository.findOne(itemId);
	}

	@Override
	public Item findByName(String name) {
		return itemRepository.findByName(name);
	}

	@Override
	public void saveItemFromForm(ItemForm form) throws IOException {
		Item entity = new Item();
		entity.setId(form.getId());
		entity.setName(form.getName());
		if (!form.getFile().isEmpty() && form.getFile() != null) {
			entity.setImg(form.getFile().getBytes());
		}
		entity.setDescription(form.getDescription());
		entity.setPrice(new BigDecimal(form.getPrice().replace(",", ".")));
		entity.setBrand(brandService.findByOne(form.getBrandId()));
		entity.setCountry(countryService.findByOne(form.getCountryId()));
		entity.setCategory(categoryService.findByOne(form.getCategoryId()));
		itemRepository.save(entity);
	}

	@Override
	public ItemForm findForm(Long id) {
		Item entity = itemRepository.findOne(id);
		return new ItemForm(entity);
	}

	@Override
	public void delete(Long id) {
		itemRepository.delete(id);
	}

	@Override
	public Page<ItemDto> findPage(Pageable pageable, ItemFilter filter) {
		return itemRepository.findAll(new ItemSpecification(filter), pageable).map(this::map);
	}
	
	@Override
	public Page<ItemDto> findAdminPage(Pageable pageable) {
		return itemRepository.findAll(pageable).map(this::map);
	}

	@Override
	public Integer findCount(Long id) {
		Integer count = itemRepository.findCount(id);
		if (count == null)
			return 0;
		return count;
	}

	@Override
	public List<Item> findAllByUserId(Long userId) {
		return itemRepository.findAllByUserId(userId);
	}

	@Override
	public Long countAllByBrandId(Long brandId) {
		return itemRepository.countAllByBrandId(brandId);
	}

	private ItemDto map(Item item) {
		return new ItemDto(item);
	}

}
