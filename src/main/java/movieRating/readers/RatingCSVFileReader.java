package main.java.movieRating.readers;

import main.java.movieRating.models.Rating;
import main.java.movieRating.utils.clases.AbstractCSVFileReader;

import java.io.IOException;

public class RatingCSVFileReader extends AbstractCSVFileReader<Rating> {

    public RatingCSVFileReader(String filepath, boolean hasColumnNames) {
        super(filepath, hasColumnNames);
    }

    @Override
    public Rating createItem(String[] args) {
        return new Rating(args);
    }

    public static void main(String[] args) {
        String filepath = "/data/ratings.csv";
        RatingCSVFileReader reader = new RatingCSVFileReader(filepath, true);
        try {
            for (Rating m : reader.getItems())
                System.out.println(m);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
