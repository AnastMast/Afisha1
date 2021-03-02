package ru.netology.manager.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.AfishaManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AfishaManagerTest {
    private AfishaManager manager;
    private Movie first = new Movie(1, "Movie.one", "genre.one");
    private Movie second = new Movie(2, "Movie.two", "genre.two");
    private Movie third = new Movie(3, "Movie.three", "genre.three");
    private Movie fourth = new Movie(4, "Movie.four", "genre.four");
    private Movie fifth = new Movie(5, "Movie.five", "genre.five");
    private Movie sixth = new Movie(6, "Movie.six", "genre.six");
    private Movie seventh = new Movie(7, "Movie.seven", "genre.seven");
    private Movie eighth = new Movie(8, "Movie.eight", "genre.eight");
    private Movie ninth = new Movie(9, "Movie.nine", "genre.nine");
    private Movie tenth = new Movie(10, "Movie.ten", "genre.ten");

    void addMovies() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

    }

    @Test
    void shouldAddNoFilm() {
        manager = new AfishaManager();
        List<Movie> expected = new ArrayList<>();
        List<Movie> actual = manager.getItems();
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetAllButNewestFirst() {
        manager = new AfishaManager(10);
        addMovies();
        List<Movie> actual = manager.getNewest();
        List<Movie> expected = Arrays.asList(tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first);
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetAFewNewestFirst() {
        manager = new AfishaManager(4);
        addMovies();
        List<Movie> actual = manager.getNewest();
        List<Movie> expected = Arrays.asList(tenth, ninth, eighth, seventh);
        assertEquals(expected, actual);
    }
}
