package com.shop.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shop.entity.Item;
import com.shop.form.ItemForm;
import com.shop.service.ItemService;

import static com.shop.constants.ValidationConstants.*;

import java.util.regex.Pattern;

public class ItemValidator implements Validator{

    private final ItemService itemService;
    
    private final static Pattern REG = Pattern.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");

    public ItemValidator(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ItemForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    	ItemForm itemForm = (ItemForm) target;
    	Item itemnFromDbByName = itemService.findByName(itemForm.getName());

        if (errors.getFieldError("name") == null) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", CANT_BE_EMPTY);
        }
        
        if(!REG.matcher(itemForm.getPrice()).matches()){
			errors.rejectValue("price", "", "Can be separated only . or , or write only numbers");
		}
        
        if(!itemForm.getFile().getContentType().contains("image")) {
        	errors.rejectValue("file", "", "Must be omage type");
        }

        if (null != itemnFromDbByName) {
            if (itemForm.getId() != null) {
                if (!itemForm.getId().equals(itemnFromDbByName.getId())) {
                    errors.rejectValue("name", "", NAME_ALREADY_EXISTS);
                }
            } else {
                errors.rejectValue("name", "", NAME_ALREADY_EXISTS);
            }
        }

    }
	
}
