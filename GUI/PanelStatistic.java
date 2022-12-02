package GUI;


import javax.swing.JTabbedPane;

import GUI.Items.PanelStatisticChart;
import Phuc.DoanhThu;
import Phuc.ThongKeHang;

public class PanelStatistic extends JTabbedPane{

    private DoanhThu income = new DoanhThu();
    private PanelStatisticChart chart = new PanelStatisticChart(getWidth(), getHeight());
    private ThongKeHang product = new ThongKeHang();
    public PanelStatistic(){
        setup();
    }

    private void setup(){
        add("Biểu đò", chart);
        add("Sản phẩm", product);
        add("Xuất Excel" ,income);
    }
    
}
