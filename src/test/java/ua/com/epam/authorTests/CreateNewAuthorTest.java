package ua.com.epam.authorTests;

import org.testng.annotations.Test;
import ua.com.epam.BaseTest;


@Test(description = "Test creating a new author from a random one" +
        "and creating yet another author with same credentials but different authorId")
public class CreateNewAuthorTest extends BaseTest {

    @Test(description = "Post a single Author obj")
    public void postAuthor() {

        validatorFactory.authorValidator().postAuthor(randomeAuthor);
    }
}
