package ua.com.epam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ua.com.epam.core.rest.RestClient;
import ua.com.epam.entity.author.Author;
import ua.com.epam.service.CleanUpService;
import ua.com.epam.utils.DataFactory;
import ua.com.epam.utils.helpers.LocalDateAdapter;
import ua.com.epam.service.AuthorService;
import java.time.LocalDate;
import java.util.List;

import static ua.com.epam.config.URI.POST_AUTHOR_SINGLE_OBJ;

public class BaseTest {
    //to parse JSON String to needed model (with correct date parsing possibility)
    protected Gson g = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
    protected AuthorService authorService = new AuthorService();
    protected RestClient client = new RestClient();
    private DataFactory testData = new DataFactory();
    private CleanUpService clean = new CleanUpService(client);


     protected Author randomeAuthor = testData.authors().getRandomOne();
     private List<Author> authorList = testData.authors().getDefaultAuthors();

     protected void sendAllAuthors(){
        for(Author a : authorList) {
            client.post(POST_AUTHOR_SINGLE_OBJ, a);
        }
    }

    //don't delete this!!!
    @BeforeMethod
    public void reinitialize() {
        client = new RestClient();
        testData = new DataFactory();
        clean = new CleanUpService(client);
    }

    @AfterMethod
    public void cleanUp() {
        clean.authors();
    }
}
