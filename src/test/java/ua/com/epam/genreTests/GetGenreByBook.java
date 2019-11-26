package ua.com.epam.genreTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;

@Test
public class GetGenreByBook extends BaseTest {


    @BeforeMethod
    public void sendAuthorsAndGenres() {

        sendAllAuthors();
        sendAllGenres();
    }

    @BeforeMethod
    public void sendBooks() {

        sendAllBooks();
    }

    public void GetGenreByBookId(){

        randomBook.setBookId(5000);
        validatorFactory.genreValidator().
                getGenreByBookId(randomBook,
                        randomeAuthor,
                        randomGenre);
    }
}
