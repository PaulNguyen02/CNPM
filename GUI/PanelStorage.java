package GUI;


import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.DimensionUIResource;

import DTO.NV_DTO;
import GUI.Items.Divider;
import GUI.Items.InputPane;
import GUI.Items.MyScrollBar;
import Phuc.SanPham;

public class PanelStorage extends JScrollPane {
    private SanPham product;
    private InputPane input;
    private JPanel container = new JPanel();
    public PanelStorage(int width, int height, NV_DTO user){
        product = new SanPham(user);
        input = new InputPane(user);
        setup();
        setPreferredSize(new DimensionUIResource(width, height));
    }

    private void setup(){
        
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

        container.add(new Divider("Nhập hàng", getWidth(), 30));
        container.add(input);
        
        container.add(new Divider("Sản phẩm", getWidth(), 30));
        container.add(product);
        
        setVerticalScrollBar(new MyScrollBar());
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setViewportView(container);
    
    }
}
