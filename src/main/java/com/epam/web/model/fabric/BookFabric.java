package com.epam.web.model.fabric;

import com.epam.web.model.entity.Book;
import com.epam.web.model.entity.Cover;
import com.epam.web.model.entity.Genre;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Optional;

public class BookFabric {
    private static final Logger logger = LogManager.getLogger(BookFabric.class);
    private static final String DEFAULT_IMAGE_VALUE = "";

    public static Optional<Book> createBook(String tile, String price, String authorId,
                                            String genreTitle, String cover, String year,
                                            String size, String desc, String image) {
        try {
            Book book = new Book.Builder()
                    .withId(0)
                    .withTitle(tile)
                    .withSize(Integer.parseInt(size))
                    .withPrice(Double.parseDouble(price))
                    .withYear(Integer.parseInt(year))
                    .withImage(image)
                    .withAuthorId(Integer.parseInt(authorId))
                    .withGenre(Genre.valueOf(genreTitle))
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
