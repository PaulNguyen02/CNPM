package GUI;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.plaf.ColorUIResource;

import GUI.Items.ButtonCustomed;
import GUI.Items.MyMessageConfirm;

public class TitleBar extends JPanel{

    private ButtonCustomed btnExit = new ButtonCustomed();
    private ButtonCustomed btnHide = new ButtonCustomed();
    private ColorUIResource Color;
    private JFrame frame;
    private int x;
    private int y;
    public TitleBar(JFrame frame){
        setOpaque(true);
        this.frame = frame;
        Color = new ColorUIResource(66, 4, 94);
        setup();
    }
    public TitleBar(JFrame frame, ColorUIResource Color){
        setOpaque(true);
        this.frame = frame;
        this.Color = Color;
        setup();
    }
    
    private void setup(){
        setBackground(Color);
        setLayout(new BorderLayout());
        btnExit.setBackground(getBackground());
        btnExit.setColorHover(ColorUIResource.RED);
        btnExit.setColorPressed(ColorUIResource.ORANGE);
        btnExit.setFocusPainted(false);
        btnExit.setForeground(ColorUIResource.white);
        btnExit.setText("X");
        btnHide.setBackground(getBackground());
        btnHide.setColorHover(ColorUIResource.RED);
        btnHide.setColorPressed(ColorUIResource.ORANGE);
        btnHide.setFocusPainted(false);
        btnHide.setForeground(ColorUIResource.white);
        btnHide.setText("-");
        JPanel Button = new JPanel(new GridLayout(1,2));
        Button.add(btnHide);
        Button.add(btnExit);
        add(Button, BorderLayout.LINE_END);

        btnExit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                MyMessageConfirm exit = new MyMessageConfirm(frame, "Xác nhận thoát?", "Ei muốn bạn chăm chỉ làm việc", "Confirm1.png");
                exit.setVisible(true);
                if (exit.getSelected())
                    frame.dispose();
            }
        });

        btnHide.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setState(Frame.ICONIFIED);
            }
        });
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
