package ua.com.epam.authorTests;


// Maven dependencies-
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;
import ua.com.epam.entity.author.Author;

import java.util.List;

import static ua.com.epam.utils.JsonKeys.DESCENDING;

@Test
public class GetAuthorsWithOptionsTest extends BaseTest {

    @BeforeMethod
    public void sendAuthors() {

        sendAllAuthors();
    }

    @Test(description = "Get first 5 authors sorted by authorId in ascending order")
    public void getDifferentAuthorsWithOptions() {

        List<Author> authorList =
        authorService.grtAuthorsByParams(DESCENDING, 1, true, 10, "authorId");
        int size = authorList.size();
        //200 -ok
        Assert.assertEquals(authorService.getStatusCode(), 200);
        Assert.assertEquals(size, 10);
        //compare first and last authors from the list for descending order-
        Assert.assertTrue(authorList.get(0).getAuthorId() > authorList.get(size-1).getAuthorId());
        Assert.assertTrue(authorList.get(2).getAuthorId() > authorList.get(size-3).getAuthorId());
    }

}
