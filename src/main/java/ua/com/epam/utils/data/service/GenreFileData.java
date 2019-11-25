package ua.com.epam.utils.data.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import ua.com.epam.entity.exception.FileIsEmptyException;
import ua.com.epam.entity.genre.Genre;
import ua.com.epam.utils.data.GenreData;
import ua.com.epam.utils.helpers.LocalDateAdapter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static ua.com.epam.utils.JsonKeys.*;

public class GenreFileData implements GenreData {

    private static Logger log = Logger.getLogger(GenreFileData.class);

    private String filePath = "src/test/resources/test-data/genres.txt";
    private Gson g = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();

    @Override
    public Genre getRandomGenre() {
        log.info("Try to find one random Gener...\n");

        List<Genre> genres = new ArrayList<>();

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            genres = lines.map(s -> g.fromJson(s, Genre.class)).collect(Collectors.toList());
            if (genres.isEmpty()) {
                log.error("File by path " + filePath + " is empty!");
                throw new FileIsEmptyException();
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        Genre genre = genres.get(new Random().nextInt(genres.size()));
        log.info("Author with authorId = '" + genre.getGenreId() + "' was found!");

        return genre;
    }

    @Override
    public List<Genre> getDefaultGenres() {
        log.info("Try to find first 5 genres...\n");

        List<Genre> genres = new ArrayList<>();

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            genres = lines.map(s -> g.fromJson(s, Genre.class)).collect(Collectors.toList());
            if (genres.isEmpty()) {
                log.error("File by path " + filePath + " is empty!");
                throw new FileIsEmptyException();
            }

            if (genres.size() < 5) {
                log.warn("There are only " + genres.size() + " genre found!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        genres = sort(genres, GENRE_ID, ASCENDING, 5);
        log.info(genres.size() + " authors found!");

        return genres;
    }

    @Override
    public List<Genre> getSortedGenres(String keyToSortBy, String order, int... count) {
        int limit = count.length == 0 ? 5 : count[0];

        log.info("Try to find first " + limit + " genres sorted by '" + keyToSortBy + "' in " + order + " order...");

        List<Genre> genres = new ArrayList<>();

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            genres = lines.map(s -> g.fromJson(s, Genre.class)).collect(Collectors.toList());

            if (genres.isEmpty()) {
                log.error("File by path " + filePath + " is empty!");
                throw new FileIsEmptyException();
            }

            if (genres.size() < limit) {
                log.warn("There are only " + genres.size() + " genres found!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        genres = sort(genres, keyToSortBy, order, limit);
        log.info("Were found + " + genres.size() + " sorted by '" + keyToSortBy + "' in " + order + " order!");

        return genres;
    }

    private List<Genre> sort(List<Genre> genresToSort, String keyToSort, String order, int limit) {
        Map<Object, Genre> sortedAuthors = new TreeMap<>();

        if (order.equals(DESCENDING)) {
            sortedAuthors = new TreeMap<>(Collections.reverseOrder());
        }

        String[] keys = keyToSort.split("\\.");
        int len = keys.length;

        for (Genre genre : genresToSort) {
            Object objToGetFrom = genre;
            Class clazz = genre.getClass();

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
                    sortedAuthors.put(field.get(objToGetFrom), genre);
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
