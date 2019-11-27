package ua.com.epam.service;

import ua.com.epam.entity.Response;
import ua.com.epam.entity.author.Author;
import ua.com.epam.entity.author.nested.Name;
import static ua.com.epam.config.URI.*;

public class AuthorService extends AbstractService{
    //you are the painter, so paint something here))

    // GetAuthorByIdTest

    public Response getAuthor(long authorId) {
        client.get(String.format(GET_AUTHOR_SINGLE_OBJ, authorId));
        return client.getResponse();
    }

    //CreateNewAuthor
    public Response postAuthor(Author randomeAuthor) {
        client.post(POST_AUTHOR_SINGLE_OBJ, randomeAuthor);
        return client.getResponse();
    }

    //DeleteExistingAuthor
    public Response deleteAuthor(long authorId){
        client.delete(String.format(DELETE_AUTHOR_SINGLE_OBJ, authorId));
        return client.getResponse();
    }

    // UpdateExistingAuthor
    public Response updateAuthor(Author author,
                                 long newId,
                                 String newFN,
                                 String newSN) {

        long authorId = author.getAuthorId();
        author.setAuthorName(new Name(newFN, newSN));
        author.setAuthorId(newId);
        client.put(String.format(PUT_AUTHOR_SINGLE_OBJ, authorId), author);
        return client.getResponse();
    }

    // GetAuthorByNameAndSurname
    public Response getAuthorListByInitials(String value) {

        String paramsOne = uriBuilder.
                setParameter("query", value)
                .toString();
        client.get(SEARCH_FOR_EXISTED_AUTHORS_ARR + paramsOne);
        return client.getResponse();
    }

    //GetAuthorsWithOptions
    public Response getAuthorListByParams(String orderType,
                                           int page,
                                           boolean pagination,
                                           int size,
                                           String sortBy){
        String params = uriBuilder
                .setParameter("orderType", orderType)
                .setParameter("page", String.valueOf(page))
                .setParameter("pagination", String.valueOf(pagination))
                .setParameter("size", String.valueOf(size))
                .setParameter("sortBy", sortBy)
                .toString();
        client.get(GET_ALL_AUTHORS_ARR + params);
        return client.getResponse();
    }

    //GetAuthorByBookId
    public Response getAuthorByBookId(long bookId){
        client.get(String.format(GET_AUTHOR_OF_BOOK_OBJ, bookId));
        return client.getResponse();
    }

    //GetAuthorsOfExistingGenre
    public Response getAuthorsInGenre(long generId){
        client.get(String.format(GET_ALL_AUTHORS_IN_GENRE_ARR, generId));
        return client.getResponse();
    }
}
