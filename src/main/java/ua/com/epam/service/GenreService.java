package ua.com.epam.service;

import ua.com.epam.entity.genre.Genre;

import static ua.com.epam.config.URI.DELETE_GENRE_SINGLE_OBJ;
import static ua.com.epam.config.URI.GET_GENRE_SINGLE_OBJ;

public class GenreService extends AbstractService{

    // GetGenreByIdTest
    public void getGenre(int genreId) {
        client.get(String.format(GET_GENRE_SINGLE_OBJ, genreId));
        statusCode = client.getResponse().getStatusCode();
        actGenre = g.fromJson(client.getResponse().getBody(), Genre.class);
    }

//    // CreateNewAuthorTest
//    public void postAuthor(Author randomeAuthor) {
//        client.post(POST_AUTHOR_SINGLE_OBJ, randomeAuthor);
//        statusCode = client.getResponse().getStatusCode();
//        actAuthor = g.fromJson(client.getResponse().getBody(), Author.class);
//    }
//

        // DeleteExistingGenreTest
    public int statusCodeDelete(Genre randomGenre){
        client.delete(String.format(DELETE_GENRE_SINGLE_OBJ, randomGenre.getGenreId()));
        return client.getResponse().getStatusCode();
    }
//
    public int statusCodeGet(Genre randomGenre){
        client.get(String.format(GET_GENRE_SINGLE_OBJ, randomGenre.getGenreId()));
        return client.getResponse().getStatusCode();
    }
//
//    // UpdateExistingAuthor
//    public void updateAuthor(Author randomeAuthor, long newId, String newFN, String newSN) {
//
//        long randomeId = randomeAuthor.getAuthorId();
//        randomeAuthor.setAuthorName(new Name(newFN, newSN));
//        randomeAuthor.setAuthorId(newId);
//        client.put(String.format(PUT_AUTHOR_SINGLE_OBJ, randomeId), randomeAuthor);
//        statusCode = client.getResponse().getStatusCode();
//        actAuthor = g.fromJson(client.getResponse().getBody(), Author.class);
//    }
//
//    // GetAuthorByNameAndSurname
//    public List<Author> getAuthorByInitials(String value) {
//
//        String paramsOne = uriBuilder.
//                setParameter("query", value)
//                .toString();
//        client.get(SEARCH_FOR_EXISTED_AUTHORS_ARR + paramsOne);
//        statusCode = client.getResponse().getStatusCode();
//        return g.fromJson(client.getResponse().getBody(), type);
//
//    }
//
//    public List<Author> grtAuthorsByParams(String orderType,
//                                           int page,
//                                           boolean pagination,
//                                           int size,
//                                           String sortBy){
//        String params = uriBuilder
//                .setParameter("orderType", orderType)
//                .setParameter("page", String.valueOf(page))
//                .setParameter("pagination", String.valueOf(pagination))
//                .setParameter("size", String.valueOf(size))
//                .setParameter("sortBy", sortBy)
//                .toString();
//        client.get(GET_ALL_AUTHORS_ARR + params);
//        statusCode = client.getResponse().getStatusCode();
//
//        return g.fromJson(client.getResponse().getBody(), type);
//    }

}
