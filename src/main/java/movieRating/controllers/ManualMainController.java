package main.java.movieRating.controllers;

import main.java.movieRating.models.Movie;
import main.java.movieRating.models.MovieUserPK;
import main.java.movieRating.models.Rating;
import main.java.movieRating.repository.MovieRepository;
import main.java.movieRating.repository.RatingRepository;
import main.java.movieRating.utils.comparators.MovieRatingQuantityDescComparator;
import main.java.movieRating.utils.enums.OptionType;
import main.java.movieRating.views.manual.MainFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class ManualMainController {
    private CSVFileReaderObserver fileReaderObserver;
    private MainFrame mainFrame;
    private MovieRepository movieRepository;
    private RatingRepository ratingRepository;

    private Set<Integer> usersIdSet = new TreeSet<>();
    private Set<MovieUserPK> ratingIdSet = new HashSet<>();
    private Map<Integer, Movie> movieMap = new TreeMap<>();

    private final String errorReadingMessage = "Ocurrió un error al realizar la lectura.";
    private final String readingMessage = "Se cargarán las películas y sus puntuaciones. Por favor, espere.";
    private final String errorSelectMessage = "Lo sentimos, no hay puntuaciones para la película seleccionada.";

    public ManualMainController() {
        mainFrame = new MainFrame();
        movieRepository = MovieRepository.getInstance();
        ratingRepository = RatingRepository.getInstance();
        fileReaderObserver = new CSVFileReaderObserver(mainFrame.getProgressBar());
        addBtnListener();
    }

    private void addBtnListener() {
        mainFrame.addActionListenerToButton(e -> {
            enableUIWindow();
            JOptionPane.showMessageDialog(mainFrame, readingMessage);
            try {
                loadMovieData();
                loadRatingData();
            } catch (IOException error) {
                JOptionPane.showMessageDialog(mainFrame, errorReadingMessage + "\n" + error.getMessage());
            }
            addSelectListener();
            addSelectRowListener();
            setCantLabels();
            paintData(OptionType.TODOS.getValue());
            mainFrame.setCursor(Cursor.getDefaultCursor());
        });
    }

    private void addSelectRowListener() {
        JTable tbMovies = mainFrame.getTable();
        tbMovies.getSelectionModel().addListSelectionListener(
                event -> {
                    if (event.getValueIsAdjusting()) {
                        int viewRow = tbMovies.getSelectedRow();
                        if (viewRow < 0)
                            paintData(OptionType.TODOS.getValue());
                        else {
                            int modelRow = tbMovies.convertRowIndexToModel(viewRow);
                            Integer selectedMovieId = Integer.parseInt(
                                    (String) tbMovies.getModel().getValueAt(modelRow, 1)
                            );
                            Movie selectedMovie = movieMap.get(selectedMovieId);
                            if (selectedMovie.getRatingQuantity() > 0)
                                mainFrame.setChart(selectedMovie.getTitle(), getRatingsByMovie(selectedMovie));
                            else
                                JOptionPane.showMessageDialog(mainFrame, errorSelectMessage, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
        );
    }

    private void addSelectListener() {
        mainFrame.addItemListenerToComboBox(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                OptionType option = (OptionType) e.getItem();
                paintData(option.getValue());
            }
        });
    }

    private void loadMovieData() throws IOException {
        movieRepository.addMovieCSVFileReaderObserver(fileReaderObserver);
        for (Movie movie : movieRepository.findAll())
            movieMap.put(movie.getMovieId(), movie);
        movieRepository.deleteMovieCSVFileReaderObserver(fileReaderObserver);
    }

    private void loadRatingData() throws IOException {
        ratingRepository.addRatingCSVFileReaderObserver(fileReaderObserver);
        for (Rating rating : ratingRepository.findAll()) {
            ratingIdSet.add(rating.getId());
            usersIdSet.add(rating.getUserId());
            movieMap.get(rating.getMovieId()).addRating(rating);
        }
        ratingRepository.deleteRatingCSVFileReaderObserver(fileReaderObserver);
    }

    private void enableUIWindow() {
        mainFrame.disableButton();
        mainFrame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        mainFrame.enableComboBox();
    }

    private void setCantLabels() {
        mainFrame.setCantText(mainFrame.getLblMovies(), Integer.toString(movieMap.size()));
        mainFrame.setCantText(mainFrame.getLblVotes(), Integer.toString(ratingIdSet.size()));
        mainFrame.setCantText(mainFrame.getLblUsers(), Integer.toString(usersIdSet.size()));
    }

    private double[] getAllRatings(int quantity) {
        double[] ratings = new double[quantity == OptionType.TODOS.getValue() ? ratingIdSet.size() : quantity];
        int i = 0;
        Iterator<Movie> iterator = movieMap.values().iterator();
        while (iterator.hasNext() && i < quantity)
            for (Rating rating : iterator.next().getRatings()) {
                ratings[i++] = rating.getRating();
                if (i >= quantity) break;
            }
        return ratings;
    }

    private double[] getRatingsByMovie(Movie selectedMovie) {
        List<Rating> ratings = selectedMovie.getRatings();
        double[] ratingValues = new double[ratings.size()];
        int i = 0;
        Iterator<Rating> iterator = ratings.iterator();
        while (iterator.hasNext())
            ratingValues[i++] = iterator.next().getRating();
        return ratingValues;
    }

    private void paintData(int quantity) {
        paintDataOnTheChart(quantity);
        paintDataOnTheTable(quantity);
    }

    private void paintDataOnTheChart(int quantity) {
        mainFrame.setChart(getAllRatings(quantity));
    }

    private void paintDataOnTheTable(int quantity) {
        JTable tbMovies = mainFrame.getTable();
        DefaultTableModel tbModel = (DefaultTableModel) tbMovies.getModel();;
        tbModel.getDataVector().removeAllElements();
        final Map<Integer, Movie> sortedByRatingQuantity = movieMap.entrySet()
                .stream()
                .sorted((e1, e2) -> (new MovieRatingQuantityDescComparator().compare(e1.getValue(), e2.getValue())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        Iterator<Movie> iterator = sortedByRatingQuantity.values().iterator();
        int i = 0;
        while (iterator.hasNext() && i < quantity) {
            Movie movie = iterator.next();
            String[] data = {
                    Integer.toString(++i),
                    Integer.toString(movie.getMovieId()),
                    movie.toString(),
                    Integer.toString(movie.getRatingQuantity()),
                    String.format("%.2f", movie.getAverageRating())
            };
            tbModel.addRow(data);
        }
        tbMovies.setModel(tbModel);
    }

    public static void main(String[] args) {
        new ManualMainController();
    }
}
