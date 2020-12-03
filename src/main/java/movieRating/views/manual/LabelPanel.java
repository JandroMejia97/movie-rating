package main.java.movieRating.views.manual;

import main.java.movieRating.utils.clases.PanelComponent;
import org.jfree.ui.tabbedui.VerticalLayout;

import javax.swing.*;
import java.awt.*;

public class LabelPanel extends PanelComponent {
    private Label lblCant;
    private Label lblTag;
    private Font tagFont = new Font(null, Font.BOLD, 16);
    private Font cantFont = new Font(null, Font.BOLD, 20);
    private String tagText;
    private String cantText;

    public LabelPanel(String tagText, String cantText) {
        this.tagText = tagText;
        this.cantText = cantText;
        initComponents();
        setComponents();
        addComponents();
    }

    public LabelPanel(String tagText) {
        this(tagText, "???");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("LabelPanel");
        frame.setContentPane(new LabelPanel("Prueba"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public String getLblCantText() {
        return lblCant.getText();
    }

    public void setLblCantText(String lblCantText) {
        this.lblCant.setText(lblCantText);
    }

    public String getLblTagText() {
        return lblTag.getText();
    }

    public void setLblTagText(String lblTagText) {
        lblTag.setText(lblTagText);
    }

    @Override
    protected void initComponents() {
        lblTag = new Label(tagText);
        lblCant = new Label(cantText);
    }

    protected void setComponents() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(new VerticalLayout());
        setBackground(Color.CYAN);

        lblTag.setFont(tagFont);
        lblCant.setFont(cantFont);
        lblCant.setAlignment(Label.CENTER);
        lblTag.setAlignment(Label.CENTER);
    }

    @Override
    protected void addComponents() {
        add(lblCant);
        add(lblTag);
    }
}
