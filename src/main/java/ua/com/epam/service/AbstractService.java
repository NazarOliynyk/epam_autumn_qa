package ua.com.epam.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.utils.URIBuilder;
import ua.com.epam.core.rest.RestClient;
import ua.com.epam.entity.author.Author;
import ua.com.epam.entity.book.Book;
import ua.com.epam.entity.genre.Genre;
import ua.com.epam.utils.helpers.LocalDateAdapter;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

public abstract class AbstractService {

    Gson g = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();

    RestClient client = new RestClient();

    Type type = new TypeToken<List<Author>>(){}.getType();

    URIBuilder uriBuilder = new URIBuilder();

    int statusCode;

    Author actAuthor;

    Genre actGenre;

    Book actBook;


    public int getStatusCode() {

        return statusCode;
    }

    public Author getActAuthor() {

        return actAuthor;
    }

    public Book getActBook() {
        return actBook;
    }

    public Genre getActGenre() {
        return actGenre;
    }

}
