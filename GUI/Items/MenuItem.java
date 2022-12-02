package GUI.Items;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.Items.Model_Menu.MenuType;

public class MenuItem extends JPanel {
    private JLabel iconLabel = new JLabel();
    private JLabel nameLabel = new JLabel();
    private boolean selected;
    public MenuItem(Model_Menu data){
        setup();
        setOpaque(false);
        if (data.getType() == MenuType.MENU){
            iconLabel.setIcon(data.toIcon());
            nameLabel.setText(data.getName());
        }
        else
        if (data.getType() == MenuType.TITLE){
            iconLabel.setText(data.getName());
            iconLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            nameLabel.setVisible(false);
        }
        else{
            nameLabel.setText(" ");
        }
    }

    public void setup(){
        
        add(iconLabel);
        add(nameLabel);
        
        iconLabel.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        nameLabel.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        iconLabel.setForeground(Color.WHITE);
        nameLabel.setForeground(Color.white);
    }


    public void setSelected(boolean selected){
        this.selected = selected;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (selected){
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(255, 255, 255, 80));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
            g2.fillRect(0, 0, getWidth(), getHeight());
        }
        super.paintComponent(g);
    }
}
