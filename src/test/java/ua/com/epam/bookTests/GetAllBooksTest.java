package ua.com.epam.bookTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;
import ua.com.epam.entity.book.Book;

import java.util.List;

@Test
public class GetAllBooksTest extends BaseTest {

    @BeforeMethod
    public void sendAuthorsAndGenres() {

        sendAllAuthors();
        sendAllGenres();

    }

    @BeforeMethod
    public void sendBooks() {
        sendAllBooks();
    }

    @Test(description = "Get the whole list of books ")
    public void getAllBooks() {

        List<Book> bookList= bookService.getAllBooks();
        // 200 - OK
        Assert.assertEquals(bookService.getStatusCode(), 200);
        Assert.assertEquals(bookList.size(), 20,
                "The actual size of book array is not equal to expected. ");
    }
}
