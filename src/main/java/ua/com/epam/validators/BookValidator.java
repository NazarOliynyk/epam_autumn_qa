package ua.com.epam.validators;

import com.google.common.collect.Ordering;
import org.testng.Assert;
import ua.com.epam.entity.Response;
import ua.com.epam.entity.author.Author;
import ua.com.epam.entity.book.Book;
import ua.com.epam.entity.genre.Genre;

import java.util.ArrayList;
import java.util.List;

public class BookValidator extends AbstractValidator{

    public void postSingleBook(Author author,
                               Book book,
                               Genre genre) {

        Response response = bookService.postSingleBook(book,
                author.getAuthorId(),
                genre.getGenreId());
        // 201 - Created
        Assert.assertEquals(response.getStatusCode(), 201);
        actBook = g.fromJson(response.getBody(), Book.class);
        Assert.assertEquals(actBook, book);
    }

    public void deleteBook(Book book) {

        long bookId = book.getBookId();

        // check if the randomAuthor is present in the DB-
        Response responseBeforeDelete =
                bookService.getBook(bookId);
        // 200 - OK
        Assert.assertEquals(responseBeforeDelete.getStatusCode(), 200);

        // deleting the random author-
        Response responseOnDeleteAction =
                bookService.deleteBook(bookId);
        // 204 - no content
        Assert.assertEquals(responseOnDeleteAction.getStatusCode(), 204);

        // ascertain that the randomAuthor is not present in the DB-
        Response responseAfterDelete =
                bookService.getBook(bookId);
        // 404 - not found
        Assert.assertEquals(responseAfterDelete.getStatusCode(), 404);
    }

    public void getAllBooks(int listSize) {

        Response response = bookService.getAllBooks();
        List<Book> bookList = g.fromJson(response.getBody(), type);
        // 200 - OK
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(bookList.size(), listSize,
                "The actual size of book array is not equal to expected. ");
    }

    public void getBookById(Book book) {

        Response response = bookService.getBook(book.getBookId());
        // 200 - OK
        Assert.assertEquals(response.getStatusCode(), 200);
        actBook = g.fromJson(response.getBody(), Book.class);
        Assert.assertEquals(actBook, book,
                "Actual book is not equal to expected. ");
    }


    public void getAllBooksByAuthor(long authorId,
                                    String orderType,
                                    String sortBy){
        Response response = bookService.
                getBooksByAuthor(authorId,
                orderType,
                sortBy);

        // 200 - OK
        Assert.assertEquals(response.getStatusCode(), 200);

        List<Book> bookList = g.fromJson(response.getBody(), typeBook);

        List<Integer> idList = new ArrayList<>();
        bookList.forEach(book -> idList.add((int) book.getBookId()));

        List<Author> authorList = new ArrayList<>();

        // fill the authorList with the authors of all the books in the bookList-
        bookList.forEach(book ->
                authorList.add(g.fromJson(authorService.
                        getAuthorByBookId(book.getBookId()).getBody(),
                        Author.class)));

        // check the order of id in bookList
        softAssert.assertTrue(Ordering.natural().isOrdered(idList));
        // check if all books have the same author
        authorList.forEach(author ->
                softAssert.assertEquals(author.getAuthorId().intValue(), authorId));
        softAssert.assertAll();
    }

}
