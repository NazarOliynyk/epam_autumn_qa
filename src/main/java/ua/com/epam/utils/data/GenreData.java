package ua.com.epam.utils.data;

import ua.com.epam.entity.genre.Genre;

import java.util.List;

public interface GenreData {

    Genre getRandomGenre();

    List<Genre> getDefaultGenres();

    List<Genre> getSortedGenres(String keyToSortBy, String order, int... count);
}
