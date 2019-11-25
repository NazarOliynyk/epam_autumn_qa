package ua.com.epam.bookTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;

@Test
public class GetBookByIdTest extends BaseTest {

    @BeforeMethod
    public void sendAuthorsAndGenres() {

        sendAllAuthors();
        sendAllGenres();

    }

    @BeforeMethod
    public void sendBooks() {
        sendAllBooks();
    }


    @Test(description = "Get a single Book obj ")
    public void getBookById() {

        bookService.getBook(randomBook.getBookId());
        // 200 - OK
        Assert.assertEquals(bookService.getStatusCode(), 200);
        Assert.assertEquals(bookService.getActBook(), randomBook,
                "Actual book is not equal to expected. ");
    }

}
