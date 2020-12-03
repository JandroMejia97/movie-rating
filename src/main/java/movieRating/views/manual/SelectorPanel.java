package main.java.movieRating.views.manual;

import main.java.movieRating.utils.clases.PanelComponent;
import main.java.movieRating.utils.enums.OptionType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemListener;

public class SelectorPanel extends PanelComponent {
    private JComboBox<OptionType> cbSelector;
    private JLabel lblSelector;

    public SelectorPanel() {
        initComponents();
        setComponents();
        addComponents();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SelectorPanel");
        frame.setContentPane(new SelectorPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void cbSelectorAddItemListener(ItemListener itemListener) {
        cbSelector.addItemListener(itemListener);
    }

    public JComboBox<OptionType> getCbSelector() {
        return cbSelector;
    }

    @Override
    protected void initComponents() {
        lblSelector = new JLabel("Cantidad de resultados a mostrar:");
        cbSelector = new JComboBox<OptionType>();
    }

    protected void setComponents() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        setMinimumSize(new Dimension(280, 20));
        setPreferredSize(new Dimension(400, 40));

        cbSelector.setModel(new DefaultComboBoxModel<OptionType>(OptionType.values()));
        cbSelector.setSelectedItem(OptionType.TODOS);
        cbSelector.setEnabled(false);
        cbSelector.setMinimumSize(new Dimension(81, 30));
        cbSelector.setPreferredSize(new Dimension(150, 30));
    }

    @Override
    protected void addComponents() {
        add(lblSelector);
        add(cbSelector);
    }

    public OptionType getCbSelectedItem() {
        return (OptionType) this.cbSelector.getSelectedItem();
    }
}
