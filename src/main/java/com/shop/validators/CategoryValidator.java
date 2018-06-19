package com.shop.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shop.entity.Category;
import com.shop.service.CategoryService;

import static com.shop.constants.ValidationConstants.*;

public class CategoryValidator implements Validator{

    private final CategoryService categoryService;

    public CategoryValidator(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Category.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    	Category category = (Category) target;
        Category categoryFromDbByName = categoryService.findByName(category.getName());

        if (errors.getFieldError("name") == null) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", CANT_BE_EMPTY);
        }

        if (null != categoryFromDbByName) {
            if (category.getId() != null) {
                if (!category.getId().equals(categoryFromDbByName.getId())) {
                    errors.rejectValue("name", "", NAME_ALREADY_EXISTS);
                }
            } else {
                errors.rejectValue("name", "", NAME_ALREADY_EXISTS);
            }
        }

    }
	
}
