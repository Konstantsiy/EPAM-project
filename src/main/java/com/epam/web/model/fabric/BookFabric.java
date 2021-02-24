package com.epam.web.model.fabric;

import com.epam.web.model.entity.Book;
import com.epam.web.model.entity.Cover;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Optional;

public class BookFabric {
    private static final Logger logger = LogManager.getLogger(BookFabric.class);
    private static final int DEFAULT_ID_VALUE = 0;

    public static Optional<Book> createBook(String tile, String price, String authorId, String genreId1, String genreId2, String genreId3, String cover, String year, String size, String desc, String image) {
        try {
            int sizeValue = Integer.parseInt(size);
            double priceValue = Double.parseDouble(price);
            int authorIdValue = Integer.parseInt(authorId);
            int yearValue = Integer.parseInt(year);
            int genreId1Value = DEFAULT_ID_VALUE;
            int genreId2Value = DEFAULT_ID_VALUE;
            int genreId3Value = DEFAULT_ID_VALUE;
            if(!genreId1.isEmpty()) {
                genreId1Value = Integer.parseInt(genreId1);
            }
            if(!genreId2.isEmpty()) {
                genreId2Value = Integer.parseInt(genreId2);
            }
            if(!genreId3.isEmpty()) {
                genreId3Value = Integer.parseInt(genreId3);
            }
            Book book = new Book.Builder()
                    .withId(0)
                    .withTitle(tile)
                    .withSize(sizeValue)
                    .withPrice(priceValue)
                    .withYear(yearValue)
                    .withImage(image)
                    .withAuthorId(authorIdValue)
                    .withCover(Cover.valueOf(cover))
                    .withDesc(desc)
                    .build();
            return Optional.of(book);
        } catch (NumberFormatException e) {
            logger.error(e.getMessage());
        }
        return Optional.empty();
    }
}
