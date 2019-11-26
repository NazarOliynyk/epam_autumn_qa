package ua.com.epam.validators;

public class ValidatorFactory {

    public AuthorValidator authorValidator(){
        return new AuthorValidator();
    }
    BookValidator bookValidator(){
        return new BookValidator();
    }
    GenreValidator genreValidator(){
        return new GenreValidator();
    }
}
