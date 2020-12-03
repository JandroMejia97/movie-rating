package main.java.movieRating.utils.comparators;

import main.java.movieRating.models.Rating;

import java.util.Comparator;

public class UserIdComparator implements Comparator<Rating> {
    @Override
    public int compare(Rating o1, Rating o2) {
        return o1.getUserId() - o2.getUserId();
    }
}
