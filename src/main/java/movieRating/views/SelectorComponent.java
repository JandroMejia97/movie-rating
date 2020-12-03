package main.java.movieRating.views;

import main.java.movieRating.utils.enums.OptionType;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ItemListener;
import java.util.Locale;

public class SelectorComponent {
    private JLabel lblSelector;
    private JComboBox<OptionType> cbSelector;
    private JPanel jpSelector;

    public SelectorComponent() {
        $$$setupUI$$$();
        setUIComponents();
    }

    public void cbSelectorAddItemListener(ItemListener itemListener) {
        cbSelector.addItemListener(itemListener);
    }

    public JComboBox<OptionType> getCbSelector() {
        return cbSelector;
    }

    private void createUIComponents() {
        cbSelector = new JComboBox<>();
    }

    private void setUIComponents() {
        cbSelector.setModel(new DefaultComboBoxModel<>(OptionType.values()));
        cbSelector.setSelectedItem(OptionType.TODOS);
        cbSelector.setEnabled(false);
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
        jpSelector = new JPanel();
        jpSelector.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        jpSelector.setMinimumSize(new Dimension(280, 20));
        jpSelector.setPreferredSize(new Dimension(400, 40));
        lblSelector = new JLabel();
        Font lblSelectorFont = this.$$$getFont$$$(null, Font.BOLD, -1, lblSelector.getFont());
        if (lblSelectorFont != null) lblSelector.setFont(lblSelectorFont);
        lblSelector.setText("Cantidad de resultados a mostrar:");
        jpSelector.add(lblSelector);
        cbSelector.setMinimumSize(new Dimension(81, 30));
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        cbSelector.setModel(defaultComboBoxModel1);
        cbSelector.setPreferredSize(new Dimension(150, 30));
        jpSelector.add(cbSelector);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return jpSelector;
    }

}
