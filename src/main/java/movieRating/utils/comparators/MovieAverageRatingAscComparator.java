package main.java.movieRating.utils.comparators;

import main.java.movieRating.models.Movie;

import java.util.Comparator;

public class MovieAverageRatingAscComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return Double.compare(o1.getAverageRating(), o2.getAverageRating());
    }
}
