package com.epam.web.model.validator;

import com.epam.web.model.entity.Book;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BookValidator {
    private static final Logger logger = LogManager.getLogger(BookValidator.class);
    private static final int MIN_POSSIBLE_YEAR = 1900;
    private static final int MAX_POSSIBLE_YEAR = 2021;
    private static final int MIN_BOOK_SIZE = 3;
    private static final double MIN_BOOK_PRICE = 0;

    public static boolean isBookValid(Book book) {
        return isYearValid(book.getYear()) && isPriceValid(book.getPrice()) && isSizeValid(book.getSize());
    }

    public static boolean isYearValid(int year) {
        boolean result = year > MIN_POSSIBLE_YEAR && year < MAX_POSSIBLE_YEAR;
        if(!result) {
            logger.error("Publication year (" + year + ") is invalid");
        }
        return result;
    }

    public static boolean isSizeValid(int size) {
        boolean result = size >= MIN_BOOK_SIZE;
        if(!result) {
            logger.error("Book size is (" + size + " pages) invalid");
        }
        return result;
    }

    public static boolean isPriceValid(double price) {
        boolean result = price >= MIN_BOOK_PRICE;
        if(!result) {
            logger.error("Book price (" + price + " $) is invalid");
        }
        return result;
    }

}
