package com.shop.validators;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shop.entity.User;
import com.shop.service.UserService;

import static com.shop.constants.ValidationConstants.*;

public class UserValidator implements Validator{

    private final static Pattern REGEMAIL = Pattern.compile(CLIENT_EMAIL);
    //	check password 6-18 char
    private final static Pattern REGPASS = Pattern.compile(CLIENT_PASSWORD);

    private final UserService userService;

    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;
        if (errors.getFieldError("email") == null) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", CANT_BE_EMPTY);
        }

        if (errors.getFieldError("password") == null) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", CANT_BE_EMPTY);
        }
        
        if(userService.findUserByEmail(user.getEmail())!=null) {
        	errors.rejectValue("email", "", BAD_EMAIL);
        }

        if (!REGEMAIL.matcher(user.getEmail()).matches()) {
            errors.rejectValue("email", "", BAD_EMAIL);
        }

        if(!REGPASS.matcher(user.getPassword()).matches()){
            errors.rejectValue("password", "", BAD_PASSWORD);
        }

        if (!(user.getPassword().equals(user.getConfirmPassword()))) {
            errors.rejectValue("confirmPassword", "", CONFIRM_PASSWORD);
        }
    }

}
