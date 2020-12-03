package main.java.movieRating.utils.clases;

import main.java.movieRating.utils.interfaces.CSVFileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public abstract class AbstractCSVFileReader<T> implements CSVFileReader<T> {
    private List<T> items = null;
    private String filepath;
    private long fileLength;
    private final boolean hasColumnNames;

    public class CSVFileReaderEvent {
        private AbstractCSVFileReader csvFileReader;
        private int currentPercentage;

        public CSVFileReaderEvent(AbstractCSVFileReader csvFileReader, int currentPercentage) {
            this.csvFileReader = csvFileReader;
            this.currentPercentage = currentPercentage;
        }

        public AbstractCSVFileReader getCsvFileReader() {
            return csvFileReader;
        }

        public void setCsvFileReader(AbstractCSVFileReader csvFileReader) {
            this.csvFileReader = csvFileReader;
        }

        public int getCurrentPercentage() {
            return currentPercentage;
        }

        public void setCurrentPercentage(int currentPercentage) {
            this.currentPercentage = currentPercentage;
        }
    }

    private static final CSVFileReaderObservable OBSERVABLE;

    static {
        OBSERVABLE = new CSVFileReaderObservable();
    }

    public static Observable getObservable() {
        return OBSERVABLE;
    }

    /**
     * Constructor
     * @param filepath Ruta al archivo CSV a leer.
     * @param hasColumnNames Indica si en la primer línea del archivo se encuentra el
     * nombre de las columnas.
     */
    public AbstractCSVFileReader(String filepath, boolean hasColumnNames) {
        this.filepath = filepath;
        this.hasColumnNames = hasColumnNames;
    }

    public void readData() throws IOException {
        items = new ArrayList<T>();
        String cvsSplitBy = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
        URL fileUrl = getClass().getResource(filepath);
        URLConnection urlConnection = fileUrl.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        long bytesRead, currentBytesRead = 0;
        fileLength = urlConnection.getContentLengthLong();
        double percentage = ((double) 1 / fileLength) * 100;
        String line;
        CSVFileReaderEvent event;
        while ((line = br.readLine()) != null) {
            if (currentBytesRead == 0 && hasColumnNames) {
                currentBytesRead += line.length();
                line = br.readLine();
            }
            bytesRead = currentBytesRead;
            String[] args = line.split(cvsSplitBy);

            T item = createItem(args);
            items.add(item);

            // Cuenta la cantidad de bytes leídos.
            currentBytesRead += line.length();
            int roundedBytesRead = (int) Math.round(percentage * bytesRead);
            int roundedCurrentBytesRead = (int) Math.round(percentage * currentBytesRead);
            if (roundedCurrentBytesRead > roundedBytesRead)
                emitAdvance(roundedCurrentBytesRead);
        }
        emitAdvance(100);
        br.close();
    }

    private void emitAdvance(int currentPercentage) {
        OBSERVABLE.setChanged();
        CSVFileReaderEvent event = new CSVFileReaderEvent(this, currentPercentage);
        OBSERVABLE.notifyObservers(event);
    }

    @Override
    public List<T> getItems() throws IOException {
        if (items == null)
            readData();
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public long getFileLength() {
        return fileLength;
    }

    public boolean hasColumnNames() {
        return hasColumnNames;
    }

    public static class CSVFileReaderObservable extends Observable {
        @Override
        public void setChanged() {
            super.setChanged();
        }
    }
}
