package main.java.movieRating.utils.interfaces;

import java.io.IOException;

public interface GenericRepository<T>{
    T create(T item);

    void delete(T item);

    T find(T item) throws IOException;

    T findById(int itemId) throws IOException;

    T update(T item);

    Iterable<T> findAll() throws IOException;
}
