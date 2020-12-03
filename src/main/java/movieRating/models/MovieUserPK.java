package main.java.movieRating.models;

import java.util.Objects;

public class MovieUserPK {
    private int movieId;
    private int userId;

    public MovieUserPK() {
    }

    public MovieUserPK(int userId, int movieId) {
        this.movieId = movieId;
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieUserPK)) return false;
        MovieUserPK that = (MovieUserPK) o;
        return movieId == that.movieId &&
                userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, userId);
    }

    @Override
    public String toString() {
        return "MovieUserPK{" +
                "movieId=" + movieId +
                ", userId=" + userId +
                '}';
    }
}
