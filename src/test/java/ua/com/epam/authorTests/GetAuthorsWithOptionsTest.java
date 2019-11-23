package ua.com.epam.authorTests;


// Maven dependencies-
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.reflect.TypeToken;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;
import ua.com.epam.entity.author.Author;

import java.lang.reflect.Type;
import java.util.List;

import static ua.com.epam.config.URI.GET_ALL_AUTHORS_ARR;
import static ua.com.epam.utils.JsonKeys.ASCENDING;

@Test
public class GetAuthorsWithOptionsTest extends BaseTest {

    @BeforeMethod
    public void sendAuthors() {

        sendAllAuthors();
    }

    @Test(description = "Get first 5 authors sorted by authorId in ascending order")
    public void getDifferentAuthorsWithOptions() {

        List<Author> authorList =
        authorService.grtAuthorsByParams(ASCENDING, 1, true, 5, "authorId");

        Assert.assertEquals(authorService.getStatusCode(), 200);
        Assert.assertEquals(authorList.size(), 5);
    }

}
