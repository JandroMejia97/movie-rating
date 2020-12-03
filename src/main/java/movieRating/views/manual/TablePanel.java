package main.java.movieRating.views.manual;

import main.java.movieRating.utils.clases.PanelComponent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.EventObject;

public class TablePanel extends PanelComponent {
    private JScrollPane jsTbPane;
    private JTable tbMovies;
    private JTableHeader tbHeader;
    private DefaultTableModel tbModel;
    private final String[] columns = {"#", "ID", "Película", "# de Votos", "Punt. Promedio"};

    public TablePanel() {
        initComponents();
        setComponents();
        addComponents();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TablePanel");
        frame.setContentPane(new TablePanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    protected void initComponents() {
        tbModel = new DefaultTableModel() {
            @Override
            public int getColumnCount() {
                return columns.length;
            }
        };
        tbMovies = new JTable(tbModel) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
        };
        jsTbPane = new JScrollPane();
    }

    protected void setComponents() {
        tbHeader = tbMovies.getTableHeader();
        tbHeader.setReorderingAllowed(false);

        tbModel.setColumnIdentifiers(columns);

        tbMovies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbMovies.setPreferredScrollableViewportSize(new Dimension(550, 120));

        TableColumnModel columnModel = tbHeader.getColumnModel();
        columnModel.getColumn(0).setMaxWidth(60);
        columnModel.getColumn(1).setMaxWidth(60);
        columnModel.getColumn(2).setMinWidth(240);

        jsTbPane.setPreferredSize(new Dimension(560, 120));
        jsTbPane.setMaximumSize(new Dimension(-1, 120));
        jsTbPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsTbPane.setViewportView(tbMovies);

        setPreferredSize(new Dimension(-1, 150));
        setBorder(BorderFactory.createTitledBorder("Películas"));
    }

    protected void addComponents() {
        add(jsTbPane, BorderLayout.CENTER);
    }

    public DefaultTableModel getTbModel() {
        return tbModel;
    }

    public void setTbModel(DefaultTableModel tbModel) {
        this.tbModel = tbModel;
        tbMovies.setModel(this.tbModel);
    }

    public JTable getTbMovies() {
        return tbMovies;
    }

    public void setTbMovies(JTable tbMovies) {
        this.tbMovies = tbMovies;
    }
}
