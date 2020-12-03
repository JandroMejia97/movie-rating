package main.java.movieRating.utils.comparators;

import main.java.movieRating.models.Movie;

import java.util.Comparator;

public class MovieRatingQuantityDescComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return new MovieRatingQuantityAscComparator().compare(o2, o1);
    }
}
