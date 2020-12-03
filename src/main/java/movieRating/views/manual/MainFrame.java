package main.java.movieRating.views.manual;

import main.java.movieRating.views.MainWindow;
import org.jfree.ui.tabbedui.VerticalLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainFrame extends JFrame  {
    private JPanel jpMain;
    private JPanel labels;
    private LabelPanel lblUsers;
    private LabelPanel lblMovies;
    private LabelPanel lblVotes;
    private HeaderPanel headerPanel;
    private SelectorPanel selectorPanel;
    private TablePanel tablePanel;
    private ChartPanel chartPanel;
    private final String windowTitle = "Control de películas";

    public MainFrame() {
        super();
        setTitle(windowTitle);
        initLookAndFeel();
        initComponents();
        setComponents();
        addComponents();
    }

    public static void main(String[] args) {
        JFrame frame = new MainFrame();
    }

    private void initComponents() {
        jpMain = new JPanel();
        labels = new JPanel();

        lblUsers = new LabelPanel("Usuarios");
        lblMovies = new LabelPanel("Películas");
        lblVotes = new LabelPanel("Cant. de Votos");

        headerPanel = new HeaderPanel();
        selectorPanel = new SelectorPanel();
        tablePanel = new TablePanel();
        chartPanel = new ChartPanel();
    }

    protected void setComponents() {
        labels.add(lblMovies);
        labels.add(lblVotes);
        labels.add(lblUsers);

        jpMain.setMaximumSize(new Dimension(600, 650));
        jpMain.setMinimumSize(new Dimension(600, 600));
        jpMain.setPreferredSize(new Dimension(600, 650));
        jpMain.setLayout(new VerticalLayout());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setResizable(false);
    }

    private void addComponents() {
        jpMain.add(headerPanel);
        jpMain.add(labels);
        jpMain.add(selectorPanel);
        jpMain.add(tablePanel);
        jpMain.add(chartPanel);
        setContentPane(jpMain);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void initLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public LabelPanel getLblUsers() {
        return lblUsers;
    }

    public LabelPanel getLblMovies() {
        return lblMovies;
    }

    public LabelPanel getLblVotes() {
        return lblVotes;
    }

    public void setCantText(LabelPanel lbl, String cantText) {
        lbl.setLblCantText(cantText);
    }

    public JProgressBar getProgressBar() {
        return headerPanel.getPbProgreso();
    }

    public void addActionListenerToButton(ActionListener actionListener) {
        headerPanel.btnProcesarAddActionListener(actionListener);
    }

    public void addItemListenerToComboBox(ItemListener itemListener) {
        selectorPanel.cbSelectorAddItemListener(itemListener);
    }

    public void disableButton() {
        headerPanel.getBtnProcesar().setEnabled(false);
    }

    public void enableComboBox() {
        selectorPanel.getCbSelector().setEnabled(true);
    }

    public void setCursor(Cursor cursor) {
        getContentPane().setCursor(cursor);
    }

    public JTable getTable() {
        return tablePanel.getTbMovies();
    }

    public void setChart(String chartTitle, double[] vals) {
        chartPanel.setChart(chartTitle, vals);
    }

    public void setChart(double[] vals) {
        chartPanel.setChart(vals);
    }
}
