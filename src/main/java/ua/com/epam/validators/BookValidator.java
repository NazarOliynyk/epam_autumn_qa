package ua.com.epam.validators;

import org.testng.Assert;
import ua.com.epam.entity.Response;
import ua.com.epam.entity.author.Author;
import ua.com.epam.entity.book.Book;
import ua.com.epam.entity.genre.Genre;

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

}
