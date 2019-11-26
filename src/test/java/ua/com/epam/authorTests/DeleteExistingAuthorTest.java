package ua.com.epam.authorTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;

@Test
public class DeleteExistingAuthorTest extends BaseTest {

    @BeforeMethod
    public void sendAuthors() {
        sendAllAuthors();
    }

    @Test(description = "Delete an existing random author")
    public void deleteAuthor() {

        validatorFactory.authorValidator().deleteAuthor(randomeAuthor);

    }
}
