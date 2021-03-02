package ru.netology.manager;

import ru.netology.domain.Movie;

import java.util.ArrayList;
import java.util.List;

public class AfishaManager {
    private List<Movie> items = new ArrayList<>();
    private final int movieCount;

    public AfishaManager(int movieCount) {
        this.movieCount = movieCount;
    }

    public AfishaManager() {
        this(10);
    }

    public List<Movie> getNewest() {
        List<Movie> result = new ArrayList<>();
        int itemsSize = items.size();
        int resultListSize = Math.min(itemsSize, movieCount);
        for (int i = itemsSize - 1; i >= itemsSize - resultListSize; i--) {
            result.add(items.get(i));
        }
        return result;
    }

    public List<Movie> getItems() {
        return items;
    }

    public void add(Movie item) {
        items.add(item);
    }
}
