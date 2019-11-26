package ua.com.epam.bookTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;

@Test
public class DeleteExistingBookTest extends BaseTest {

    @BeforeMethod
    public void sendAuthorsAndGenres() {

        sendAllAuthors();
        sendAllGenres();
    }

    @BeforeMethod
    public void sendBooks() {

        sendAllBooks();
    }

    @Test(description = "Delete an existing random book")
    public void deleteBook() {

        validatorFactory.bookValidator().deleteBook(randomBook);
    }
}
