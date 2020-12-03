package main.java.movieRating.repository;

import main.java.movieRating.controllers.CSVFileReaderObserver;
import main.java.movieRating.models.Rating;
import main.java.movieRating.readers.RatingCSVFileReader;
import main.java.movieRating.utils.interfaces.GenericRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RatingRepository implements GenericRepository<Rating> {
    private RatingCSVFileReader reader;
    private String filename = "/data/ratings.csv";
    public static RatingRepository INSTANCE;

    private RatingRepository() {
        reader = new RatingCSVFileReader(filename, true);
    }

    public static RatingRepository getInstance() {
        if (INSTANCE == null)
            INSTANCE = new RatingRepository();
        return INSTANCE;
    }

    public void addRatingCSVFileReaderObserver(CSVFileReaderObserver o) {
        RatingCSVFileReader.getObservable().addObserver(o);
    }

    public void deleteRatingCSVFileReaderObserver(CSVFileReaderObserver o) {
        RatingCSVFileReader.getObservable().deleteObserver(o);
    }

    @Override
    public Rating create(Rating item) {
        return null;
    }

    @Override
    public void delete(Rating item) {

    }

    @Override
    public Rating find(Rating item) throws IOException {
        for (Rating rating: reader.getItems())
            if (rating.equals(item))
                return rating;
        return null;
    }

    @Override
    public Rating findById(int itemId) {
        return null;
    }

    @Override
    public Rating update(Rating item) {
        return item;
    }

    /**
     * Obtiene todos los ratings.
     * @return Lista de rantings.
     */
    @Override
    public List<Rating> findAll() throws IOException {
        return reader.getItems();
    }

    /**
     * Obtiene el primer rating que coincide con la marca de tiempo
     * pasada como parámetro.
     * @param timestamp Marca de tiempo del rating a buscar.
     * @return Primer rating que coincide con la marca de tiempo, null
     * en caso contrario.
     */
    public Rating findByTimestamp(int timestamp) throws IOException {
        for (Rating rating: reader.getItems())
            if (rating.getTimestamp() == timestamp)
                return rating;
        return null;
    }

    /**
     * Obtiene todos los ratings hechos por un usuario.
     *
     * @param userId ID del usuario.
     * @return Rantings hechos por el usuario.
     */
    public List<Rating> findByUserId(int userId) throws IOException {
        List<Rating> ratingsByUser = new ArrayList<Rating>();
        for (Rating rating: reader.getItems())
            if (rating.getUserId() == userId)
                ratingsByUser.add(rating);
        return ratingsByUser;
    }

    /**
     * Obtiene todos los ratings de una película.
     *
     * @param movieId ID de la película.
     * @return Rantings que recibió la película.
     */
    public List<Rating> findByMovieId(int movieId) throws IOException {
        List<Rating> ratingsByMovie = new ArrayList<Rating>();
        for (Rating rating: reader.getItems())
            if (rating.getMovieId() == movieId)
                ratingsByMovie.add(rating);
        return ratingsByMovie;
    }
}
