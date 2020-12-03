package main.java.movieRating.utils.comparators;

import main.java.movieRating.models.Movie;

import java.util.Comparator;

public class MovieRatingQuantityAscComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getRatingQuantity() - o2.getRatingQuantity();
    }
}
