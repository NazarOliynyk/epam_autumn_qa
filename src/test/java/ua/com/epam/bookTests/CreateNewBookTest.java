package ua.com.epam.bookTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;

@Test
public class CreateNewBookTest extends BaseTest {

    @BeforeMethod
    public void sendAuthorsAndGenres() {

        sendAllAuthors();
        sendAllGenres();
    }


    @Test(description = "Post a single Book obj")
    public void postSingleBook() {

       validatorFactory.
               bookValidator().
               postSingleBook(randomeAuthor,
               randomBook,
               randomGenre );
    }
}
