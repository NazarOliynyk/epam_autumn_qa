package ua.com.epam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ua.com.epam.core.rest.RestClient;
import ua.com.epam.entity.author.Author;
import ua.com.epam.entity.book.Book;
import ua.com.epam.entity.genre.Genre;
import ua.com.epam.service.BookService;
import ua.com.epam.service.CleanUpService;
import ua.com.epam.service.GenreService;
import ua.com.epam.utils.DataFactory;
import ua.com.epam.utils.helpers.LocalDateAdapter;
import ua.com.epam.service.AuthorService;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static ua.com.epam.config.URI.POST_AUTHOR_SINGLE_OBJ;
import static ua.com.epam.config.URI.POST_GENRE_SINGLE_OBJ;

public class BaseTest {

    private RestClient client = new RestClient();
    private DataFactory testData = new DataFactory();
    private CleanUpService clean = new CleanUpService(client);

    protected AuthorService authorService = new AuthorService();
    protected Author randomeAuthor = testData.authors().getRandomOne();
    private List<Author> authorList = testData.authors().getDefaultAuthors();

    protected BookService bookService = new BookService();
    protected Book randomBook = testData.books().getRandomBook();
    private List<Book> bookList = testData.books().getDefaultBooks();

    protected GenreService genreService = new GenreService();
    protected Genre randomGenre = testData.genres().getRandomGenre();
    private List<Genre> genreList = testData.genres().getDefaultGenres();



     protected void sendAllAuthors(){
        for(Author a : authorList) {
            client.post(POST_AUTHOR_SINGLE_OBJ, a);
        }
    }

    protected void sendAllGenres(){
        for(Genre genre : genreList) {
            client.post(POST_GENRE_SINGLE_OBJ, genre);
        }
    }

    protected void sendAllBooks(){

        for(Book book : bookList) {
            bookService.postSingleBook(book,
                    authorList.get(new Random().nextInt(10)).getAuthorId(),
                    genreList.get(new Random().nextInt(5)).getGenreId());
        }

//        System.out.println("bookList.size(): "+bookList.size());
//        bookService.postSingleBook(bookList.get(0), authorList.get(4).getAuthorId(), genreList.get(1).getGenreId());
//        bookService.postSingleBook(bookList.get(1), authorList.get(9).getAuthorId(), genreList.get(2).getGenreId());
//        bookService.postSingleBook(bookList.get(2), authorList.get(5).getAuthorId(), genreList.get(0).getGenreId());
//        bookService.postSingleBook(bookList.get(3), authorList.get(8).getAuthorId(), genreList.get(3).getGenreId());
//        bookService.postSingleBook(bookList.get(4), authorList.get(0).getAuthorId(), genreList.get(4).getGenreId());
//        bookService.postSingleBook(bookList.get(5), authorList.get(7).getAuthorId(), genreList.get(1).getGenreId());
//        bookService.postSingleBook(bookList.get(6), authorList.get(3).getAuthorId(), genreList.get(0).getGenreId());
//        bookService.postSingleBook(bookList.get(7), authorList.get(1).getAuthorId(), genreList.get(4).getGenreId());
//        bookService.postSingleBook(bookList.get(8), authorList.get(4).getAuthorId(), genreList.get(1).getGenreId());
//        bookService.postSingleBook(bookList.get(9), authorList.get(4).getAuthorId(), genreList.get(1).getGenreId());
//        bookService.postSingleBook(bookList.get(10), authorList.get(9).getAuthorId(), genreList.get(2).getGenreId());
//        bookService.postSingleBook(bookList.get(11), authorList.get(2).getAuthorId(), genreList.get(3).getGenreId());
//        bookService.postSingleBook(bookList.get(12), authorList.get(0).getAuthorId(), genreList.get(0).getGenreId());
//        bookService.postSingleBook(bookList.get(13), authorList.get(3).getAuthorId(), genreList.get(3).getGenreId());
//        bookService.postSingleBook(bookList.get(14), authorList.get(8).getAuthorId(), genreList.get(2).getGenreId());
//        bookService.postSingleBook(bookList.get(15), authorList.get(5).getAuthorId(), genreList.get(3).getGenreId());
//        bookService.postSingleBook(bookList.get(16), authorList.get(7).getAuthorId(), genreList.get(3).getGenreId());
//        bookService.postSingleBook(bookList.get(17), authorList.get(2).getAuthorId(), genreList.get(4).getGenreId());
//        bookService.postSingleBook(bookList.get(18), authorList.get(6).getAuthorId(), genreList.get(0).getGenreId());
//        bookService.postSingleBook(bookList.get(19), authorList.get(1).getAuthorId(), genreList.get(4).getGenreId());
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
         clean.genres();
         clean.books();
    }
}
