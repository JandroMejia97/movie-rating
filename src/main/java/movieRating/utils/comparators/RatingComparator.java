package main.java.movieRating.utils.comparators;

import main.java.movieRating.models.Rating;

import java.util.Comparator;

public class RatingComparator implements Comparator<Rating> {

    @Override
    public int compare(Rating o1, Rating o2) {
        return Double.compare(o1.getRating(), o2.getRating());
    }
}
