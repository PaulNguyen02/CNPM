package GUI;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.InsetsUIResource;


import BLL.NV_BLL;
import DTO.NV_DTO;

import javax.swing.plaf.ColorUIResource;

import Function.GUI;
import Function.MyEvent;
import GUI.Items.ButtonCustomed;

public class PanelLogin extends JPanel{
    private JLabel loginImage = new JLabel();
    private JLabel jlbName = new JLabel("ID:"); 
    private JLabel jlbPasswd = new JLabel("Password:");
    private JLabel jlbWarning = new JLabel("Tài khoản hoặc mật khẩu không đúng");
    private ButtonCustomed btn = new ButtonCustomed();
    private JTextField txtName = new JTextField(){
        @Override
        public void setBorder(Border border) {
        }
    };
    private JPasswordField passwd = new JPasswordField(){
        @Override
        public void setBorder(Border border) {
        }
    };
    private MyEvent event;
    private NV_DTO workers;

    public NV_DTO getUser(){
        return workers;
    }

    public PanelLogin(){
        
        GUI gui = new GUI();
        gui.setFont(jlbName, 3, 20);
        gui.setFont(jlbPasswd,3, 20);
        gui.setFont(jlbWarning, 3, 16);
        gui.setFont(txtName, 2, 18);
        gui.setFont(passwd, 2, 18);
        gui.setFont(btn, 1, 20);
        
        loginImage = gui.getJLabelImage("Login.png");

        jlbName.setPreferredSize(new DimensionUIResource(getWidth(), 30));
        jlbPasswd.setPreferredSize(new DimensionUIResource(getWidth(), 30));

        txtName.setPreferredSize(new DimensionUIResource(300, 30));
        passwd.setPreferredSize(new DimensionUIResource(300, 30));

        jlbName.setForeground(new ColorUIResource(112, 49, 145));
        jlbPasswd.setForeground(new ColorUIResource(112, 49, 145));
        jlbWarning.setForeground(ColorUIResource.red);

        btn.setBackground(new ColorUIResource(112, 49, 145));
        btn.setText("Đăng nhập");
        btn.setPreferredSize(new DimensionUIResource(getWidth(), 40));
        btn.setColorHover(new ColorUIResource(147, 33, 196));
        btn.setColorPressed(new ColorUIResource(110, 11, 153));
        btn.setFocusPainted(false);

        setup();
    }
    
    private void setup(){
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        gb.gridx = 0;
        gb.gridy = 0;
        gb.insets = new InsetsUIResource(0, 0, 40, 0);
        add(loginImage, gb);

        gb.gridx = 0;
        gb.gridy = 1;
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.insets = new InsetsUIResource(0, 0, 0, 0);
        add(jlbName, gb);

        
        gb.gridx = 0;
        gb.gridy = 2;
        gb.fill = GridBagConstraints.HORIZONTAL;
        add(txtName, gb);

        gb.gridx = 0;
        gb.gridy = 3;
        gb.fill = GridBagConstraints.HORIZONTAL;
        add(jlbPasswd, gb);

        gb.gridx = 0;
        gb.gridy = 4;
        add(passwd, gb);

        
        gb.gridx = 0;
        gb.gridy = 5;
        jlbWarning.setVisible(false);
        jlbWarning.setHorizontalAlignment(JLabel.CENTER);
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.insets = new InsetsUIResource(20, 0, 0, 0);
        add(jlbWarning, gb);

        gb.gridx = 0;
        gb.gridy = 6;
        gb.insets = new InsetsUIResource(15, 0, 0, 0);
        add(btn, gb);
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (checkLogin(txtName.getText(), String.valueOf(passwd.getPassword()))){
                    passwd.setText("");
                    txtName.setText("");
                    jlbWarning.setVisible(false);
                    event.switchFrame();
                }
                else{
                    jlbWarning.setVisible(true);
                }
            }
        });
    }
    private boolean checkLogin(String id, String pass){
        NV_BLL Bll = new NV_BLL();
        workers = Bll.getNV(id);
        if (workers == null) return false;
        if (pass.equals(workers.getPass()))  return true;
        return false;
    }
    public void addSwitchFrameEvent(MyEvent event){
        this.event = event;
    }
}
