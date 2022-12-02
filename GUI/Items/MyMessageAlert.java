package GUI.Items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;

import Function.GUI;

public class MyMessageAlert extends JDialog{
    private JLabel message = new JLabel();
    private ButtonCustomed button = new ButtonCustomed("OK");

    public MyMessageAlert(JFrame frame, String Alert){
        
        super(frame, true);
        setUndecorated(true);
        setSize(320, 200);
        setBackground(ColorUIResource.WHITE);

        GUI gui = new GUI();

        message.setText(Alert);
        gui.setFont(message, 1, 20);
        gui.setFont(button, 1, 16);
        button.setForeground(new ColorUIResource(219, 37, 65));
        

        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        gb.insets = new InsetsUIResource(10, 2, 10, 2);
        gb.gridx = 0;
        gb.gridy = 0;
        add(gui.getJLabelImage("Alert.png"), gb);

        gb.gridx = 0;
        gb.gridy = 1;
        add(message, gb);

        gb.gridx = 0;
        gb.gridy = 2;
        add(button, gb);

        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });

        
        setLocationRelativeTo(null);
    }

}
