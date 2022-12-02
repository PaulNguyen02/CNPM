package GUI.Items;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.table.DefaultTableModel;

import BLL.DonNhan_BLL;
import DTO.CTDN_DTO;
import DTO.DonNhan_DTO;
import DTO.NV_DTO;
import Function.GUI;

public class NewOrder extends JFrame{

    private JFrame frame;
    protected DonNhan_DTO Order;
    private NV_DTO worker;
    protected ArrayList<CTDN_DTO> orderDetails = new ArrayList<>();
    protected int Total_Price = 0;
    protected GUI gui = new GUI();

    private JPanel Panel_Input = new JPanel();
    private JPanel Panel_Manger = new JPanel();
    private JPanel Panel_Product = new JPanel();

    private JTextField txtf_order_id = new JTextField();
    //private JComboBox<String> Type = new JComboBox<>();
    private JTextField txtf_ProductID = new JTextField();
    private JTextField txtf_ProductID1 = new JTextField();
    private JTextField txtf_ProductQuantity = new JTextField();
    private JTextField txtf_Price = new JTextField();
    private JTextField txtf_TotalPrice = new JTextField();
    private JTextField txtf_Quantity = new JTextField();
    private JTextField txtf_SetQuantiy = new JTextField();

    private JLabel jlb_order_id = new JLabel("Mã đơn nhận");
    private JLabel jlb_ProductID = new JLabel("Mã sản phẩm");
    private JLabel jlb_ProductID1 = new JLabel("Mã sản phẩm");
    private JLabel jlb_ProductQuantity = new JLabel("Số lượng");
    private JLabel jlb_Price = new JLabel("Đơn giá");
    private JLabel jlb_ToTalPrice = new JLabel("Tổng giá trị");
    private JLabel jlb_Diveder_Bill = new JLabel("Hóa đơn:");
    private JLabel jlb_Diveder_Product = new JLabel("Số lượng sản phẩm:");
    private JLabel jlb_Quantiy = new JLabel("Số lượng");
    private JLabel jlb_Product = new JLabel("Thao tác trên hóa đơn:");


    
    private JTable table = new JTable(){
        @Override
        public boolean editCellAt(int row, int column) {
            return false;
        };

        @Override
        public boolean editCellAt(int row, int column, java.util.EventObject e) {
            return false;
        };
    };

    protected JScrollPane tablePane = new JScrollPane();
    protected ButtonCustomed btn_addProduct = new ButtonCustomed("Thêm");
    protected ButtonCustomed btn_rmProduct = new ButtonCustomed("Xóa");
    protected ButtonCustomed btn_Save = new ButtonCustomed("Thanh toán");
    protected ButtonCustomed btn_SetQuantity = new ButtonCustomed("Đặt lại");
    protected ButtonCustomed btn_ReInput = new ButtonCustomed("Nhập lại");

    public NewOrder(NV_DTO worker){
        this.worker = worker;
        frame = this;
        setSize(750, 550);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setup();
    }

    private void setup(){
        Order = new DonNhan_DTO((new DonNhan_BLL()).getNewID(), worker.getManv());
        
        
        
        initPanelInput();
        initPanelProduct();
        initPanelManager();
        initPanel();
        tablePane.setPreferredSize(new DimensionUIResource(400, 300));
        
        gui.setFont(btn_rmProduct, 1, 16);
        gui.setFont(btn_SetQuantity, 1, 16);
        gui.setFont(btn_Save, 1, 16);
        gui.setFont(btn_ReInput, 1, 16);
        gui.setFont(btn_addProduct, 1, 16);

        btn_Save.setEnabled(false);
        
        btn_ReInput.setBackground(new ColorUIResource(116, 47, 158));
        btn_Save.setBackground(new ColorUIResource(116, 47, 158));
        btn_SetQuantity.setBackground(new ColorUIResource(116, 47, 158));
        btn_rmProduct.setBackground(new ColorUIResource(219, 37, 65));

        btn_ReInput.setColorHover(new ColorUIResource(181, 113, 209));
        btn_Save.setColorHover(new ColorUIResource(181, 113, 209));
        btn_SetQuantity.setColorHover(new ColorUIResource(116, 47, 158));
        btn_rmProduct.setColorHover(new ColorUIResource(148, 16, 37));

        gui.setFont(txtf_order_id, 0, 16);
        gui.setFont(txtf_ProductID1, 0, 16);
        gui.setFont(txtf_Price, 0, 16);
        gui.setFont(txtf_ProductID, 0, 16);
        gui.setFont(txtf_ProductQuantity, 0, 16);
        gui.setFont(txtf_TotalPrice, 0, 16);
        gui.setFont(txtf_Quantity, 0, 16);
        gui.setFont(btn_SetQuantity, 1, 16);

        gui.setFont(jlb_order_id, 1, 16);
        gui.setFont(jlb_ProductID1, 1, 16);
        gui.setFont(jlb_Price, 1, 16);
        //gui.setFont(jlb_type, 1, 16);
        gui.setFont(jlb_ProductID, 1, 16);
        gui.setFont(jlb_ProductQuantity, 1, 16);
        gui.setFont(jlb_ToTalPrice, 1, 16);
        gui.setFont(jlb_Diveder_Bill, 0, 14);
        gui.setFont(jlb_Diveder_Product, 0, 14);
        gui.setFont(jlb_Product, 0, 14);
        gui.setFont(jlb_Quantiy, 1, 16);
        
        DimensionUIResource sizeOfTxtF = new DimensionUIResource(110, 30);

        txtf_order_id.setText(Order.getMadn());
        txtf_order_id.setEditable(false);

        txtf_ProductID.setText(Total_Price+"");

        txtf_ProductID.setPreferredSize(sizeOfTxtF);

        txtf_Price.setPreferredSize(sizeOfTxtF);

        txtf_TotalPrice.setEditable(false);
        txtf_TotalPrice.setPreferredSize(sizeOfTxtF);

        txtf_Quantity.setPreferredSize(sizeOfTxtF);

        txtf_ProductID1.setPreferredSize(new DimensionUIResource(60, 30));
        txtf_ProductQuantity.setPreferredSize(new DimensionUIResource(60, 30));
        txtf_SetQuantiy.setPreferredSize(sizeOfTxtF);
        
        table.getTableHeader().setReorderingAllowed(false);
        tablePane.setViewportView(table);


        btn_addProduct.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                btn_Save.setEnabled(true);
                addProductEvent();
            }
        });

        btn_rmProduct.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                removeProductEvent();
            }
        });

        

        btn_SetQuantity.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                reinputQuantityEvent();
            }
        });
        
        btn_Save.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                saveDataEvent();
            }
        });

        btn_ReInput.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                reinputEvent();
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    
    private void initPanelInput(){
        Panel_Input.setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        gb.insets = new InsetsUIResource(5, 5, 5, 5);
       
        gb.gridx=0;
        gb.gridy=0;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(jlb_order_id, gb);
        
        gb.gridx=1;
        gb.gridy=0;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(txtf_order_id, gb);

        // gb.gridx=0;
        // gb.gridy=1;
        // gb.fill= GridBagConstraints.HORIZONTAL;
        // Panel_Input.add(jlb_type, gb);
        
        // gb.gridx=1;
        // gb.gridy=1;
        // gb.fill= GridBagConstraints.HORIZONTAL;
        // Panel_Input.add(Type, gb);
        
        gb.gridx=0;
        gb.gridy=2;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(jlb_ProductID, gb);

        gb.gridx=1;
        gb.gridy=2;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(txtf_ProductID, gb);

        gb.gridx=0;
        gb.gridy=3;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(jlb_Quantiy, gb);

        gb.gridx=1;
        gb.gridy=3;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(txtf_Quantity, gb);
        
        gb.gridx=0;
        gb.gridy=4;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(jlb_Price, gb);

        gb.gridx=1;
        gb.gridy=4;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(txtf_Price, gb);

        gb.gridx=0;
        gb.gridy=5;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(btn_addProduct, gb);

        gb.gridx=1;
        gb.gridy=5;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(btn_rmProduct, gb);

        gb.gridx=0;
        gb.gridy=6;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(jlb_ToTalPrice, gb);

        gb.gridx=1;
        gb.gridy=6;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(txtf_TotalPrice, gb);
    }

    private void initPanelProduct(){
        
        Panel_Product.add(gui.getJLabelImage("order.png"));

    }
    private void initPanelManager(){
        Panel_Manger.setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        gb.insets = new InsetsUIResource(5, 5, 5, 5);

        btn_Save.setPreferredSize(new DimensionUIResource(110, 30));
        btn_ReInput.setPreferredSize(new DimensionUIResource(110, 30));
        
        //Chỉnh sửa sản phẩm
        gb.gridx=0;
        gb.gridy=0; 
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Manger.add(jlb_Diveder_Product, gb);

        gb.gridx=0;
        gb.gridy=1; 
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Manger.add(txtf_SetQuantiy, gb);
        
        gb.gridx=1;
        gb.gridy=1;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Manger.add(btn_SetQuantity, gb);

        //Thao tác hóa đơn
        gb.gridx=0;
        gb.gridy=2; 
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Manger.add(jlb_Diveder_Bill, gb);

        gb.gridx=0;
        gb.gridy=3; 
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Manger.add(btn_Save, gb);
        
        gb.gridx=1;
        gb.gridy=3;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Manger.add(btn_ReInput, gb);

    }
    
    private void initPanel(){
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        gb.insets = new InsetsUIResource(5, 10, 5, 10);

        gb.gridx=0;
        gb.gridy=0; 
        gb.fill= GridBagConstraints.HORIZONTAL;
        add(tablePane, gb);
        
        gb.gridx=1;
        gb.gridy=0;
        gb.fill= GridBagConstraints.HORIZONTAL;
        add(Panel_Input, gb);

        gb.gridx=0;
        gb.gridy=1; 
        gb.fill= GridBagConstraints.HORIZONTAL;
        add(Panel_Product, gb);
        
        gb.gridx=1;
        gb.gridy=1;
        gb.fill= GridBagConstraints.HORIZONTAL;
        add(Panel_Manger, gb);
    }

    public void addProductEvent(){
        try {
            String ProductID = txtf_ProductID.getText();
            if (checkDuplicate(ProductID)){
                MyMessageAlert alert = new MyMessageAlert(frame, "Trùng mã sản phẩm");
                alert.setVisible(true);
                return;
            }
            String OrderID = txtf_order_id.getText();
            int quantity = Integer.parseInt(txtf_Quantity.getText());
            int price = Integer.parseInt(txtf_Price.getText());
            orderDetails.add(new CTDN_DTO(OrderID, ProductID, quantity, price));
            Total_Price += quantity*price;
            txtf_TotalPrice.setText(Total_Price+"");
            rebuildTable();
        } catch (Exception E) { 
            MyMessageAlert alert = new MyMessageAlert(frame, "Dữ liệu nhập không hợp lệ");
            alert.setVisible(true);
        }
    }

    public void removeProductEvent(){
        try {
            int index = table.getSelectedRow();
            Total_Price -= orderDetails.get(index).getGia() * orderDetails.get(index).getSl();
            orderDetails.remove(index);
            txtf_TotalPrice.setText(Total_Price + "");
            if (orderDetails.size() == 0)   btn_Save.setEnabled(false);
            rebuildTable();
        } catch (Exception e) {
            
            MyMessageAlert alert = new MyMessageAlert(frame, "Hãy chọn 1 sản phẩm để xóa");
            alert.setVisible(true);
        }
    }

    

    public void reinputQuantityEvent(){
        try {
            int index = table.getSelectedRow();
            Total_Price -= orderDetails.get(index).getGia() * orderDetails.get(index).getSl();
            int newQuantity = Integer.parseInt(txtf_SetQuantiy.getText());
            orderDetails.get(index).setSl(newQuantity);

            txtf_TotalPrice.setText(Total_Price + "");
            rebuildTable();
        } catch (NumberFormatException e) {
            MyMessageAlert alert = new MyMessageAlert(frame, "Số lượng sản phẩm không hợp lệ");
            alert.setVisible(true);
        }
    }

    public void saveDataEvent(){
        try {
            Order.setTong(Total_Price);
            LocalDate date = LocalDate.now();
            Order.setNgnhan(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            (new DonNhan_BLL()).saveData(Order, orderDetails);
            
            MyMessageAlert alert = new MyMessageAlert(frame, "Nhập hàng thành công!");
            alert.setVisible(true);
            dispose();
        } catch (Exception e) {
            MyMessageAlert alert = new MyMessageAlert(frame, "Nhập hàng thất bại");
            
            alert.setVisible(true);
        }
    }


    public void reinputEvent(){
        orderDetails = new ArrayList<>();
        rebuildTable();
        Total_Price = 0;
        
        txtf_Quantity.setText("0");
        txtf_ProductID.setText("0");
    }

    private boolean checkDuplicate(String ProductID){
        for (CTDN_DTO product : orderDetails) {
            if (product.getMasp().equals(ProductID))
                return true;
        }
        return false;
    }

    protected void rebuildTable(){
        DefaultTableModel model = new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Mã SP", "Số Lượng", "Đơn giá", "Tổng tiền"
            }
        );
        Total_Price = 0;
        table.setModel(model);
        for (int i = 0; i < orderDetails.size(); i++) {
            
            model.addRow(new Object[]{ orderDetails.get(i).getMasp(), orderDetails.get(i).getSl(),
                         orderDetails.get(i).getGia(), (orderDetails.get(i).getGia()*orderDetails.get(i).getSl())});
                Total_Price += orderDetails.get(i).getGia()*orderDetails.get(i).getSl();
            
        }
        txtf_TotalPrice.setText(Total_Price+"");
    }
}
