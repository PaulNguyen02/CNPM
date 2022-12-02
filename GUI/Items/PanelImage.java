package GUI.Items;

import java.awt.event.*;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PanelImage extends JPanel{

    private ImageIcon icon;
    private JLabel label;
    private int x;
    private int y;

    public PanelImage(String location){
        setLayout(new GridLayout(1,1));
        icon = new ImageIcon(getClass().getResource(location));
        label = new JLabel(icon);
        add(label);
    }


    public void moveScreen(JFrame frame){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) {
                frame.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }
        });
    }

}
