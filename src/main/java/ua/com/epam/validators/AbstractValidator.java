package ua.com.epam.validators;

import com.google.gson.reflect.TypeToken;
import org.testng.asserts.SoftAssert;
import ua.com.epam.entity.author.Author;
import ua.com.epam.entity.book.Book;
import ua.com.epam.entity.genre.Genre;
import ua.com.epam.service.AuthorService;
import ua.com.epam.service.BookService;
import ua.com.epam.service.GenreService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.com.epam.utils.helpers.LocalDateAdapter;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

abstract class AbstractValidator {

    AuthorService authorService = new AuthorService();
    BookService bookService = new BookService();
    GenreService genreService = new GenreService();

    Type type = new TypeToken<List<Author>>(){}.getType();

    Gson g = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();

    Author actAuthor;
    Book actBook;
    Genre actGenre;

    SoftAssert softAssert = new SoftAssert();

}
