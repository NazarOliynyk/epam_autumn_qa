package ua.com.epam.authorTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;

@Test
public class GetAuthorByNameAndSurname extends BaseTest {

    @BeforeMethod
    public void sendAuthors() {

        sendAllAuthors();
    }

    @Test(description = "Get a single Author obj by name and surname")
    public void getAuthorByInitials() {

        validatorFactory.
                authorValidator().
                getAuthorByInitials("Fis", "Ber%Fis");
    }
}
