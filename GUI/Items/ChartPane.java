package GUI.Items;

import java.util.ArrayList;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.data.category.DefaultCategoryDataset;


public class ChartPane extends JPanel{
    private ChartPanel chartPanel;
    public ChartPane(ArrayList<Integer> data, ArrayList<String> category, String Title, String X_label, String Y_label, ColorUIResource Color){
        setLayout(new GridLayout(1,1));
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i=0; i<data.size(); i++){
            dataset.setValue(data.get(i), "", category.get(i));
        }
        JFreeChart chart = ChartFactory.createLineChart(Title, X_label, Y_label, dataset);
        chart.getPlot().setBackgroundPaint(ColorUIResource.white);
        chart.getCategoryPlot().getRenderer().setSeriesPaint(0, Color);
        CategoryAxis domaintAxis = chart.getCategoryPlot().getDomainAxis();
        domaintAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
        chartPanel = new ChartPanel(chart);
        removeAll();
        add(chartPanel);
        validate();
    }
    public void setChartSize(int width, int height){
        DimensionUIResource size = new DimensionUIResource(width, height);
        chartPanel.setPreferredSize(size);
    }
}
