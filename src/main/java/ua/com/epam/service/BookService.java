package ua.com.epam.service;

import ua.com.epam.entity.book.Book;

import java.util.List;

import static ua.com.epam.config.URI.*;

public class BookService extends AuthorService{

    // GetBookByIdTest
    public void getBook(long bookId) {
        client.get(String.format(GET_BOOK_SINGLE_OBJ, bookId));
        statusCode = client.getResponse().getStatusCode();
        actBook = g.fromJson(client.getResponse().getBody(), Book.class);
    }

    // CreateNewBookTest
    public void postSingleBook(Book book, long authorId, long genreId) {

        client.post(String.format(POST_BOOK_SINGLE_OBJ, authorId, genreId), book);
        statusCode = client.getResponse().getStatusCode();
        actBook = g.fromJson(client.getResponse().getBody(), Book.class);
    }

    //GetAllBooksTest
    public List<Book> getAllBooks(){
        client.get(GET_ALL_BOOKS_ARR);
        statusCode = client.getResponse().getStatusCode();
        return g.fromJson(client.getResponse().getBody(), type);
    }







    // DeleteExistedAuthorTest
    public int statusCodeDelete(Book randomeBook){
        client.delete(String.format(DELETE_BOOK_SINGLE_OBJ, randomeBook.getBookId()));
        return client.getResponse().getStatusCode();
    }

    public int statusCodeGet(Book randomeBook){
        client.get(String.format(GET_BOOK_SINGLE_OBJ, randomeBook.getBookId()));
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
