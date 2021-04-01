package com.epam.web.model.fabric;

import com.epam.web.model.entity.Genre;

public class GenreFabric {
    public static Genre createGenre(int id, String title) {
        return new Genre(id, title);
    }
}
