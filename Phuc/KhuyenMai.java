/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Phuc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;

import BLL.Discount_BLL;
import DTO.CTKM_DTO;
import DTO.Discount_DTO;
import GUI.Items.ButtonCustomed;
import GUI.Items.MyMessageAlert;

/**
 *
 * @author Paul
 */
public class KhuyenMai extends javax.swing.JPanel {

    /**
     * Creates new form KhuyenMai
     */
    private Discount_DTO Discount = new Discount_DTO();
    private ArrayList<CTKM_DTO> details = new ArrayList<>();

    public KhuyenMai() {
        initComponents();
    }

    private void initComponents() {


        jScrollPane1 = new javax.swing.JScrollPane();
        
        jTable1 = new javax.swing.JTable() {
            @Override
            public boolean editCellAt(int row, int column) {
                return false;
            };

            @Override
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            };
        };
        jTable1.getTableHeader().setReorderingAllowed(false);
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf4 = new javax.swing.JTextField();
        Add = new ButtonCustomed();
        Del = new ButtonCustomed();
        jLabel6 = new javax.swing.JLabel();
        tf5 = new javax.swing.JTextField();
        setDiscount = new ButtonCustomed();
        Save = new ButtonCustomed();
        Refresh = new ButtonCustomed();
        jSeparator1 = new javax.swing.JSeparator();
        

        Discount.setID((new Discount_BLL().getNewID()));
        tf1.setEditable(false);
        tf1.setText(Discount.getID());
        
        Save.setColorHover(new ColorUIResource(181, 113, 209));
        Refresh.setColorHover(new ColorUIResource(181, 113, 209));
        setDiscount.setColorHover(new ColorUIResource(181, 113, 209));
        Del.setColorHover(new ColorUIResource(148, 16, 37));

        Save.setBackground(new ColorUIResource(116, 47, 158));
        Refresh.setBackground(new ColorUIResource(116, 47, 158));
        setDiscount.setBackground(new ColorUIResource(116, 47, 158));
        Del.setBackground(new ColorUIResource(219, 37, 65));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "MASP", "% Giảm"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Khuyến mãi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(115, 115, 115))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel2.setText("MAKM");

        jLabel3.setText("Ngày hiệu lực");

        jLabel4.setText("MASP");

        jLabel5.setText("% Giảm");

        Add.setText("Thêm");
        Add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                addingEvent();
            }
        });

        Del.setText("Xóa");
        Del.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                removeEvent();
            }
        });
        jLabel6.setText("% Giảm");

        setDiscount.setText("Đặt lại");
        setDiscount.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                reinputQuantityEvent();
            }
        });
        Save.setText("Lưu");
        Save.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                saveEvent();
            }
        });

        Refresh.setText("Làm mới");
        Refresh.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                refreshEvent();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(jLabel5)))
                            .addGap(47, 47, 47)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tf1)
                                .addComponent(tf2)
                                .addComponent(tf3)
                                .addComponent(tf4, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(tf5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(setDiscount))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Save)
                            .addGap(62, 62, 62)
                            .addComponent(Refresh))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Add)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Del)
                            .addGap(49, 49, 49))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tf3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tf4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Add)
                            .addComponent(Del))
                        .addGap(67, 67, 67)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setDiscount))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Save)
                            .addComponent(Refresh))
                        .addGap(25, 25, 25)
                        .addComponent(jSeparator1)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    protected void refreshEvent() {
        Discount.setID((new Discount_BLL()).getNewID());
        tf1.setText(Discount.getID());
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");
        tf4.setText("");
        details = new ArrayList<>();
        rebuildTable();
        
    }

    protected void saveEvent() {
        Discount.setNHL(tf2.getText());
        (new Discount_BLL()).saveData(Discount, details);
        MyMessageAlert alert = new MyMessageAlert(new JFrame(), "Lưu thành công!");
        alert.setVisible(true);
        refreshEvent();
    }

    protected void reinputQuantityEvent() {
        try {
            
            int index = jTable1.getSelectedRow();
            int newDiscount = Integer.parseInt(tf5.getText());
            details.get(index).setGIAM(newDiscount);
            rebuildTable();
        } catch (NumberFormatException NumbE) {
            
            MyMessageAlert alert = new MyMessageAlert(new JFrame(), "Phần trăm giảm bất hợp lý");
            alert.setVisible(true);
        }
    }

    protected void removeEvent() {
        int index = jTable1.getSelectedRow();
        details.remove(index);
        rebuildTable();
    }

    private void rebuildTable(){
        DefaultTableModel model = new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Mã Sản Phẩm", "% Giảm"
            }
        );
        jTable1.setModel(model);
        for (CTKM_DTO row : details) {
            model.addRow(new String[]{row.getMASP() ,""+row.getGIAM()});
        }
    }

    protected void addingEvent() {
        int Giam = Integer.parseInt(tf4.getText());
        if (Giam <= 0 || Giam > 99){
            MyMessageAlert alert = new MyMessageAlert(new JFrame(), "Phần trăm giảm bất hợp lý");
            alert.setVisible(true);
            return;
        }
        details.add(new CTKM_DTO(tf3.getText(), Giam));
        rebuildTable();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonCustomed Add;
    private ButtonCustomed Del;
    private ButtonCustomed Refresh;
    private ButtonCustomed setDiscount;
    private ButtonCustomed Save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf5;
    // End of variables declaration//GEN-END:variables
}
