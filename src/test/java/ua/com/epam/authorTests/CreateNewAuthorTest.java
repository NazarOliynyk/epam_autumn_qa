package ua.com.epam.authorTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;


@Test(description = "Test creating a new author from a random one" +
        "and creating yet another author with same credentials but different authorId")
public class CreateNewAuthorTest extends BaseTest {

    @Test(description = "Post a single Author obj")
    public void postAuthor() {

        System.out.println("randomeAuthor.getAuthorId():"+randomeAuthor.getAuthorId());
        System.out.println("randomeAuthor.getAuthorName().getFirst(): "+randomeAuthor.getAuthorName().getFirst());

        authorService.postAuthor(randomeAuthor);
        // 201 - Created
        Assert.assertEquals(authorService.getStatusCode(), 201);
        Assert.assertEquals(
                authorService.getActAuthor(),
                randomeAuthor,
                "Actual author is not equal to random.  ");

        //trying to save the same author
        authorService.postAuthor(randomeAuthor);
        // 409 - Conflict creating an author with the same id-
        Assert.assertEquals(authorService.getStatusCode(), 409);

        // changing authorId and saving-
        randomeAuthor.setAuthorId((long) 5000);
        authorService.postAuthor(randomeAuthor);

        // 201 - Created
         Assert.assertEquals(authorService.getStatusCode(), 201);


        System.out.println("authorService.getActAuthor().getAuthorId():"+authorService.getActAuthor().getAuthorId());
        System.out.println("authorService.getActAuthor().getAuthorName().getFirst(): "+authorService.getActAuthor().getAuthorName().getFirst());
    }
}
