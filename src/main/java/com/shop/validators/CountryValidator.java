package com.shop.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shop.entity.Country;
import com.shop.service.CountryService;

import static com.shop.constants.ValidationConstants.*;

public class CountryValidator implements Validator{

    private final CountryService countryService;

    public CountryValidator(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Country.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    	Country country = (Country) target;
        Country countryFromDbByName = countryService.findByName(country.getName());

        if (errors.getFieldError("name") == null) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", CANT_BE_EMPTY);
        }

        if (null != countryFromDbByName) {
            if (country.getId() != null) {
                if (!country.getId().equals(countryFromDbByName.getId())) {
                    errors.rejectValue("name", "", NAME_ALREADY_EXISTS);
                }
            } else {
                errors.rejectValue("name", "", NAME_ALREADY_EXISTS);
            }
        }

    }
	
}
