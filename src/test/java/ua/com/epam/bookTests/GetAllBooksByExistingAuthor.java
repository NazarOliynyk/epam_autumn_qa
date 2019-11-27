package ua.com.epam.bookTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;

import static ua.com.epam.utils.JsonKeys.ASCENDING;
import static ua.com.epam.utils.JsonKeys.BOOK_ID;

@Test
public class GetAllBooksByExistingAuthor extends BaseTest {

    @BeforeMethod
    public void sendAuthorsAndGenres() {

        sendAllAuthors();
        sendAllGenres();
    }

    // send arranged list instead of random-
    @BeforeMethod
    public void sendBooks() {

        sendPrearrangedBooks();
    }

    @Test(description = "Get all books of existing author")
    public void getBooksByAuthor(){

        // 1050 - the id of the author #4
        validatorFactory.bookValidator().
                getAllBooksByAuthor(1050,
                        ASCENDING,
                        BOOK_ID);
    }
}
