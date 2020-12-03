package main.java.movieRating.views.manual;

import main.java.movieRating.utils.clases.PanelComponent;

import javax.swing.*;
import java.awt.*;

public class LabelsPanel extends PanelComponent {
    private LabelPanel users;
    private LabelPanel movies;
    private LabelPanel votes;

    public LabelsPanel() {
        initComponents();
        addComponents();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("LabelsPanel");
        frame.setContentPane(new LabelsPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    protected void addComponents() {
        setLayout(new GridBagLayout());
        add(users);
        add(movies);
        add(votes);
    }

    @Override
    protected void initComponents() {
        users = new LabelPanel("Usuarios");
        movies = new LabelPanel("Películas");
        votes = new LabelPanel("Cant. de votos");
    }

    @Override
    protected void setComponents() { }

    public String getUsersCantText() {
        return users.getLblCantText();
    }

    public void setUsersCantText(String usersCantText) {
        users.setLblCantText(usersCantText);
    }

    public String getMoviesCantText() {
        return movies.getLblCantText();
    }

    public void setMoviesCantText(String moviesCantText) {
        movies.setLblCantText(moviesCantText);
    }

    public String getVotesCantText() {
        return votes.getLblCantText();
    }

    public void setVotesCantText(String votesCantText) {
        votes.setLblCantText(votesCantText);
    }
}
