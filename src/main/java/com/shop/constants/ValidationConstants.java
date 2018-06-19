package com.shop.constants;

public final class ValidationConstants {

    public static final String NAME_ALREADY_EXISTS = "Name already exists";

    public static final String SHORT_NAME_ALREADY_EXISTS = "Short name already exists";

    public static final String CANT_BE_EMPTY = "Cant be empty";

    public static final String CONFIRM_PASSWORD_CANT_BE_EMPTY = "Confirm password can't be empty";

    public static final String CLIENT_NAME = "^[a-zA-Z0-9]{3,18}$";

    public static final String CLIENT_PASSWORD = "^[a-zA-Z0-9]{6,18}$";

    public static final String CLIENT_EMAIL = ".+@.+\\..+";

    public static final String CONFIRM_PASSWORD = "Passwords does not match";

    public static final String BAD_EMAIL = "Bad email";

    public static final String BAD_LOGIN = "Bad login";

    public static final String BAD_PASSWORD = "Bad password";

    public static final String BAD_PHONE = "Bad phone";

    public static final String BAD_NAME = "Bad name";

    public static final String BAD_PRICE = "^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$";

}