package main.java.movieRating.views.manual;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import main.java.movieRating.utils.clases.PanelComponent;

import java.awt.*;
import java.awt.event.ActionListener;
import org.jfree.ui.tabbedui.VerticalLayout;

public class HeaderPanel extends PanelComponent {
    private JLabel lblTitle;
    private JButton btnProcesar;
    private JProgressBar pbProgreso;
    private JPanel jpProcesar;
    private Font headerFont = new Font(null, Font.BOLD, 24);
    private final String headerText = "Tablero de Control de Películas";
    private final String btnText = "Procesar Datos";

    public static void main(String[] args) {
        JFrame frame = new JFrame("ChartPanel");
        frame.setContentPane(new HeaderPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public HeaderPanel() {
        initComponents();
        setComponents();
        addComponents();
    }

    public void btnProcesarAddActionListener(ActionListener actionListener) {
        btnProcesar.addActionListener(actionListener);
    }

    public JProgressBar getPbProgreso() {
        return pbProgreso;
    }

    public JButton getBtnProcesar() {
        return btnProcesar;
    }
    
    @Override
    protected void initComponents() {
        lblTitle = new JLabel(headerText);
        jpProcesar = new JPanel();
        btnProcesar = new JButton(btnText);
        pbProgreso = new JProgressBar(0, 100);
    }

    @Override
    protected void setComponents() {
        setLayout(new VerticalLayout());
        setMaximumSize(new Dimension(2147483647, 80));

        lblTitle.setFont(headerFont);

        pbProgreso.setIndeterminate(false);
        pbProgreso.setStringPainted(true);
        
        jpProcesar.add(btnProcesar);
        jpProcesar.add(pbProgreso);
    }

    @Override
    protected void addComponents() {
        add(lblTitle);
        add(jpProcesar);
    }

}
