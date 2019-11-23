package ua.com.epam.service;

import com.google.gson.reflect.TypeToken;
import org.apache.http.client.utils.URIBuilder;
import ua.com.epam.entity.author.Author;
import ua.com.epam.entity.author.nested.Name;

import java.lang.reflect.Type;
import java.util.List;

import static ua.com.epam.config.URI.*;

public class AuthorService extends AbstractService{
    //you are the painter, so paint something here))

    // GetAuthorByIdTest
    public void getAuthor(int authorId) {
         client.get(String.format(GET_AUTHOR_SINGLE_OBJ, authorId));
         statusCode = client.getResponse().getStatusCode();
         actAuthor = g.fromJson(client.getResponse().getBody(), Author.class);
    }

    // CreateNewAuthorTest
    public void postAuthor(Author randomeAuthor) {
         client.post(POST_AUTHOR_SINGLE_OBJ, randomeAuthor);
         statusCode = client.getResponse().getStatusCode();
         actAuthor = g.fromJson(client.getResponse().getBody(), Author.class);
    }

    // DeleteExistedAuthorTest
    public int statusCodeDelete(Author randomeAuthor){
        client.delete(String.format(DELETE_AUTHOR_SINGLE_OBJ, randomeAuthor.getAuthorId()));
        return client.getResponse().getStatusCode();
    }

    public int statusCodeGet(Author randomeAuthor){
        client.get(String.format(GET_AUTHOR_SINGLE_OBJ, randomeAuthor.getAuthorId()));
        return client.getResponse().getStatusCode();
    }

    // UpdateExistingAuthor
    public void updateAuthor(Author randomeAuthor, long newId, String newFN, String newSN) {

        long randomeId = randomeAuthor.getAuthorId();
        randomeAuthor.setAuthorName(new Name(newFN, newSN));
        randomeAuthor.setAuthorId(newId);
        client.put(String.format(PUT_AUTHOR_SINGLE_OBJ, randomeId), randomeAuthor);
        statusCode = client.getResponse().getStatusCode();
        actAuthor = g.fromJson(client.getResponse().getBody(), Author.class);
    }

    // GetAuthorByNameAndSurname
    public List<Author> getAuthorByInitials(String value) {

        String paramsOne = new URIBuilder().
                setParameter("query", value)
                .toString();
        client.get(SEARCH_FOR_EXISTED_AUTHORS_ARR + paramsOne);
        statusCode = client.getResponse().getStatusCode();
        return g.fromJson(client.getResponse().getBody(), type);

    }

    public List<Author> grtAuthorsByParams(String orderType,
                                    int page,
                                    boolean pagination,
                                    int size,
                                    String sortBy){
        String params = new URIBuilder()
                .setParameter("orderType", orderType)
                .setParameter("page", String.valueOf(page))
                .setParameter("pagination", String.valueOf(pagination))
                .setParameter("size", String.valueOf(size))
                .setParameter("sortBy", sortBy)
                .toString();
        client.get(GET_ALL_AUTHORS_ARR + params);
        statusCode = client.getResponse().getStatusCode();

        return g.fromJson(client.getResponse().getBody(), type);
    }


}
