package main.java.movieRating.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Movie implements Comparable<Movie> {
    private int movieId;
    private String title;
    private String genres;
    private List<Rating> ratings;

    public Movie() {
        ratings = new ArrayList<Rating>();
    }

    public Movie(String[] args) {
        this();
        movieId = Integer.parseInt(args[0]);
        title = args[1].replace("\"", "");
        genres = args[2].replace("\"", "");
    }

    public Movie(int movieId, String title, String genres) {
        this();
        this.movieId = movieId;
        this.title = title;
        this.genres = genres;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    public void removeRating(Rating rating) {
        ratings.remove(rating);
    }

    /**
     * Retorna la cantidad de calificaciones que ha recibido
     * la película.
     * @return Cantidad de calificaciones.
     */
    public int getRatingQuantity() {
        return ratings.size();
    }

    /**
     * Retorna la puntuación promedio que ha recibido la película
     * @return Puntuación promedio.
     */
    public double getAverageRating() {
        if (getRatingQuantity() <= 0)
            return 0;
        double accumulator = 0;
        for (Rating rating: ratings)
            accumulator += rating.getRating();
        return accumulator / getRatingQuantity();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        return movieId == ((Movie) o).movieId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId);
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public int compareTo(Movie o) {
        return movieId - o.movieId;
    }
}
