package ua.com.epam.genreTests;

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

        validatorFactory.genreValidator().getGenre(randomGenre);
    }
}
