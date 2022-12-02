package GUI.Items;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.table.DefaultTableModel;

import BLL.DonNhan_BLL;
import DTO.DonNhan_DTO;
import DTO.NV_DTO;
import Function.GUI;

public class InputPane extends JPanel{
    private MyTable table = new MyTable(0);
    private ButtonCustomed btn_add = new ButtonCustomed   ("  Thêm  ");
    private ButtonCustomed btn_del = new ButtonCustomed   ("   Xóa  ");
    private ButtonCustomed btn_edit = new ButtonCustomed  ("    Sửa    ");
    private ButtonCustomed btn_search = new ButtonCustomed("Tìm kiếm");
    
    private JComboBox<String> method = new JComboBox<>(new String[]{ "Mã đơn nhận" , "Ngày Nhập" });

    private JTextField txtf_search = new JTextField();

    private JScrollPane scrollTable = new JScrollPane();
    private JPanel controler = new JPanel();

    private NV_DTO usr;
    private GUI gui = new GUI();
    private ArrayList<DonNhan_DTO> inputs = new ArrayList<>();
    private DonNhan_BLL donNhan_BLL = new DonNhan_BLL();

    public InputPane(NV_DTO worker){
        usr = worker;
        setup();
    }

    private void initTable(){
        scrollTable.setViewportView(table);
        scrollTable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollTable.setVerticalScrollBar(new MyScrollBar());
        scrollTable.setPreferredSize(new DimensionUIResource(700, 600));
        add(scrollTable);
    }

    private void initControler(){
        controler.setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        
        gb.insets = new InsetsUIResource(5, 5, 5, 5);

        gb.gridx = 0;
        gb.gridy = 0;
        gb.fill = GridBagConstraints.HORIZONTAL;
        controler.add(btn_add, gb);
        
        gb.gridx = 1;
        gb.gridy = 0;
        gb.fill = GridBagConstraints.HORIZONTAL;
        controler.add(btn_del, gb);
        
        gb.gridx = 2;
        gb.gridy = 0;
        gb.fill = GridBagConstraints.HORIZONTAL;
        controler.add(btn_edit, gb);
  
        gb.gridx = 0;
        gb.gridy = 1;
        gb.fill = GridBagConstraints.HORIZONTAL;
        controler.add(method, gb);
 
        gb.gridx = 0;
        gb.gridy = 2;
        gb.gridwidth = 2;
        gb.fill = GridBagConstraints.HORIZONTAL;
        controler.add(txtf_search, gb);
        
        gb.gridx = 2;
        gb.gridy = 2;
        gb.fill = GridBagConstraints.HORIZONTAL;
        controler.add(btn_search, gb);

        add(controler, BorderLayout.EAST);
    }

    private void setup(){
        gui.setFont(btn_add, 0, 16);
        gui.setFont(btn_del, 0, 16);
        gui.setFont(btn_edit, 0, 16);
        gui.setFont(btn_search, 0, 16);
        
        gui.setFont(txtf_search, 0, 20);
        

        initTable();
        initControler();
        inputs = donNhan_BLL.View();
        rebuildTable();
        btn_search.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                searchEvent();
            }
        });
        btn_add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                addEvent();
            }
        });
        btn_del.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                deleteEvent();
            }
        });
        btn_edit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                editEvent();
            }
        });
    }

    private void rebuildTable(){
        DefaultTableModel model = new DefaultTableModel(new String[][]{}, 
                                                        new String[]{"Mã Đơn", "Ngày nhập", "Người nhập", "Tổng tiền"});
        table.setModel(model);
        if (inputs.size() == 0 || inputs == null)
            return;
        for (DonNhan_DTO donNhan_DTO : inputs) {
            model.addRow(new String[]{donNhan_DTO.getMadn(), donNhan_DTO.getNgnhan(), donNhan_DTO.getManv(), donNhan_DTO.getTong()+""});
        }
    }

    private void editEvent(){
        int index = table.getSelectedRow();
        if (index < 0){
            MyMessageAlert alert = new MyMessageAlert(new JFrame(), "Hãy chọn 1 đơn để chỉnh sửa");
            alert.setVisible(true);
            return;
        }
        String ID = inputs.get(index).getMadn();
        new editOrder(usr, ID);
        rebuildTable();
    }

    private void searchEvent(){
        if (method.getSelectedIndex() == 1){
            inputs = donNhan_BLL.filterDate(txtf_search.getText());
            rebuildTable();
            return;
        }
        inputs = donNhan_BLL.filterID(txtf_search.getText());
        rebuildTable();
        return;
    }

    private void addEvent(){
        new NewOrder(usr);
    }
    private void deleteEvent(){
        int index = table.getSelectedRow();
        if (index == -1){
            MyMessageAlert alert = new MyMessageAlert(new JFrame(), "Hãy chọn 1 đơn để xóa");
            alert.setVisible(true);
            return;
        }
        String ID = inputs.get(index).getMadn();
        System.out.println(ID);
        donNhan_BLL.deleteData(ID);
        inputs.remove(index);
        rebuildTable();
    }

}
