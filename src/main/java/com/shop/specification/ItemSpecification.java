package com.shop.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.shop.entity.Item;
import com.shop.filter.ItemFilter;

public class ItemSpecification implements Specification<Item> {

	private final ItemFilter filter;

	private final List<Predicate> predicates = new ArrayList<>();

	public ItemSpecification(ItemFilter filter) {
		this.filter = filter;
	}

	private void filterByCategory(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getCategoryIds().isEmpty()) {
			predicates.add(root.get("category").in(filter.getCategoryIds()));
		}
	}

	private void filterByBrand(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getBrandIds().isEmpty()) {
			predicates.add(root.get("brand").in(filter.getBrandIds()));
		}
	}

	@Override
	public Predicate toPredicate(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		filterByCategory(root, query, cb);
		filterByBrand(root, query, cb);
		if (predicates.isEmpty())
			return null;
		Predicate[] array = new Predicate[predicates.size()];
		array = predicates.toArray(array);
		return cb.and(array);

	}

}
