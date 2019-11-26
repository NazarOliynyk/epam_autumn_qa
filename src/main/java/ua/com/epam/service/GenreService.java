package ua.com.epam.service;

import ua.com.epam.entity.Response;
import static ua.com.epam.config.URI.DELETE_GENRE_SINGLE_OBJ;
import static ua.com.epam.config.URI.GET_GENRE_BY_BOOK;
import static ua.com.epam.config.URI.GET_GENRE_SINGLE_OBJ;

public class GenreService extends AbstractService{

    // GetGenreByIdTest
    public Response getGenre(long genreId) {
        client.get(String.format(GET_GENRE_SINGLE_OBJ, genreId));
        return client.getResponse();
    }

        // DeleteExistingGenreTest
    public Response deleteGenre(long genreId){
        client.delete(String.format(DELETE_GENRE_SINGLE_OBJ, genreId));
        return client.getResponse();
    }

    public Response getGenreByBookId(long bookId){
        client.get(String.format(GET_GENRE_BY_BOOK, bookId));
        return client.getResponse();
    }

}
