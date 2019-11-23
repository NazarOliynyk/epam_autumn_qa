package ua.com.epam.authorTests;

import com.google.gson.reflect.TypeToken;
import org.apache.http.client.utils.URIBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;
import ua.com.epam.entity.author.Author;

import java.lang.reflect.Type;
import java.util.List;

import static ua.com.epam.config.URI.SEARCH_FOR_EXISTED_AUTHORS_ARR;

@Test
public class GetAuthorByNameAndSurname extends BaseTest {

//    http://localhost:8080/api/library/authors/search?query=O'Co
//    http://localhost:8080/api/library/authors/search?query=Vic%20O'Co

    @BeforeMethod
    public void sendAuthors() {

        sendAllAuthors();
    }

    @Test(description = "Get a single Author obj by name and surname")
    public void getAuthorByInitials() {

        // there are 2 authors with initials containing "Fis"
        Assert.assertEquals(authorService.getAuthorByInitials("Fis").size(), 2);
        Assert.assertEquals(authorService.getStatusCode(), 200);

        // there is only one author with initials containing both "Ber" and "Fis"
        Assert.assertEquals(authorService.getAuthorByInitials("Ber%Fis").size(), 1);
        Assert.assertEquals(authorService.getStatusCode(), 200);

    }
}
