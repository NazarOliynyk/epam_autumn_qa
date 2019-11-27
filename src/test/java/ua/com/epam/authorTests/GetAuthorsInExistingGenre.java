package ua.com.epam.authorTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;

@Test
public class GetAuthorsInExistingGenre extends BaseTest {

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

    @Test(description = "Getting all authors of a certain genre")
    public void getAuthorsInGenre(){

        // 4583 - the id of number 2 in genre json array
        // there are 8 books of 4 authors(2 per author) in genre 4583
        validatorFactory.authorValidator().getAuthorsInGenre(4583);

    }
}
