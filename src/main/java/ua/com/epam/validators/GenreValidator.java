package ua.com.epam.validators;

import org.testng.Assert;
import ua.com.epam.entity.Response;
import ua.com.epam.entity.author.Author;
import ua.com.epam.entity.book.Book;
import ua.com.epam.entity.genre.Genre;

public class GenreValidator extends AbstractValidator{

    public void getGenre(Genre genre) {

        Response response = genreService.getGenre(genre.getGenreId());
        // 200 - OK
        Assert.assertEquals(response.getStatusCode(), 200);
        actGenre = g.fromJson(response.getBody(), Genre.class);
        Assert.assertEquals(actGenre, genre,
                "Actual genre id is not equal to expected. ");
    }

    public void deleteGenre(Genre genre) {

        long genreId = genre.getGenreId();

        // check if the randomGenre is present in the DB-
        Response responseBeforeDelete =
                genreService.getGenre(genreId);
        // 200 - OK
        Assert.assertEquals(responseBeforeDelete.getStatusCode(), 200);

        // deleting the random author-
        Response responseOnDeleteAction =
                genreService.deleteGenre(genreId);
        // 204 - no content
        Assert.assertEquals(responseOnDeleteAction.getStatusCode(), 204);

        // ascertain that the randomAuthor is not present in the DB-
        Response responseAfterDelete =
                genreService.getGenre(genreId);
        // 404 - not found
        Assert.assertEquals(responseAfterDelete.getStatusCode(), 404);
    }

    public void getGenreByBookId(Book book,
                                 Author author,
                                 Genre genre){
        Response responsePostBook =
                bookService.postSingleBook(book,
                        author.getAuthorId(),
                        genre.getGenreId());
        // 201 - created
        Assert.assertEquals(responsePostBook.getStatusCode(), 201);

        Response responseGetGenre = genreService.getGenreByBookId(book.getBookId());
        // 200 - OK
        Assert.assertEquals(responseGetGenre.getStatusCode(), 200);
        actGenre = g.fromJson(responseGetGenre.getBody(), Genre.class);
        Assert.assertEquals(actGenre, genre);
    }
}
