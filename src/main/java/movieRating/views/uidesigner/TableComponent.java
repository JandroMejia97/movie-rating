package main.java.movieRating.views.uidesigner;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.EventObject;

public class TableComponent {
    private JScrollPane jsTbPane;
    private JPanel jpTable;
    private JTable tbMovies;
    private JTableHeader tbHeader;
    private DefaultTableModel tbModel;
    private final String[] columns = {"#", "ID", "Película", "# de Votos", "Punt. Promedio"};

    public TableComponent() {
        $$$setupUI$$$();
        setUIComponents();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TablePanel");
        frame.setContentPane(new TableComponent().jpTable);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        tbModel = new DefaultTableModel() {
            @Override
            public int getColumnCount() {
                return columns.length;
            }
        };
        tbMovies = new JTable(tbModel) {
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
        };
    }

    private void setUIComponents() {
        tbHeader = tbMovies.getTableHeader();
        tbHeader.setReorderingAllowed(false);
        tbModel.setColumnIdentifiers(columns);
        
        tbMovies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        TableColumnModel columnModel = tbHeader.getColumnModel();
        columnModel.getColumn(0).setMaxWidth(60);
        columnModel.getColumn(1).setMaxWidth(60);
        columnModel.getColumn(2).setMinWidth(240);
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

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        jpTable = new JPanel();
        jpTable.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        jpTable.setPreferredSize(new Dimension(400, 150));
        jpTable.setBorder(BorderFactory.createTitledBorder(null, "Películas", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        jsTbPane = new JScrollPane();
        jsTbPane.setHorizontalScrollBarPolicy(31);
        jsTbPane.setVisible(true);
        jpTable.add(jsTbPane, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(400, -1), new Dimension(-1, 150), 1, false));
        jsTbPane.setViewportView(tbMovies);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return jpTable;
    }

}
