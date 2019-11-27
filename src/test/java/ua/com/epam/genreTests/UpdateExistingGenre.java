package ua.com.epam.genreTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;

@Test
public class UpdateExistingGenre extends BaseTest {

    @BeforeMethod
    public void sendGenres() {

        sendAllGenres();
    }

    @Test(description = "Change fields of an existing genre")
    public void updateGenre() {

        randomGenre.setGenreName("Completely new genre name");
        randomGenre.setGenreDescription("Completely new genre description");
        validatorFactory.genreValidator().updateGenre(randomGenre);
    }
}
