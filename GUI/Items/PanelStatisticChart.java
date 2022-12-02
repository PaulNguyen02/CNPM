package GUI.Items;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableModel;

import BLL.Statistic_BLL;
import DTO.Statistic_DTO;
import Function.GUI;

public class PanelStatisticChart extends JScrollPane {
    private JPanel container = new JPanel();
    private ChartPane Chart_IncomeDay;
    private ChartPane Chart_SoldDay;
    private ChartPane Chart_IncomeMonth;
    private ChartPane Chart_SoldMonth;
    

    private GUI gui = new GUI();
    
    private ArrayList<Integer> data_income;
    private ArrayList<String> label;
    private ArrayList<Integer> data_sold;
    private ArrayList<Statistic_DTO> Income;

    private JScrollPane Scroll_IncomeDay = new JScrollPane();
    private JScrollPane Scroll_SoldDay = new JScrollPane();
    private MyTable Table_IncomeDay = new MyTable(1){
        
        @Override
        public Class getColumnClass(int column) {
            return (column == 2) ? Icon.class : Object.class;
        };
    };

    private MyTable Table_SoldDay = new MyTable(1){
        
        @Override
        public Class getColumnClass(int column) {
            return (column == 2) ? Icon.class : Object.class;
        };
    };

    private JScrollPane Scroll_IncomeMonth = new JScrollPane();
    private JScrollPane Scroll_SoldMonth = new JScrollPane();
    private MyTable Table_IncomeMonth = new MyTable(1){
        
        @Override
        public Class getColumnClass(int column) {
            return (column == 2) ? Icon.class : Object.class;
        };
    };

    private MyTable Table_SoldMonth = new MyTable(1){
        
        @Override
        public Class getColumnClass(int column) {
            return (column == 2) ? Icon.class : Object.class;
        };
    };

    private int Total_Income = 0;
    private int Total_Sold = 0;
    private String Current_Month;
    private String Current_Year;

    public PanelStatisticChart(int width, int height){
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        setup();
        setVerticalScrollBar(new MyScrollBar());
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setViewportView(container);
        setPreferredSize(new DimensionUIResource(width, height));
    }
    private void setup(){

        statisticMonth();
        statisticDay();
        Scroll_IncomeDay.setViewportView(Table_IncomeDay);
        Scroll_IncomeDay.setVerticalScrollBar(new MyScrollBar());
        Scroll_IncomeDay.setPreferredSize(new DimensionUIResource(700, 300));

        Scroll_SoldDay.setViewportView(Table_SoldDay);
        Scroll_SoldDay.setVerticalScrollBar(new MyScrollBar());
        Scroll_SoldDay.setPreferredSize(new DimensionUIResource(700, 300));
        
        Scroll_IncomeMonth.setViewportView(Table_IncomeMonth);
        Scroll_IncomeMonth.setVerticalScrollBar(new MyScrollBar());
        Scroll_IncomeMonth.setPreferredSize(new DimensionUIResource(700, 300));

        Scroll_SoldMonth.setViewportView(Table_SoldMonth);
        Scroll_SoldMonth.setVerticalScrollBar(new MyScrollBar());
        Scroll_SoldMonth.setPreferredSize(new DimensionUIResource(700, 300));

        JPanel Panel_IncomeMonth = new JPanel();
        JPanel Panel_SoldMonth = new JPanel();
        JPanel Panel_IncomeDay = new JPanel();
        JPanel Panel_SoldDay = new JPanel();

        Panel_IncomeDay.setBackground(ColorUIResource.white);
        Panel_SoldDay.setBackground(ColorUIResource.white);
        Panel_IncomeMonth.setBackground(ColorUIResource.white);
        Panel_SoldMonth.setBackground(ColorUIResource.white);

        Panel_IncomeDay.add(Scroll_IncomeDay);
        Panel_SoldDay.add(Scroll_SoldDay);
        
        Panel_IncomeMonth.add(Scroll_IncomeMonth);
        Panel_SoldMonth.add(Scroll_SoldMonth);

        container.add(Chart_IncomeDay);
        container.add(Panel_IncomeDay);
        container.add(Chart_SoldDay);
        container.add(Panel_SoldDay);
        container.add(Chart_IncomeMonth);
        container.add(Panel_IncomeMonth);
        container.add(Chart_SoldMonth);
        container.add(Panel_SoldMonth);
    }   

    private void statisticMonth(){
        data_income = new ArrayList<>();
        label = new ArrayList<>();
        data_sold = new ArrayList<>();
        Income = (new Statistic_BLL()).getData();

        int month = Income.get(0).getMonth();
        for (Statistic_DTO row : Income) {
            if (month == row.getMonth()){
                Total_Income += row.getIncome();
                Total_Sold += row.getSold();
            }
            else{
                month = row.getMonth();
                data_income.add(Total_Income);
                data_sold.add(Total_Sold);
                label.add(row.getMonth() + "-" + row.getYear());
                Total_Income = row.getIncome();
                Total_Sold = row.getSold();
            }
        }
        Chart_IncomeMonth = new ChartPane(data_income, label, "Doanh Thu Theo Tháng",
         "Tháng", "Ngàn VND", new ColorUIResource(ColorUIResource.RED));

        Chart_SoldMonth = new ChartPane(data_sold, label, "Bán Được Theo Tháng",
         "Tháng", "Sản phẩm", new ColorUIResource(ColorUIResource.BLUE));
        
        Chart_IncomeMonth.setChartSize(getWidth(), 350);
        Chart_SoldMonth.setChartSize(getWidth(), 350);

        buildTable(Table_IncomeMonth, data_income, label, true);
        buildTable(Table_SoldMonth, data_sold, label, false);
    }

    private void statisticDay(){

        data_income = new ArrayList<>();
        label = new ArrayList<>();
        data_sold = new ArrayList<>();
        LocalDate now = LocalDate.now();
        if (now.getMonthValue() >= 10){
            Current_Month = now.getMonthValue()+"";
        }
        else{
            Current_Month = "0"+now.getMonthValue();
        }
        Current_Year = now.getYear()+"";

        Income = (new Statistic_BLL()).getData(Current_Month, Current_Year);
        for (int i = 0; i < Income.size(); i++){
            data_income.add(Income.get(i).getIncome());
            label.add(Income.get(i).getDate());
            data_sold.add(Income.get(i).getSold());
        }

        Chart_IncomeDay = new ChartPane(data_income, label, "Doanh Thu Theo Ngày",
         "Ngày", "Ngàn VND", new ColorUIResource(ColorUIResource.RED));

        Chart_SoldDay = new ChartPane(data_sold, label, "Bán Được Theo Ngày",
         "Ngày", "Sản phẩm", new ColorUIResource(ColorUIResource.BLUE));
        
        Chart_IncomeDay.setChartSize(getWidth(), 350);
        Chart_SoldDay.setChartSize(getWidth(), 350);
        
        buildTable(Table_IncomeDay, data_income, label, true);
        buildTable(Table_SoldDay, data_sold, label, false);
    }

    private void buildTable(JTable table, ArrayList<Integer> data, ArrayList<String> label, boolean flag){

        ImageIcon up = gui.getImg("up.png");
        ImageIcon down = gui.getImg("down.png");
        ImageIcon equal = gui.getImg("equal_table.png");
        DefaultTableModel model = null;
        int multiple = 1;
        if (flag) {
            multiple = 1000;
            model = new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                            "Thời gian", "Doanh thu", "Trạng thái"
                    });
        }
        else{
            
            model = new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                            "Thời gian", "Bán được", "Trạng thái"
                    });
        }

        int pre = data.get(0);
        table.setModel(model);
        model.addRow(new Object[] { label.get(0), data.get(0)*multiple, equal });
        for (int i = 1; i < data.size(); i++) {
            if (pre > data.get(i)) {
                model.addRow(new Object[] { label.get(i), data.get(i)*multiple, down });
                pre = data.get(i);
                continue;
            }
            if (pre < data.get(i)) {
                model.addRow(new Object[] { label.get(i), data.get(i)*multiple, up });
                pre = data.get(i);
                continue;
            }
            model.addRow(new Object[] { label.get(i), data.get(i)*multiple, equal });
            pre = data.get(i);
        }
        
    }
}
