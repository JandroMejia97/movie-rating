package main.java.movieRating.repository;

import main.java.movieRating.controllers.CSVFileReaderObserver;
import main.java.movieRating.models.Movie;
import main.java.movieRating.readers.MovieCSVFileReader;
import main.java.movieRating.utils.interfaces.GenericRepository;

import java.io.IOException;
import java.util.List;

public class MovieRepository implements GenericRepository<Movie> {
    private MovieCSVFileReader reader;
    private String filename = "/data/movies.csv";
    public static MovieRepository INSTANCE;

    private MovieRepository() {
        reader = new MovieCSVFileReader(filename, true);
    }

    public static MovieRepository getInstance() {
        if (INSTANCE == null)
            INSTANCE = new MovieRepository();
        return INSTANCE;
    }

    public void addMovieCSVFileReaderObserver(CSVFileReaderObserver o) {
        MovieCSVFileReader.getObservable().addObserver(o);
    }

    public void deleteMovieCSVFileReaderObserver(CSVFileReaderObserver o) {
        MovieCSVFileReader.getObservable().deleteObserver(o);
    }

    @Override
    public Movie create(Movie item) {
        return null;
    }

    @Override
    public void delete(Movie item) {

    }

    @Override
    public Movie find(Movie item) throws IOException {
        for (Movie movie: reader.getItems())
            if (movie.equals(item))
                return movie;
        return null;
    }

    @Override
    public Movie findById(int itemId) throws IOException {
        for (Movie movie: reader.getItems())
            if (movie.getMovieId() == itemId)
                return movie;
        return null;
    }

    @Override
    public Movie update(Movie item) {
        return null;
    }

    /**
     * Obtiene todos las películas.
     * @return Lista de películas.
     */
    @Override
    public List<Movie> findAll() throws IOException {
        return reader.getItems();
    }

}
