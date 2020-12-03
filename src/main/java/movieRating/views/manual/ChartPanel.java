package main.java.movieRating.views.manual;

import main.java.movieRating.utils.clases.PanelComponent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.statistics.SimpleHistogramBin;
import org.jfree.data.statistics.SimpleHistogramDataset;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ChartPanel extends PanelComponent {
    /**
     * JPanel donde se dibuja el diagrama.
     */
    private org.jfree.chart.ChartPanel chartPanel;
    /**
     * Diagrama.
     */
    private JFreeChart chart;
    /**
     * Key.
     */
    private final String key = "Puntuación";
    /**
     * Etiqueta del eje Y.
     */
    private final String yAxisLabel = "Votos";
    /**
     * Título del diagrama.
     */
    private final String chartTitle = "Películas";
    /**
     * Etiqueta del eje X.
     */
    private final String xAxisLabel = "Puntuaciones";
    /**
     * Dataset del Histograma.
     */
    private SimpleHistogramDataset dataset;

    ChartPanel() {
        initComponents();
        setComponents();
        addComponents();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ChartPanel");
        frame.setContentPane(new ChartPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    protected void initComponents() {
        dataset = new SimpleHistogramDataset(key);
        SimpleHistogramDataset dataset = new SimpleHistogramDataset(key);
        chart = ChartFactory.createHistogram(chartTitle, xAxisLabel, yAxisLabel, dataset, PlotOrientation.VERTICAL, true, false, false);
        chartPanel = new org.jfree.chart.ChartPanel(chart);
    }

    public void setComponents() {
        chartPanel.setPreferredSize(new Dimension(550, 270));
        chartPanel.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        setAxis();
        addBins();
        setMinimumSize(new Dimension(-1, 285));
        setBorder(BorderFactory.createTitledBorder(null, "Gráfico", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
    }

    @Override
    protected void addComponents() {
        add(chartPanel);
    }

    private void setAxis() {
        XYPlot plot = (XYPlot) chart.getPlot();
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setRange(0, 5);
        xAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
    }

    private void addBins() {
        dataset.addBin(new SimpleHistogramBin(0, 1, true, true));
        dataset.addBin(new SimpleHistogramBin(1, 2, false, true));
        dataset.addBin(new SimpleHistogramBin(2, 3, false, true));
        dataset.addBin(new SimpleHistogramBin(3, 4, false, true));
        dataset.addBin(new SimpleHistogramBin(4, 5, false, true));
    }

    /**
     * Modifica el diagrama mostrado.
     *
     * @param chart Diagrama a mostrar.
     */
    public void setChart(JFreeChart chart) {
        this.chart = chart;
        chartPanel.setChart(this.chart);
    }

    /**
     * Modifica el diagrama mostrado.
     *
     * @param chartTitle       Título del diagrama.
     * @param dataset Conjunto de datos del diagrama.
     */
    public void setChart(String chartTitle, SimpleHistogramDataset dataset) {
        setChart(ChartFactory.createHistogram(chartTitle, xAxisLabel, yAxisLabel, dataset, PlotOrientation.VERTICAL, true, false, false));
        setAxis();
    }

    /**
     * Modifica el diagrama mostrado.
     *
     * @param chartTitle Título del diagrama.
     * @param values     Conjunto de valores del diagrama con el cual se creará el conjunto de datos.
     */
    public void setChart(String chartTitle, double[] values) {
        dataset = new SimpleHistogramDataset(key);
        addBins();
        dataset.addObservations(values);
        setChart(chartTitle, dataset);
    }

    /**
     * Modifica el diagrama mostrado.
     *
     * @param values Conjunto de valores del diagrama con el cual se creará el conjunto de datos.
     */
    public void setChart(double[] values) {
        setChart(chartTitle, values);
    }

    public String getChartTitle() {
        return chart.getTitle().getText();
    }

    public String getKey() {
        return key;
    }

    public String getYAxisLabel() {
        return yAxisLabel;
    }

    public String getXAxisLabel() {
        return xAxisLabel;
    }

}
