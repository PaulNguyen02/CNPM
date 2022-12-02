package GUI.Items;

import javax.swing.JScrollBar;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;

public class MyScrollBar extends JScrollBar{
    public MyScrollBar(){
        setUI(new MyScrollBarUI());
        setPreferredSize(new DimensionUIResource(8, 8));
        setForeground(new ColorUIResource(48, 144, 216));
        setBackground(ColorUIResource.WHITE);
    }
}
