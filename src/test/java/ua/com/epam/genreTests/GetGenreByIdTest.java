package ua.com.epam.genreTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;

@Test
public class GetGenreByIdTest extends BaseTest {

    @BeforeMethod
    public void sendGenres() {

        sendAllGenres();
    }

    @Test(description = "Get a single Genre obj by genreId")
    public void getGenre() {

        genreService.getGenre(4583);
        // 200 - OK
        Assert.assertEquals(genreService.getStatusCode(), 200);
        Assert.assertEquals(
                genreService.getActGenre().getGenreId().intValue(),
                4583,
                "Actual author's id is not equal to expected. ");
    }
}
