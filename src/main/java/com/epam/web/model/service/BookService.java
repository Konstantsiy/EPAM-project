package com.epam.web.model.service;

import com.epam.web.model.entity.Book;

import javax.servlet.http.Part;
import java.util.List;

public interface BookService extends BaseService<Book> {
    boolean add(String title, String size, String price,
                String year, Part imagePart, String authorId,
                List<String> genresId, String cover, String desc);
    boolean exists(String title);
}
