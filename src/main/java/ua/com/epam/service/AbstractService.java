package ua.com.epam.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ua.com.epam.core.rest.RestClient;
import ua.com.epam.entity.author.Author;
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

    int statusCode;

    Author actAuthor;

    public Gson getG() {
        return g;
    }

    public RestClient getClient() {
        return client;
    }

    public Type getType() {
        return type;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Author getActAuthor() {
        return actAuthor;
    }
}
