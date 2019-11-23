package ua.com.epam.authorTests;

import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;
import ua.com.epam.entity.author.Author;

import java.util.List;

import static ua.com.epam.config.URI.GET_ALL_AUTHORS_ARR;
import static ua.com.epam.config.URI.POST_AUTHOR_SINGLE_OBJ;

@Test(description = "")
public class CreateNewAuthorTest extends BaseTest {

    @Test(description = "Post a single Author obj")
    public void postAuthor() {
//        client.post(POST_AUTHOR_SINGLE_OBJ, randomeAuthor);
//
//        int statusCode = client.getResponse().getStatusCode();
//        String body = client.getResponse().getBody();
//
//        Author actAuthor = g.fromJson(body, Author.class);

        authorService.postAuthor(randomeAuthor);
        // 201 - Created
        Assert.assertEquals(authorService.getStatusCode(), 201);
        Assert.assertEquals(
                authorService.getActAuthor(),
                randomeAuthor,
                "Actual author is not equal to random.  ");
    }

}
