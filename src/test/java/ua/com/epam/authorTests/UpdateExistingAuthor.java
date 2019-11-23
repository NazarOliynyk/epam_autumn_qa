package ua.com.epam.authorTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.epam.BaseTest;
import ua.com.epam.entity.author.Author;
import ua.com.epam.entity.author.nested.Name;

import static ua.com.epam.config.URI.GET_AUTHOR_SINGLE_OBJ;
import static ua.com.epam.config.URI.POST_AUTHOR_SINGLE_OBJ;
import static ua.com.epam.config.URI.PUT_AUTHOR_SINGLE_OBJ;

@Test
public class UpdateExistingAuthor extends BaseTest {

    @BeforeMethod
    public void sendAuthors() {
        sendAllAuthors();
    }

    @Test(description = "Change description and id of an existing author")
    public void updateAuthor() {

        authorService.updateAuthor(randomeAuthor, 3000,"Ivan", "Ivanov");
        // 200 - OK
        Assert.assertEquals(authorService.getStatusCode(), 200);
       // compare fields after update-
        Assert.assertEquals(authorService.getActAuthor().getAuthorId().intValue(),
                3000);
        Assert.assertEquals(authorService.getActAuthor().getAuthorName().getFirst(),
                "Ivan");
        Assert.assertEquals(authorService.getActAuthor().getAuthorName().getSecond(),
                "Ivanov");
    }
}
