package GUI;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;

import DTO.NV_DTO;
import DTO.NV_DTO.role;
import Function.MyEvent;
import GUI.Items.MyMessageConfirm;
import Phuc.HoaDon;

public class MainFrame extends JFrame{
    private PanelBorder Border = new PanelBorder();
    private TitleBar titleBar = new TitleBar(this ,new ColorUIResource(36, 14, 130));
    private PanelMenu Menu = new PanelMenu();
    private PanelManger Manager;
    private JPanel Main = new JPanel();
    private NV_DTO user;

    private MyEvent event;
    private PanelStorage storage;
    private HoaDon hoaDon;

    public JPanel getMainPane(){
        return Main;
    }
    public MainFrame(){
        setup(MainFrame.this);
        setBackground(new Color(0, 0, 0, 0));
        Menu.moveScreen(this);
        titleBar.moveScreen(this);
        
    }


    public void initPanel(NV_DTO user){
        this.user = user;
        storage = new PanelStorage(Main.getWidth(), Main.getHeight(), user);
        hoaDon = new HoaDon(user);
        Manager = new PanelManger(user);
        Main.setLayout(new GridLayout(1,1));
        Main.removeAll();
        Main.add(new PanelIntro(user));
        Main.repaint();
        Main.revalidate();
        Main.setBackground(ColorUIResource.white);
        
    }

    private void setup(JFrame frame){
        
        setSize(1300, 720);
        setUndecorated(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        
        Main.setPreferredSize(new DimensionUIResource(1100, getHeight()-25));

        Border.setLayout(new BorderLayout());
        setContentPane(Border);

        titleBar.setPreferredSize(new DimensionUIResource(getWidth(), 25));
        Border.add(titleBar, BorderLayout.PAGE_START);

        Menu.setPreferredSize(new DimensionUIResource(200, getHeight()-25));
        Border.add(Menu, BorderLayout.WEST);
        
        Border.add(Main);

        Menu.addEventMenuSelected(new MyEvent() {
            @Override
            public void selected(int index) {
                switch (index){
                    case 2:
                        if (user.getRole() == role.Casher || user.getRole() == role.Manager){
                            Main.removeAll();
                            Main.add(hoaDon);
                            Main.repaint();
                            Main.revalidate();
                            Main.setBackground(ColorUIResource.white);
                        }
                        break;
                    case 3:
                        if (user.getRole() == role.Warehouse || user.getRole() == role.Manager) {
                            Main.removeAll();
                            Main.add(storage);
                            Main.repaint();
                            Main.revalidate();
                            Main.setBackground(ColorUIResource.white);
                        }
                        break;
                    case 4:
                        if (user.getRole() == role.Manager) {
                            Main.removeAll();
                            Main.add(new PanelStatistic());
                            Main.repaint();
                            Main.revalidate();
                        }
                        break;
                    case 8:
                        Main.removeAll();
                        Main.add(Manager);
                        Main.repaint();
                        Main.revalidate();
                        break;
                    case 9:
                        MyMessageConfirm switchUser = new MyMessageConfirm(frame, "Xác nhận đăng xuất", "Bạn muốn đăng xuất tài khoản?", "Confirm.gif");
                        switchUser.setVisible(true);
                        if (switchUser.getSelected())
                            event.switchFrame();
                        break;
                    case 11:
                        MyMessageConfirm quit = new MyMessageConfirm(frame, "Xác nhận thoát", "Còn gì chưa lưu không đó?", "Confirm.gif");
                        quit.setVisible(true);
                        if (quit.getSelected())
                            frame.dispose();
                        break;
                }
            }
        });
        
        setLocationRelativeTo(null);
    }
    public void addSwitchFrameEvent(MyEvent event){ 
        this.event = event;
    }
    
}
