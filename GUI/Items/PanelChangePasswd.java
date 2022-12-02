package GUI.Items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.InsetsUIResource;

import BLL.NV_BLL;
import DTO.NV_DTO;
import Function.GUI;

public class PanelChangePasswd extends JPanel{
    
    private NV_DTO user;

    private JPasswordField txtf_OldPasswd = new JPasswordField();
    private JPasswordField txtf_NewPasswd1 = new JPasswordField();
    private JPasswordField txtf_NewPasswd2 = new JPasswordField();
    private JLabel jlb_OldPasswd = new JLabel("Nhập mật khẩu cũ:");
    private JLabel jlb_NewPasswd1 = new JLabel("Nhập mật khẩu mới:");
    private JLabel jlb_NewPasswd2 = new JLabel("Nhập lại mật khẩu mới:");
    private JLabel jlb_Warning = new JLabel();
    private ButtonCustomed btn_Confirm = new ButtonCustomed("Đổi mật khẩu");
    
    public PanelChangePasswd(NV_DTO user){
        GUI gui = new GUI();
        this.user = user;

        jlb_Warning.setVisible(false);
        jlb_Warning.setHorizontalAlignment(JLabel.CENTER);

        gui.setFont(txtf_OldPasswd, 2, 18);
        gui.setFont(txtf_NewPasswd1, 2, 18);
        gui.setFont(txtf_NewPasswd2, 2, 18);
        gui.setFont(jlb_OldPasswd, 3, 16);
        gui.setFont(jlb_NewPasswd1, 3, 16);
        gui.setFont(jlb_NewPasswd2, 3, 16);
        gui.setFont(jlb_Warning, 3, 15);
        gui.setFont(btn_Confirm, 1, 20);

        txtf_NewPasswd1.setPreferredSize(new DimensionUIResource(240, 30));
        txtf_NewPasswd2.setPreferredSize(new DimensionUIResource(240, 30));
        txtf_OldPasswd.setPreferredSize(new DimensionUIResource(240, 30));
        
        btn_Confirm.setBackground(new ColorUIResource(112, 49, 145));
        btn_Confirm.setPreferredSize(new DimensionUIResource(240, 40));
        btn_Confirm.setColorHover(new ColorUIResource(147, 33, 196));

        setup();
    }
    private void setup() {
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        gb.insets = new InsetsUIResource(0,0,0,0);
        gb.gridx = 0;
        gb.gridy = 0;
        gb.fill = GridBagConstraints.HORIZONTAL;
        add(jlb_OldPasswd, gb);

        gb.gridx = 1;
        gb.gridy = 0;
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.insets = new InsetsUIResource(0, 10, 10, 0);
        add(txtf_OldPasswd, gb);

        gb.insets = new InsetsUIResource(0,0,0,0);
        gb.gridx = 0;
        gb.gridy = 1;
        gb.fill = GridBagConstraints.HORIZONTAL;
        add(jlb_NewPasswd1, gb);

        gb.gridx = 1;
        gb.gridy = 1;
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.insets = new InsetsUIResource(0, 10, 10, 0);
        add(txtf_NewPasswd1, gb);

        gb.insets = new InsetsUIResource(0,0,0,0);
        gb.gridx = 0;
        gb.gridy = 2;
        gb.fill = GridBagConstraints.HORIZONTAL;
        add(jlb_NewPasswd2, gb);

        gb.gridx = 1;
        gb.gridy = 2;
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.insets = new InsetsUIResource(0, 10, 10, 0);
        add(txtf_NewPasswd2, gb);

        gb.gridx = 1;
        gb.gridy = 3;
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.insets = new InsetsUIResource(10, 0, 0, 0);
        add(jlb_Warning, gb);

        gb.gridx = 1;
        gb.gridy = 4;
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.insets = new InsetsUIResource(20, 0, 0, 0);
        add(btn_Confirm, gb);

        btn_Confirm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jlb_Warning.setVisible(false);
                jlb_Warning.setForeground(ColorUIResource.red);
                String OldPasswd = String.valueOf(txtf_OldPasswd.getPassword());

                if (!OldPasswd.equals(user.getPass())){
                    jlb_Warning.setText("Mật khẩu không chính xác");
                    jlb_Warning.setVisible(true);
                    return;
                }

                if (!String.valueOf(txtf_NewPasswd1.getPassword()).equals(String.valueOf(txtf_NewPasswd2.getPassword()))){
                    jlb_Warning.setText("Mật khẩu xác nhận không trùng khớp");
                    jlb_Warning.setVisible(true);
                    return;
                }

                user.setPass(String.valueOf(txtf_NewPasswd1.getPassword()));
                (new NV_BLL()).Edit(user, "0");
                jlb_Warning.setForeground(ColorUIResource.green);
                jlb_Warning.setText("Đổi mật khẩu thành công");
                jlb_Warning.setVisible(true);

            }
        });
    }
}
