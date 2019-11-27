package ua.com.epam.service;

import ua.com.epam.entity.Response;
import ua.com.epam.entity.genre.Genre;

import static ua.com.epam.config.URI.*;

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

    //UpdateExistingGenre
    public Response updateGenre(Genre updatedGenre){
        client.put(String.format(PUT_GENRE_SINGLE_OBJ, updatedGenre.getGenreId()),
                updatedGenre);
        return client.getResponse();
    }

    // GetAuthorByNameAndSurname
    public Response getGenreListByName(String value) {

        String paramsOne = uriBuilder.
                setParameter("query", value)
                .toString();
        client.get(SEARCH_FOR_EXISTING_GENRE_ARR + paramsOne);
        return client.getResponse();
    }

}
