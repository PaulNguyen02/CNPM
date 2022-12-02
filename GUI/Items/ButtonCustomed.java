package GUI.Items;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class ButtonCustomed extends JButton {

    private Color background = new Color(69, 191, 71);
    private Color colorHover = new Color(76, 206, 78);
    private Color colorPressed = new Color(63, 175, 65);
    private boolean mouseOver = false;

    public ButtonCustomed() {
        init();
    }

    public ButtonCustomed(String Text) {
        setText(Text);
        init();
    }

    private void init() {
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBackground(background);
        setForeground(Color.WHITE);
        setOpaque(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseOver = true;
                ButtonCustomed.super.setBackground(getColorHover());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseOver = false;
                ButtonCustomed.super.setBackground(background);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                ButtonCustomed.super.setBackground(getColorPressed());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (mouseOver) {
                    ButtonCustomed.super.setBackground(getColorHover());
                } else {
                    ButtonCustomed.super.setBackground(background);
                }
            }
        });
    }

    @Override
    public void setBackground(Color bg) {
        background = bg;
        super.setBackground(bg);
    }

    public Color getColorHover() {
        return colorHover;
    }

    public void setColorHover(Color colorHover) {
        this.colorHover = colorHover;
    }

    public Color getColorPressed() {
        return colorPressed;
    }

    public void setColorPressed(Color colorPressed) {
        this.colorPressed = colorPressed;
    }

}