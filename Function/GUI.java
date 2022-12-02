package Function;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;

public class GUI {
 
    public GUI(){}

    public JLabel getJLabelImage(String Icon_Name){
        ImageIcon img = new ImageIcon(getClass().getResource("/Icon/" + Icon_Name));
        JLabel label = new JLabel(img);
        return label;
    }

    public ImageIcon getImg(String Icon_Name){
        ImageIcon img = new ImageIcon(getClass().getResource("/Icon/" + Icon_Name));
        return img;
    }
    public void setFont(JLabel label ,int Type, int Size){
        switch (Type){
            case 0:
                label.setFont(new FontUIResource("Times New Roman", FontUIResource.PLAIN, Size));
            break;
            case 1:
                label.setFont(new FontUIResource("Times New Roman", FontUIResource.BOLD, Size));
            break;
            case 2:
                label.setFont(new FontUIResource("Times New Roman", FontUIResource.ITALIC, Size));
            break;
            case 3:
                label.setFont(new FontUIResource("Times New Roman", FontUIResource.ITALIC | FontUIResource.BOLD, Size));
            break;
        }
        
    }
    public void setFont(JButton button ,int Type, int Size){
        switch (Type){
            case 0:
                button.setFont(new FontUIResource("Times New Roman", FontUIResource.PLAIN, Size));
            break;
            case 1:
                button.setFont(new FontUIResource("Times New Roman", FontUIResource.BOLD, Size));
            break;
            case 2:
                button.setFont(new FontUIResource("Times New Roman", FontUIResource.ITALIC, Size));
            break;
            case 3:
                button.setFont(new FontUIResource("Times New Roman", FontUIResource.ITALIC | FontUIResource.BOLD, Size));
            break;
        }
        
    }
    public void setFont(JTextField text ,int Type, int Size){
        switch (Type){
            case 0:
                text.setFont(new FontUIResource("Times New Roman", FontUIResource.PLAIN, Size));
            break;
            case 1:
                text.setFont(new FontUIResource("Times New Roman", FontUIResource.BOLD, Size));
            break;
            case 2:
                text.setFont(new FontUIResource("Times New Roman", FontUIResource.ITALIC, Size));
            break;
            case 3:
                text.setFont(new FontUIResource("Times New Roman", FontUIResource.ITALIC | FontUIResource.BOLD, Size));
            break;
        }
        
    }
    public void setFont(JPasswordField passwd ,int Type, int Size){
        switch (Type){
            case 0:
                passwd.setFont(new FontUIResource("Times New Roman", FontUIResource.PLAIN, Size));
            break;
            case 1:
                passwd.setFont(new FontUIResource("Times New Roman", FontUIResource.BOLD, Size));
            break;
            case 2:
                passwd.setFont(new FontUIResource("Times New Roman", FontUIResource.ITALIC, Size));
            break;
            case 3:
                passwd.setFont(new FontUIResource("Times New Roman", FontUIResource.ITALIC | FontUIResource.BOLD, Size));
            break;
        }
        
    }
}
