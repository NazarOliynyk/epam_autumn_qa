package ua.com.epam.authorTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;

@Test
public class DeleteExistedAuthorTest extends BaseTest {

    @BeforeMethod
    public void sendAuthors() {
        sendAllAuthors();
    }

    @Test(description = "Delete an existing randome author")
    public void deleteAuthor() {

        int statusCodeBeforeDelete = authorService.statusCodeGet(randomeAuthor);

        int statusCodeOnDeleteAction = authorService.statusCodeDelete(randomeAuthor);

        int statusCodeAfterDelete = authorService.statusCodeGet(randomeAuthor);
        // 200 - OK
        Assert.assertEquals(statusCodeBeforeDelete, 200);
        // 204 - no content
        Assert.assertEquals(statusCodeOnDeleteAction, 204);
        // 404 - not found
        Assert.assertEquals(statusCodeAfterDelete, 404);
    }
}
