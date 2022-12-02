package GUI;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;

import DTO.NV_DTO;

public class PanelIntro extends JPanel{
    private ImageIcon icon = new ImageIcon(getClass().getResource("/Icon/intro.png"));
    private JLabel iconLabel = new JLabel(icon);
    private JLabel textLabel1 = new JLabel("Chào mừng quay trở lại");
    private JLabel textLabel2 = new JLabel();
    public PanelIntro(NV_DTO user){
        String Name = user.getTenv();
        setBackground(ColorUIResource.white);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        textLabel2.setText("Bắt tay vào làm việc thôi " + Name);
        textLabel1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        textLabel2.setFont(new Font("Times New Roman", Font.BOLD, 25));
        textLabel1.setForeground(new ColorUIResource(112, 49, 145));
        textLabel2.setForeground(new ColorUIResource(112, 49, 145));
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(iconLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        textLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        add(textLabel1, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        textLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.insets = new InsetsUIResource(10, 0, 0, 0);
        add(textLabel2, gbc);

    }
}
