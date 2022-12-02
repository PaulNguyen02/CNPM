package GUI;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.plaf.DimensionUIResource;

import DTO.NV_DTO;
import Function.MyEvent;
import GUI.Items.MyMessageConfirm;
import GUI.Items.PanelImage;

public class LoginFrame extends JFrame{
    private MyEvent event;
    private final JFrame frame = this;
    private PanelBorder Border = new PanelBorder();
    private PanelImage image = new PanelImage("/Icon/Login.jpg");
    private PanelLogin login;
    private TitleBar titleBar = new TitleBar(this);

    public NV_DTO getUser(){
        return login.getUser();
    }

    public LoginFrame(){
        login = new PanelLogin();
        setup();
        titleBar.moveScreen(this);
        image.moveScreen(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MyMessageConfirm mc = new MyMessageConfirm(frame, "Đừng thoát", "Bạn sợ à?", "Confirm1.png");
                mc.setVisible(true);
                if (mc.getSelected()){
                    frame.dispose();
                }
            }
        });

    }
    private void setup(){
        setUndecorated(true);
        setSize(1300, 720);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        
        Border.setLayout(new BorderLayout(0, 0));

        titleBar.setPreferredSize(new DimensionUIResource(1300, 25));
        Border.add(titleBar, BorderLayout.PAGE_START);
        
        image.setPreferredSize(new DimensionUIResource(880, 710));
        Border.add(image, BorderLayout.LINE_START);
        login.setPreferredSize(new DimensionUIResource(getWidth() - 880 , 690)); 
        Border.add(login, BorderLayout.LINE_END);

        add(Border);
        setLocationRelativeTo(null);
    }

    public void login(){
        
    }
    
    public void addSwitchFrameEvent(MyEvent event){
        this.event = event;
        login.addSwitchFrameEvent(this.event);
    }
}
