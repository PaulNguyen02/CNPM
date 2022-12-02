package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.GradientPaint;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Function.MyEvent;
import GUI.Items.ListMenuItem;
import GUI.Items.Model_Menu;
import GUI.Items.Model_Menu.MenuType;

public class PanelMenu extends JPanel{
    private JPanel logo = new JPanel();
    private JPanel list = new JPanel();
    private ListMenuItem<Model_Menu> listMenu = new ListMenuItem<>();
    private MyEvent event;
    public PanelMenu(){
        setup();
        setOpaque(false);
        initItem();
    }

    public void addEventMenuSelected(MyEvent event){
        this.event = event;
        listMenu.addEventMenuSelected(this.event);
    }

    private void initItem(){
        listMenu.addItem(new Model_Menu("", "", MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "Chức Năng:", MenuType.TITLE));
        
        listMenu.addItem(new Model_Menu("1", "Thanh Toán", MenuType.MENU));
        listMenu.addItem(new Model_Menu("2", "Kiểm Kho", MenuType.MENU));
        listMenu.addItem(new Model_Menu("3", "Thống Kê", MenuType.MENU));
        
        
        listMenu.addItem(new Model_Menu("", "", MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "Tài Khoản", MenuType.TITLE));
        listMenu.addItem(new Model_Menu("4", "Quản Lý", MenuType.MENU));
        listMenu.addItem(new Model_Menu("5", "Đăng Xuất", MenuType.MENU));
        
        listMenu.addItem(new Model_Menu("", "", MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("6", "Thoát", MenuType.MENU));
        listMenu.addItem(new Model_Menu("7", "Liên Hệ", MenuType.MENU));
        
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gd = new GradientPaint(0, 0, Color.decode("#333399"), 0, getHeight(), Color.decode("#ff00cc"));
        g2.setPaint(gd);
        //g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
    private void setup(){
        logo.setLayout(new GridBagLayout());
        logo.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        logo.setOpaque(false);
        
        
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/Icon/LogoIcon.png"));        
        JLabel logoLabel = new JLabel(logoIcon);
        JLabel nameLable = new JLabel("CÔNG TY D2P");
        nameLable.setFont(new Font("Times New Roman", Font.BOLD, 25));
        nameLable.setForeground(Color.white);

        gbc.gridx = 0;
        gbc.gridy = 0;
        logo.add(logoLabel, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        logo.add(nameLable, gbc);
        
        list.setOpaque(false);
        list.add(listMenu);

        add(logo);
        add(list);
        
    }

    private int x;
    private int y;

    public void moveScreen(JFrame frame){
        logo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
        });
        logo.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) {
                frame.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }
        });
    }

   
}
