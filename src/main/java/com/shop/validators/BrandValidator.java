package com.shop.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shop.entity.Brand;
import com.shop.service.BrandService;

import static com.shop.constants.ValidationConstants.*;

public class BrandValidator implements Validator{

    private final BrandService brandService;

    public BrandValidator(BrandService brandService) {
        this.brandService = brandService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Brand.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    	Brand brand = (Brand) target;
        Brand brandFromDbByName = brandService.findByName(brand.getName());

        if (errors.getFieldError("name") == null) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", CANT_BE_EMPTY);
        }

        if (null != brandFromDbByName) {
            if (brand.getId() != null) {
                if (!brand.getId().equals(brandFromDbByName.getId())) {
                    errors.rejectValue("name", "", NAME_ALREADY_EXISTS);
                }
            } else {
                errors.rejectValue("name", "", NAME_ALREADY_EXISTS);
            }
        }

    }
	
}
