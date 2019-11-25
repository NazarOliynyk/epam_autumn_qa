package ua.com.epam.utils.data;

import ua.com.epam.entity.book.Book;

import java.util.List;

public interface BookData {

    Book getRandomBook();

    List<Book> getDefaultBooks();

    List<Book> getSortedBooks(String keyToSortBy, String order, int... count);
}
