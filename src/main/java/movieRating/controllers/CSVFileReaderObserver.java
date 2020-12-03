package main.java.movieRating.controllers;

import main.java.movieRating.utils.clases.AbstractCSVFileReader.CSVFileReaderEvent;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class CSVFileReaderObserver implements Observer {
    private JProgressBar progressBar;

    public CSVFileReaderObserver(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof CSVFileReaderEvent) {
            CSVFileReaderEvent event = (CSVFileReaderEvent) arg;
            progressBar.setValue(event.getCurrentPercentage());
        }
    }
}
