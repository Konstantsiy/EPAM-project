package com.epam.web.model.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    private static final String REGEX_EMAIL = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";
    private static final String REGEX_PASSWORD = "((?=.*d)(?=.*[a-z])(?=.*[A-Z]).{8,20})";
    private static final String REGEX_USERNAME = "^[0-9а-яА-Яa-zA-Z]+$";

    private UserValidator() {}

    public static boolean isUsernameValid(final String username) {
        Pattern pattern = Pattern.compile(REGEX_USERNAME);
        Matcher matcher = pattern.matcher(username);
        return !matcher.matches();
    }

    public static boolean isAgeValid(final String age) {
        try {
            int number = Integer.parseInt(age);
            return number >= 18 && number <= 120;
        } catch (NumberFormatException e) {
            // log
            return false;
        }
    }

    public static boolean isEmailValid(final String email) {
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }

    public static boolean isPasswordValid(final String password) {
        Pattern pattern = Pattern.compile(REGEX_PASSWORD);
        Matcher matcher = pattern.matcher(password);
        return !matcher.matches();
    }
}
