package ua.com.epam.authorTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;

@Test
public class GetAuthorByBookId extends BaseTest {

    @BeforeMethod
    public void sendAuthorsAndGenres() {

        sendAllAuthors();
        sendAllGenres();
    }

    @BeforeMethod
    public void sendBooks() {

        sendAllBooks();
    }

    public void getAuthorByBook(){

        randomBook.setBookId(5000);

        validatorFactory.authorValidator().
                getAuthorByBookId(randomBook,
                        randomeAuthor,
                        randomGenre);
    }
}
