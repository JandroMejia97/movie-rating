package main.java.movieRating.models;

import java.util.Objects;

public class Rating {
    private MovieUserPK id;
    private Movie movie;
    private double rating;
    private int timestamp;

    public Rating() { }

    public Rating(String[] args) {
        id = new MovieUserPK(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        rating = Float.parseFloat(args[2]);
        timestamp = Integer.parseInt(args[3]);
    }

    public Rating(int userId, int movieId, float rating, int timestamp) {
        id = new MovieUserPK(movieId, userId);
        this.rating = rating;
        this.timestamp = timestamp;
    }

    public Rating(int userId, Movie movie, float rating, int timestamp) {
        this(userId, movie.getMovieId(), rating, timestamp);
        this.movie = movie;
    }

    public MovieUserPK getId() {
        return id;
    }

    public void setId(MovieUserPK id) {
        this.id = id;
    }

    public int getUserId() {
        return id.getUserId();
    }

    public void setUserId(int userId) {
        id.setUserId(userId);
    }

    public int getMovieId() {
        return id.getMovieId();
    }

    public void setMovieId(int movieId) {
        id.setMovieId(movieId);
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Indica si 2 puntuaciones son iguales.
     * * Un usuario solo puede realizar una puntuación por película.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rating)) return false;
        return id.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Rating{" +
                ", id=" + id.toString() +
                ", rating=" + rating +
                '}';
    }
}
