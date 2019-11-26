package ua.com.epam.genreTests;

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
    public void deleteGenre() {

        validatorFactory.genreValidator().deleteGenre(randomGenre);
    }
}