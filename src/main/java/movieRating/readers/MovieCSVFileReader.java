package main.java.movieRating.readers;

import main.java.movieRating.models.Movie;
import main.java.movieRating.utils.clases.AbstractCSVFileReader;

import java.io.IOException;

public class MovieCSVFileReader extends AbstractCSVFileReader<Movie> {

    public MovieCSVFileReader(String filepath, boolean hasColumnNames) {
        super(filepath, hasColumnNames);
    }

    @Override
    public Movie createItem(String[] args) {
        return new Movie(args);
    }

    public static void main(String[] args) {
        String filepath = "/data/movies.csv";
        MovieCSVFileReader reader = new MovieCSVFileReader(filepath, true);
        try {
            for (Movie m: reader.getItems()) {
                System.out.println(m);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
