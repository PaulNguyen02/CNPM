package GUI.Items;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

import Function.MyEvent;
import GUI.Items.Model_Menu.MenuType;

public class ListMenuItem<E extends Object> extends JList<E>{
    private final DefaultListModel<E> model;
    private int selectedIndex = -1;
    private MyEvent event;
    
    public void addEventMenuSelected(MyEvent event){
        this.event = event;
    }
    public ListMenuItem(){
        model = new DefaultListModel<E>(); 
        setModel(model);
        setOpaque(false);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)){
                    int index = locationToIndex(e.getPoint());
                    Object o = model.getElementAt(index);
                    if (o instanceof Model_Menu){
                        Model_Menu menu = (Model_Menu)o;
                        if (menu.getType() == MenuType.MENU){
                            selectedIndex = index;
                            if (event != null){
                                event.selected(index);
                            }
                        }
                    }
                    else{
                        selectedIndex = index;
                    }
                    repaint();
                }
            }
        });
    }
    @Override
    public ListCellRenderer<? super E> getCellRenderer(){
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                Model_Menu data;
                if (value instanceof Model_Menu){
                    data = (Model_Menu)value;
                }
                else{
                    data = new Model_Menu("", value + "", MenuType.EMPTY);
                }
                MenuItem item = new MenuItem(data);
                item.setSelected(selectedIndex == index);
                return item;
            }
        };
    }

    public void addItem(E data){
        model.addElement(data);;
    }

    
    
}
