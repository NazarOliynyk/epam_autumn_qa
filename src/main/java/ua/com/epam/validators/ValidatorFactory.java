package ua.com.epam.validators;

public class ValidatorFactory {

    public AuthorValidator authorValidator(){
        return new AuthorValidator();
    }
    public BookValidator bookValidator(){

        return new BookValidator();
    }
    public GenreValidator genreValidator(){

        return new GenreValidator();
    }
}
