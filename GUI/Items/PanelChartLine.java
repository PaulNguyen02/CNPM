package GUI.Items;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.GradientPaint;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

public class PanelChartLine extends JPanel{
    private final List<ModelChartLine> list;
    public PanelChartLine(){
        list = new ArrayList<>();
        setup();
        setOpaque(false);
    }

    private void setup(){

    }
    
    private double getMax(){
        double max = 0;
        for (ModelChartLine e : list) {
            if (e.getValue() > max)
                max = e.getValue();
        }
        return max;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (list.size() > 1){
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int margin = 5;
            int width = getWidth() - margin*2;
            int height = getHeight() - margin*2;
            double max = getMax();
            double space = width / (list.size() -1);
            Path2D.Float p = new Path2D.Float();
            p.moveTo(margin, getHeight()-margin);
            int x = margin;
            for(ModelChartLine e: list){
                double location = e.getValue() *height - max;
                location = getHeight() - location;
                p.lineTo(x, location);
                x += space;
            }
            p.lineTo(x - space, getHeight() - margin);
            GradientPaint gra = new GradientPaint(0, margin, new ColorUIResource(6, 131, 212), 0, getHeight(), new ColorUIResource(255, 255, 255));
            g2.setPaint(gra);
            g2.fill(p);
            drawPoint(g2);
        }
        super.paintComponent(g);
    }
    private void drawPoint(Graphics2D g2) {
        g2.setColor(new ColorUIResource(6, 131, 212));
        int size = 4;
        int margin = 5;
        int width = getWidth() - margin * 2;
        int height = getHeight() - margin * 2;
        double max = getMax();
        double space = width / (list.size() - 1);
        int x = margin;
        for (ModelChartLine data : list) {
            double location = data.getValue() * height / max;
            location = getHeight() - location;
            g2.fillOval(x - 2, (int) location - 2, size, size);
            x += space;
        }
    }
    public void addItem(ModelChartLine data) {
        if (list.size() == 20)
            list.remove(0);
        list.add(data);
        repaint();
    }

    public void removeAllData() {
        list.clear();
        repaint();
    }

}

