package ua.com.epam.utils.data.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import ua.com.epam.entity.book.Book;
import ua.com.epam.entity.exception.FileIsEmptyException;
import ua.com.epam.utils.data.BookData;
import ua.com.epam.utils.helpers.LocalDateAdapter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ua.com.epam.utils.JsonKeys.ASCENDING;
import static ua.com.epam.utils.JsonKeys.BOOK_ID;
import static ua.com.epam.utils.JsonKeys.DESCENDING;

public class BookFileData implements BookData {


    private static Logger log = Logger.getLogger(BookFileData.class);

    private String filePath = "src/test/resources/test-data/books.txt";
    private Gson g = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();

    @Override
    public Book getRandomBook() {
        log.info("Try to find one random Book...\n");

        List<Book> books = new ArrayList<>();

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            books = lines.map(s -> g.fromJson(s, Book.class)).collect(Collectors.toList());
            if (books.isEmpty()) {
                log.error("File by path " + filePath + " is empty!");
                throw new FileIsEmptyException();
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        Book book = books.get(new Random().nextInt(books.size()));
        log.info("Book with bookId = '" + book.getBookId() + "' was found!");

        return book;
    }

    @Override
    public List<Book> getDefaultBooks() {
        log.info("Try to find first 20 books...\n");

        List<Book> books = new ArrayList<>();

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            books = lines.map(s -> g.fromJson(s, Book.class)).collect(Collectors.toList());
            if (books.isEmpty()) {
                log.error("File by path " + filePath + " is empty!");
                throw new FileIsEmptyException();
            }

            if (books.size() < 20) {
                log.warn("There are only " + books.size() + " books found!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        books = sort(books, BOOK_ID, ASCENDING, 20);
        log.info(books.size() + " authors found!");

        return books;
    }

    @Override
    public List<Book> getSortedBooks(String keyToSortBy, String order, int... count) {
        int limit = count.length == 0 ? 5 : count[0];

        log.info("Try to find first " + limit + " books sorted by '" + keyToSortBy + "' in " + order + " order...");

        List<Book> books = new ArrayList<>();

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            books = lines.map(s -> g.fromJson(s, Book.class)).collect(Collectors.toList());

            if (books.isEmpty()) {
                log.error("File by path " + filePath + " is empty!");
                throw new FileIsEmptyException();
            }

            if (books.size() < limit) {
                log.warn("There are only " + books.size() + " genres found!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        books = sort(books, keyToSortBy, order, limit);
        log.info("Were found + " + books.size() + " sorted by '" + keyToSortBy + "' in " + order + " order!");

        return books;
    }

    private List<Book> sort(List<Book> booksToSort, String keyToSort, String order, int limit) {
        Map<Object, Book> sortedAuthors = new TreeMap<>();

        if (order.equals(DESCENDING)) {
            sortedAuthors = new TreeMap<>(Collections.reverseOrder());
        }

        String[] keys = keyToSort.split("\\.");
        int len = keys.length;

        for (Book book : booksToSort) {
            Object objToGetFrom = book;
            Class clazz = book.getClass();

            try {
                Field field = null;
                for (int i = 0; i < len; i++) {
                    field = clazz.getDeclaredField(keys[i]);
                    field.setAccessible(true);
                    clazz = field.getType();
                    if (i < len - 1) {
                        objToGetFrom = field.get(objToGetFrom);
                    }
                    field.setAccessible(false);
                }

                if (field != null) {
                    field.setAccessible(true);
                    sortedAuthors.put(field.get(objToGetFrom), book);
                    field.setAccessible(false);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return sortedAuthors.values()
                .stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

}
