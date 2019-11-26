package ua.com.epam.authorTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;

@Test
public class UpdateExistingAuthor extends BaseTest {

    @BeforeMethod
    public void sendAuthors() {
        sendAllAuthors();
    }

    @Test(description = "Change description and id of an existing author")
    public void updateAuthor() {

        validatorFactory.authorValidator().updateAuthor(randomeAuthor);
    }
}
