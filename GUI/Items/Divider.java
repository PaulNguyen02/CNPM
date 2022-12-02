package GUI.Items;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;

import Function.GUI;

public class Divider extends JPanel{
    private JLabel header = new JLabel();
    public Divider(String text, int width, int height){
        header.setText(text);
        header.setForeground(ColorUIResource.white);
        GUI gui = new GUI();
        gui.setFont(header, 3, 20);
        setBackground(new ColorUIResource(13, 77, 181));
        setPreferredSize(new DimensionUIResource(width, height));
        add(header);
    }
}
