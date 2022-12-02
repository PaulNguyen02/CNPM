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

import BLL.CTHD_BLL;
import BLL.Discount_BLL;
import BLL.HD_BLL;
import BLL.SP_BLL;
import BLL.Statistic_BLL;
import DTO.CTHD_DTO;
import DTO.Discount_DTO;
import DTO.HD_DTO;
import DTO.NV_DTO;
import DTO.SP_DTO;
import Function.GUI;
import Function.ITextPDF;
import Phuc.Time;

public class Bill_Details extends JFrame{

    protected JFrame frame;
    protected NV_DTO worker;
    protected HD_DTO Bill;
    protected ArrayList<CTHD_DTO> details = new ArrayList<>();
    protected ArrayList<SP_DTO> products = new ArrayList<>();
    protected int Total_Price = 0;
    protected int Final_Price = 0;
    protected GUI gui = new GUI();
    protected ITextPDF exportPDF = new ITextPDF();

    protected JPanel Panel_Input = new JPanel();
    protected JPanel Panel_Manger = new JPanel();
    protected JPanel Panel_Product = new JPanel();

    protected JTextField txtf_bill_id = new JTextField();
    protected JTextField txtf_worker_id = new JTextField();
    protected JTextField txtf_TotalPrice = new JTextField();
    protected JTextField txtf_ProductID = new JTextField();
    protected JTextField txtf_ProductQuantity = new JTextField();
    protected JTextField txtf_Received = new JTextField();
    protected JTextField txtf_Remainder = new JTextField();
    protected JTextField txtf_FinalPrice = new JTextField();
    protected JTextField txtf_SetQuantiy = new JTextField();

    protected JLabel jlb_bill_id = new JLabel("Mã hóa đơn");
    protected JLabel jlb_worker_id = new JLabel("Mã nhân viên");
    protected JLabel jlb_TotalPrice = new JLabel("Tổng Tiền");
    protected JLabel jlb_ProductID = new JLabel("Mã sản phẩm");
    protected JLabel jlb_ProductQuantity = new JLabel("Số lượng");
    protected JLabel jlb_Received = new JLabel("Đã nhận");
    protected JLabel jlb_Remainder = new JLabel("Thối lại");
    protected JLabel jlb_Diveder_Bill = new JLabel("Hóa đơn:");
    protected JLabel jlb_Diveder_Product = new JLabel("Số lượng sản phẩm:");
    protected JLabel jlb_FinalPrice = new JLabel("Thành tiền");
    protected JLabel jlb_Product = new JLabel("Thao tác trên hóa đơn:");
    
    protected JTable table = new JTable(){
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
    protected ButtonCustomed btn_rmProduct = new ButtonCustomed("Xóa Sản phẩm");
    protected ButtonCustomed btn_Calculate = new ButtonCustomed("Tính tiền");
    protected ButtonCustomed btn_SaveBill = new ButtonCustomed("Thanh toán");
    protected ButtonCustomed btn_SetQuantity = new ButtonCustomed("Đặt lại");
    protected ButtonCustomed btn_ReInput = new ButtonCustomed("Nhập lại");

    public Bill_Details(NV_DTO worker){
        this.worker = worker;
        Bill = new HD_DTO("HD"+String.valueOf((new CTHD_BLL()).MAHD()));
        frame = this;
        setSize(750, 550);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setup();
    }

    protected void setup(){

        initPanelInput();
        initPanelProduct();
        initPanelManager();
        initPanel();
        tablePane.setPreferredSize(new DimensionUIResource(400, 300));
        
        gui.setFont(btn_addProduct, 1, 16);
        gui.setFont(btn_rmProduct, 1, 16);
        gui.setFont(btn_SetQuantity, 1, 16);
        gui.setFont(btn_SaveBill, 1, 16);
        gui.setFont(btn_ReInput, 1, 16);
        gui.setFont(btn_Calculate, 1, 16);

        btn_SaveBill.setEnabled(false);
        
        btn_Calculate.setBackground(new ColorUIResource(116, 47, 158));
        btn_ReInput.setBackground(new ColorUIResource(116, 47, 158));
        btn_SaveBill.setBackground(new ColorUIResource(116, 47, 158));
        btn_SetQuantity.setBackground(new ColorUIResource(116, 47, 158));
        btn_rmProduct.setBackground(new ColorUIResource(219, 37, 65));

        btn_Calculate.setColorHover(new ColorUIResource(181, 113, 209));
        btn_ReInput.setColorHover(new ColorUIResource(181, 113, 209));
        btn_SaveBill.setColorHover(new ColorUIResource(181, 113, 209));
        btn_SetQuantity.setColorHover(new ColorUIResource(116, 47, 158));
        btn_rmProduct.setColorHover(new ColorUIResource(148, 16, 37));

        gui.setFont(txtf_bill_id, 0, 16);
        gui.setFont(txtf_ProductID, 0, 16);
        gui.setFont(txtf_Received, 0, 16);
        gui.setFont(txtf_worker_id, 0, 16);
        gui.setFont(txtf_TotalPrice, 0, 16);
        gui.setFont(txtf_ProductQuantity, 0, 16);
        gui.setFont(txtf_Remainder, 0, 16);
        gui.setFont(txtf_FinalPrice, 0, 16);
        gui.setFont(btn_SetQuantity, 1, 16);

        gui.setFont(jlb_bill_id, 1, 16);
        gui.setFont(jlb_ProductID, 1, 16);
        gui.setFont(jlb_Received, 1, 16);
        gui.setFont(jlb_worker_id, 1, 16);
        gui.setFont(jlb_TotalPrice, 1, 16);
        gui.setFont(jlb_ProductQuantity, 1, 16);
        gui.setFont(jlb_Remainder, 1, 16);
        gui.setFont(jlb_Diveder_Bill, 0, 14);
        gui.setFont(jlb_Diveder_Product, 0, 14);
        gui.setFont(jlb_Product, 0, 14);
        gui.setFont(jlb_FinalPrice, 1, 16);
        
        DimensionUIResource sizeOfTxtF = new DimensionUIResource(110, 30);

        txtf_bill_id.setText(Bill.getMahd());
        txtf_bill_id.setEditable(false);
        txtf_worker_id.setText(worker.getManv());
        txtf_worker_id.setEditable(false);

        txtf_TotalPrice.setText(Total_Price+"");
        txtf_TotalPrice.setEditable(false);
        txtf_TotalPrice.setPreferredSize(sizeOfTxtF);

        txtf_Received.setPreferredSize(sizeOfTxtF);

        txtf_Remainder.setEditable(false);
        txtf_Remainder.setPreferredSize(sizeOfTxtF);

        txtf_FinalPrice.setEditable(false);
        txtf_FinalPrice.setPreferredSize(sizeOfTxtF);

        txtf_ProductID.setPreferredSize(new DimensionUIResource(60, 30));
        txtf_ProductQuantity.setPreferredSize(new DimensionUIResource(60, 30));
        txtf_SetQuantiy.setPreferredSize(sizeOfTxtF);
        
        table.getTableHeader().setReorderingAllowed(false);
        tablePane.setViewportView(table);

        btn_Calculate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                calculatePriceEvent();
            }
        });

        btn_addProduct.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
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
        
        btn_SaveBill.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                saveBillEvent();
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
        Panel_Input.add(jlb_bill_id, gb);
        
        gb.gridx=1;
        gb.gridy=0;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(txtf_bill_id, gb);

        gb.gridx=0;
        gb.gridy=1;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(jlb_worker_id, gb);
        
        gb.gridx=1;
        gb.gridy=1;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(txtf_worker_id, gb);
        
        gb.gridx=0;
        gb.gridy=2;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(jlb_TotalPrice, gb);

        gb.gridx=1;
        gb.gridy=2;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(txtf_TotalPrice, gb);

        gb.gridx=0;
        gb.gridy=3;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(jlb_FinalPrice, gb);

        gb.gridx=1;
        gb.gridy=3;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(txtf_FinalPrice, gb);
        
        gb.gridx=0;
        gb.gridy=4;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(jlb_Received, gb);

        gb.gridx=1;
        gb.gridy=4;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(txtf_Received, gb);

        gb.gridx=0;
        gb.gridy=5;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(btn_Calculate, gb);

        gb.gridx=0;
        gb.gridy=6;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(jlb_Remainder, gb);

        gb.gridx=1;
        gb.gridy=6;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Input.add(txtf_Remainder, gb);
    }

    private void initPanelProduct(){
        Panel_Product.setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        gb.insets = new InsetsUIResource(5, 5, 5, 5);
        
        DimensionUIResource sizeOfBtn = new DimensionUIResource(80, 30);

        btn_addProduct.setPreferredSize(sizeOfBtn);
        btn_rmProduct.setPreferredSize(sizeOfBtn);
        
        //Header Sản phẩm
        gb.gridx = 0;
        gb.gridy = 0;
        Panel_Product.add(jlb_Product, gb);

        //mã sản phẩm
        gb.gridx=0;
        gb.gridy=1; 
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Product.add(jlb_ProductID, gb);
        
        gb.gridx=1;
        gb.gridy=1;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Product.add(txtf_ProductID, gb);

        //Số lượng sản phẩm
        gb.gridx=0;
        gb.gridy=2;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Product.add(jlb_ProductQuantity, gb);

        gb.gridx=1;
        gb.gridy=2;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Product.add(txtf_ProductQuantity, gb);
        
        //Nút thêm/xóa sản phẩm

        
        gb.gridx=2;
        gb.gridy=1;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Product.add(btn_addProduct, gb);

        gb.gridx=0;
        gb.gridy=3;
        gb.fill= GridBagConstraints.HORIZONTAL;
        Panel_Product.add(btn_rmProduct, gb);

    }
    private void initPanelManager(){
        Panel_Manger.setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        gb.insets = new InsetsUIResource(5, 5, 5, 5);

        btn_SaveBill.setPreferredSize(new DimensionUIResource(110, 30));
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
        Panel_Manger.add(btn_SaveBill, gb);
        
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
            int price;
            int discount = 0;
            String ProductID = txtf_ProductID.getText();
            Discount_DTO DsC;
            if (ProductID.equals("")) throw new NullPointerException();
            int ProductQuantity = Integer.parseInt(txtf_ProductQuantity.getText());
            if (ProductQuantity == 0) throw new NumberFormatException();
            
            SP_DTO product = (new SP_BLL()).Find(ProductID);
            if (product == null) {
                return;
            }
            if (checkDuplicate(ProductID) != -1) {
                int index = checkDuplicate(ProductID);
                price = ProductQuantity * product.getDongia();
                DsC = (new Discount_BLL()).getDiscount(ProductID);
                if (DsC != null) {
                    discount = DsC.getDiscount(ProductID);
                }
                price -= price * discount;
                details.get(index).setSoluong(ProductQuantity+details.get(index).getSoluong());
                details.get(index).setTotal(price+details.get(index).getTotal());
                rebuildTable();
                return;
            }


            if(product.getSl() < ProductQuantity) {

                MyMessageAlert alert = new MyMessageAlert(frame, "Không đủ sản phẩm (SL còn: " + product.getSl() + ")");
                alert.setVisible(true);
                return;

            }

            price = ProductQuantity * product.getDongia();
            DsC = (new Discount_BLL()).getDiscount(ProductID);
            String DiscID = "null";
            if (DsC != null) {
                DiscID = DsC.getID();
                discount = DsC.getDiscount(ProductID);
            }
            price -= price * discount;
            products.add(product);
            details.add(
                    new CTHD_DTO(Bill.getMahd(), ProductID, ProductQuantity, DiscID, price));

            rebuildTable();
        } catch (NumberFormatException NumbE) { 
            MyMessageAlert alert = new MyMessageAlert(frame, "Số lượng sản phẩm không hợp lệ");
            alert.setVisible(true);
        } catch (NullPointerException NullE){
            MyMessageAlert alert = new MyMessageAlert(frame, "Hãy nhập mã sản phẩm");
            alert.setVisible(true);
        }
    }

    public void removeProductEvent(){
        try {
            int index = table.getSelectedRow();
            Total_Price -= details.get(index).getSoluong()*products.get(index).getDongia();
            Final_Price -= details.get(index).getTotal();
            details.remove(index);
            products.remove(index);
            rebuildTable();
            
            txtf_FinalPrice.setText(Final_Price + "");
            txtf_TotalPrice.setText(Total_Price + "");
        } catch (Exception e) {
            
            MyMessageAlert alert = new MyMessageAlert(frame, "Hãy chọn 1 sản phẩm để xóa");
            alert.setVisible(true);
        }
    }

    public void calculatePriceEvent(){
        try {
            int received = Integer.parseInt(txtf_Received.getText());
            int remainder = received - Final_Price;
            if (remainder >= 0){
                btn_SaveBill.setEnabled(true);
            }
            else    throw new NumberFormatException();
            txtf_Remainder.setText(remainder+"");
        } catch (NumberFormatException e) {
            MyMessageAlert alert = new MyMessageAlert(frame, "Tiền nhận không hợp lệ");
            alert.setVisible(true);
        }
    }

    public void reinputQuantityEvent(){
        try {
            int index = table.getSelectedRow();
            String ProductID = details.get(index).getMasp();
            SP_DTO product = (new SP_BLL()).Find(ProductID);

            Total_Price -= details.get(index).getSoluong()*product.getDongia();
            int ProductQuantity = Integer.parseInt(txtf_SetQuantiy.getText());
            int discount = 0;

            details.get(index).setSoluong(ProductQuantity);

            Final_Price -= details.get(index).getTotal();

            Discount_DTO DsC = (new Discount_BLL()).getDiscount(ProductID);
            if (DsC != null) {
                discount = DsC.getDiscount(ProductID);
            }
            int price = product.getDongia() * ProductQuantity;
            Total_Price += price;

            price -= price * discount;
            details.get(index).setTotal(price);
            Final_Price += price;

            txtf_FinalPrice.setText(Final_Price + "");
            txtf_TotalPrice.setText(Total_Price + "");
            rebuildTable();
        } catch (NumberFormatException e) {
            MyMessageAlert alert = new MyMessageAlert(frame, "Số lượng sản phẩm không hợp lệ");
            alert.setVisible(true);
        }
    }

    public void saveBillEvent(){
        try {
            Bill.setManv(txtf_worker_id.getText());
            Bill.setTongtien(Final_Price);
            Bill.setNgxuat((new Time()).toString());

            LocalDate date = LocalDate.now();
            int Sold = 0;
            for (CTHD_DTO cthd_DTO : details) {
                Sold += cthd_DTO.getSoluong();
            }

            (new Statistic_BLL()).addData(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), Final_Price/1000, Sold);
            (new HD_BLL()).Save(Bill, details);
            exportPDF.createDoc(Bill, details, products, Integer.parseInt(txtf_Received.getText()));

            MyMessageAlert alert = new MyMessageAlert(frame, "Thanh toán thành công!");
            alert.setVisible(true);
            dispose();
        } catch (Exception e) {
            MyMessageAlert alert = new MyMessageAlert(frame, "Thanh toán thất bại");
            
            alert.setVisible(true);
        }
    }


    public void reinputEvent(){
        details = new ArrayList<>();
        products = new ArrayList<>();
        rebuildTable();
        Final_Price = 0;
        Total_Price = 0;
        
        txtf_FinalPrice.setText("0");
        txtf_TotalPrice.setText("0");
    }

    protected int checkDuplicate(String ProductID){
        for (int i = 0; i< products.size(); i++) {
            if (products.get(i).getMasp().equals(ProductID))
                return i;
        }
        return -1;
    }

    protected void rebuildTable(){
        DefaultTableModel model = new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Mã", "Tên", "Số Lượng", "Đơn giá", "Tổng tiền", "Thành tiền"
            }
        );
        Total_Price = 0;
        Final_Price = 0;
        table.setModel(model);
        for (int i = 0; i < details.size(); i++) {
            
            model.addRow(new Object[]{ details.get(i).getMasp(), products.get(i).getTensp(), details.get(i).getSoluong(),
                         products.get(i).getDongia(), (details.get(i).getSoluong()*products.get(i).getDongia()), details.get(i).getTotal() });
            Total_Price += (details.get(i).getSoluong()*products.get(i).getDongia());
            Final_Price += details.get(i).getTotal();
        }
        txtf_FinalPrice.setText(Final_Price+"");
        txtf_TotalPrice.setText(Total_Price+"");

    }
}
