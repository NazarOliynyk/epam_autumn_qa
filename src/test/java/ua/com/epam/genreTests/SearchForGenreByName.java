package ua.com.epam.genreTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;

@Test
public class SearchForGenreByName extends BaseTest {

    @BeforeMethod
    public void sendGenres() {

        sendAllGenres();
    }

    @Test(description = "Send 1 2-letter String and 1 3-letter String" +
            "to ascertain that not less than 3 letters are relevant to search")
    public void getGenreByName(){

        validatorFactory.genreValidator().
                getGenreByName("Es", "Ess");
    }
}
