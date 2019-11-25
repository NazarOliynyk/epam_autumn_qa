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

        int statusCodeBeforeDelete = bookService.statusCodeGet(randomBook);

        int statusCodeOnDeleteAction = bookService.statusCodeDelete(randomBook);

        int statusCodeAfterDelete = bookService.statusCodeGet(randomBook);
        // 200 - OK
        Assert.assertEquals(statusCodeBeforeDelete, 200);
        // 204 - no content
        Assert.assertEquals(statusCodeOnDeleteAction, 204);
        // 404 - not found
        Assert.assertEquals(statusCodeAfterDelete, 404);
    }
}
