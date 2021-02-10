package com.epam.web.model.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LanguageValidator {
    private static final String REGEX_ENG = "^[a-zA-Z]+$";
    private static final String REGEX_RUS = "^[а-яА-Я]+$";


    private LanguageValidator() {}

    public static boolean isEng(String parameter) {
        Pattern pattern = Pattern.compile(REGEX_ENG);
        Matcher matcher = pattern.matcher(parameter);
        return !matcher.matches();
    }

    public static boolean isRus(String parameter) {
        Pattern pattern = Pattern.compile(REGEX_RUS);
        Matcher matcher = pattern.matcher(parameter);
        return !matcher.matches();
    }
}
