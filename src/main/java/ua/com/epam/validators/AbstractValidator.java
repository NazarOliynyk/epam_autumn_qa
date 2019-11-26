package ua.com.epam.validators;

import com.google.gson.reflect.TypeToken;
import org.testng.asserts.SoftAssert;
import ua.com.epam.core.rest.RestClient;
import ua.com.epam.entity.author.Author;
import ua.com.epam.service.AuthorService;
import ua.com.epam.utils.DataFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.com.epam.utils.helpers.LocalDateAdapter;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;


abstract class AbstractValidator {

    private RestClient client = new RestClient();

    AuthorService authorService = new AuthorService();

    private DataFactory testData = new DataFactory();

    Type type = new TypeToken<List<Author>>(){}.getType();

    Gson g = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();

    //protected Author randomeAuthor = testData.authors().getRandomOne();

    private List<Author> authorList = testData.authors().getDefaultAuthors();

    Author actAuthor;

    SoftAssert softAssert = new SoftAssert();

}
