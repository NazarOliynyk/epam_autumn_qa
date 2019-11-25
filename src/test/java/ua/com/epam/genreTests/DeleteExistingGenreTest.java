package ua.com.epam.genreTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;

@Test
public class DeleteExistingGenreTest extends BaseTest {

    @BeforeMethod
    public void sendGenres() {

        sendAllGenres();
    }

    @Test(description = "Delete an existing random genre")
    public void deleteAuthor() {

        int statusCodeBeforeDelete = genreService.statusCodeGet(randomGenre);

        int statusCodeOnDeleteAction = genreService.statusCodeDelete(randomGenre);

        int statusCodeAfterDelete = genreService.statusCodeGet(randomGenre);
        // 200 - OK
        Assert.assertEquals(statusCodeBeforeDelete, 200);
        // 204 - no content
        Assert.assertEquals(statusCodeOnDeleteAction, 204);
        // 404 - not found
        Assert.assertEquals(statusCodeAfterDelete, 404);
    }
}