package main.java.movieRating.utils.interfaces;

import java.io.IOException;
import java.util.List;

public interface CSVFileReader<T> {

    /**
     * Lee los datos provenientes de un archivo CSV separado por comas.
     */
    void readData() throws IOException;

    /**
     * Crea una instancia de T.
     * @param args Arreglo con los argumentos necesarios para instanciar
     * un objeto de tipo T.
     * @return Una nueva instancia de T.
     */
    T createItem(String[] args);

    /**
     * Retorna la lista de elementos leídos del archivo.
     * @return Lista de elementos de tipo T.
     */
    List<T> getItems() throws IOException;
}
