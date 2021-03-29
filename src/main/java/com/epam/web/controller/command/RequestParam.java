package com.epam.web.controller.command;

public class RequestParam {
    public static final String COMMAND = "command";
    public static final String ID = "id";
    public static final String NEW_ORDER = "new";
    public static final String OLD_ORDER = "old";
    public static final String LIST = "list";
//    ----------book----------
    public static final String BOOK_IMAGE = "book_image";
    public static final String BOOK_TITLE = "book_title";
    public static final String BOOK_SIZE = "book_size";
    public static final String BOOK_AUTHOR_ID = "book_author_id";
    public static final String BOOK_GENRE = "book_genre";
    public static final String BOOK_COVER = "book_cover";
    public static final String BOOK_PUBLISHING_YEAR = "book_p_year";
    public static final String BOOK_DESCRIPTION = "book_desc";
    public static final String BOOK_PRICE = "book_price";
//    ----------author----------
    public static final String AUTHOR_IMAGE = "author_image";
    public static final String AUTHOR_NAME = "author_name";
    public static final String AUTHOR_SURNAME = "author_surname";
    public static final String AUTHOR_BIOGRAPHY = "author_bio";
//    ----------genre----------
    public static final String GENRE_TITLE = "genre_title";
//    --------publisher--------
    public static final String PUBLISHER_TITLE = "p_title";
//    --------search--------
    public static final String SEARCH_GENRE = "search_genre";
    public static final String SEARCH_AUTHOR_ID = "search_author_id";
    public static final String SEARCH_FROM = "search_from";
    public static final String SEARCH_TO = "search_to";



    private RequestParam() {}
}
