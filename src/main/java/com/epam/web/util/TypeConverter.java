package com.epam.web.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.util.Base64;

public class TypeConverter {
    private static final Logger logger = LogManager.getLogger(TypeConverter.class);

    public static double stringToDouble(String value) {
        double result = 0;
        try {
            result = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            logger.error("string -> double convert error with value " + value);
        }
        return result;
    }

    public static double stringToInt(String value) {
        int result = 0;
        try {
            result = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            logger.error("string -> double convert error with value " + value);
        }
        return result;
    }

    public static String blobToString(Blob blob) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] imageBytes = outputStream.toByteArray();
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        return base64Image;
    }
}
