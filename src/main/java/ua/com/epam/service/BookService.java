package ua.com.epam.service;

import ua.com.epam.entity.Response;
import ua.com.epam.entity.book.Book;

import static ua.com.epam.config.URI.*;

public class BookService extends AuthorService{

    // GetBookByIdTest
    public Response getBook(long bookId) {
        client.get(String.format(GET_BOOK_SINGLE_OBJ, bookId));
        return client.getResponse();
    }

    // CreateNewBookTest
    public Response postSingleBook(Book book,
                                   long authorId,
                                   long genreId) {

        client.post(String.format(POST_BOOK_SINGLE_OBJ, authorId, genreId), book);
        return client.getResponse();
    }

    //GetAllBooksTest
    public Response getAllBooks(){
        client.get(GET_ALL_BOOKS_ARR);
        return client.getResponse();
    }

    // DeleteExistedAuthorTest
    public Response deleteBook(long bookId){
        client.delete(String.format(DELETE_BOOK_SINGLE_OBJ, bookId));
        return client.getResponse();
    }

    //GetAllBooksByExistingAuthor
    public Response getBooksByAuthor(long authorId, String orderType, String sortBy){
        String params = uriBuilder
                .setParameter("orderType", orderType)
                .setParameter("sortBy", sortBy)
                .toString();
        client.get(String.format(GET_ALL_BOOKS_BY_AUTHOR_ARR, authorId)+ params);
        return client.getResponse();
    }

}
