package Phuc;

import BLL.SP_BLL;
import DTO.NV_DTO;
import DTO.SP_DTO;
import Function.GUI;
import GUI.Items.ButtonCustomed;
import GUI.Items.MyTable;
import GUI.Items.NewOrder;

import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Paul
 */
public class SanPham extends javax.swing.JPanel {

    /**
     * Creates new form SanPham
     */
    private String MASP, Name, SL, Loai, Gia, MANCC;
    private int sl;
    private int gia;
    private SP_BLL spbll;
    private static int i=0;
    private SP_DTO spdto;
    private NV_DTO user;
    public SanPham(NV_DTO user) {
        this.user = user;
        initComponents();
        bt2ActionPerformed();
    }

    private Hashtable <String, String> InpType = new Hashtable<>();
    
    MyTable inputTable = new MyTable(0);
    
    private void initComponents() {

        GUI gui = new GUI();        


        jScrollPane1 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable(){
            @Override
            public boolean editCellAt(int row, int column) {
                return false;
            };

            @Override
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            };
        };
        tb.getTableHeader().setReorderingAllowed(false);
        lb0 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        tf2 = new javax.swing.JTextField();
        tf3 = new javax.swing.JTextField();
        tf4 = new javax.swing.JTextField();
        tf6 = new javax.swing.JTextField();
        lb8 = new javax.swing.JLabel();
        tf7 = new javax.swing.JTextField();
        bt14 = new ButtonCustomed();
        bt5 = new ButtonCustomed();
        bt6 = new ButtonCustomed();
        bt7 = new ButtonCustomed();
        bt1 = new ButtonCustomed();
        bt2 = new ButtonCustomed();
        bt3 = new ButtonCustomed();
        bt4 = new ButtonCustomed();
        bt8 = new ButtonCustomed();
        bt9 = new ButtonCustomed();
        bt10 = new ButtonCustomed();
        bt11 = new ButtonCustomed();
        bt12 = new ButtonCustomed();
        bt13 = new ButtonCustomed();
        cbx = new javax.swing.JComboBox<>();

        gui.setFont(tf1, 0, 16);
        gui.setFont(tf2, 0, 16);
        gui.setFont(tf3, 0, 16);
        gui.setFont(tf4, 0, 16);
        gui.setFont(tf6, 0, 16);
        gui.setFont(tf7, 0, 16);

        bt1.setBackground(new ColorUIResource(116, 47, 158));
        bt2.setBackground(new ColorUIResource(116, 47, 158));
        bt3.setBackground(new ColorUIResource(116, 47, 158));
        bt4.setBackground(new ColorUIResource(116, 47, 158));
        bt5.setBackground(new ColorUIResource(116, 47, 158));
        bt6.setBackground(new ColorUIResource(116, 47, 158));
        bt7.setBackground(new ColorUIResource(116, 47, 158));
        bt8.setBackground(new ColorUIResource(116, 47, 158));
        bt9.setBackground(new ColorUIResource(116, 47, 158));
        bt10.setBackground(new ColorUIResource(116, 47, 158));
        bt11.setBackground(new ColorUIResource(116, 47, 158));
        bt12.setBackground(new ColorUIResource(116, 47, 158));
        bt13.setBackground(new ColorUIResource(116, 47, 158));
        bt14.setBackground(new ColorUIResource(116, 47, 158));

        bt1.setColorHover(new ColorUIResource(181, 113, 209));
        bt2.setColorHover(new ColorUIResource(181, 113, 209));
        bt3.setColorHover(new ColorUIResource(181, 113, 209));
        bt4.setColorHover(new ColorUIResource(181, 113, 209));
        bt5.setColorHover(new ColorUIResource(181, 113, 209));
        bt6.setColorHover(new ColorUIResource(181, 113, 209));
        bt7.setColorHover(new ColorUIResource(181, 113, 209));
        bt8.setColorHover(new ColorUIResource(181, 113, 209));
        bt9.setColorHover(new ColorUIResource(181, 113, 209));
        bt10.setColorHover(new ColorUIResource(181, 113, 209));
        bt11.setColorHover(new ColorUIResource(181, 113, 209));
        bt12.setColorHover(new ColorUIResource(181, 113, 209));
        bt13.setColorHover(new ColorUIResource(181, 113, 209));
        bt14.setColorHover(new ColorUIResource(181, 113, 209));
        
        
        InpType.put("Bánh", "Cookie");
        InpType.put("Kẹo", "Candy");
        InpType.put("Nước", "Drink");
        InpType.put("Thức ăn nhanh", "FastFood");
        InpType.put("Trái cây", "Fruit");
        InpType.put("Mỳ", "Noodle");

        tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "MASP", "Tên Sản phẩm", "Số lượng", "Đơn giá", "Loại Sản phẩm", "MANCC"
            }
        ));
        jScrollPane1.setViewportView(tb);

        lb0.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb0.setIcon(new javax.swing.ImageIcon("G:\\QLCH\\QLCH\\Icons\\title.png")); // NOI18N
        lb0.setText("Sản phẩm");

        lb1.setText("Mã sản phẩm");

        lb2.setText("Tên sản phẩm");

        lb3.setText("Số lượng");

        lb4.setText("Đơn giá");

        lb5.setText("Loại SP");

        lb6.setText("MANCC");

        lb8.setText("Search");

        bt14.setText("Search");
        bt14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt14ActionPerformed(evt);
            }
        });

        bt5.setIcon(new javax.swing.ImageIcon("G:\\QLCH\\QLCH\\Icons\\add.png")); // NOI18N
        bt5.setText("Add Row");
        bt5.setIcon(gui.getImg("add.png"));
        bt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt5ActionPerformed(evt);
            }
        });

        bt6.setIcon(new javax.swing.ImageIcon("G:\\QLCH\\QLCH\\Icons\\delete.png")); // NOI18N
        bt6.setText("Delete Row");
        bt6.setIcon(gui.getImg("delete.png"));
        bt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt6ActionPerformed(evt);
            }
        });

        bt7.setIcon(new javax.swing.ImageIcon("G:\\QLCH\\QLCH\\Icons\\clear.png")); // NOI18N
        bt7.setText("Clear");
        bt7.setIcon(gui.getImg("clear.png"));
        bt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt7ActionPerformed(evt);
            }
        });

        bt1.setIcon(new javax.swing.ImageIcon("G:\\QLCH\\QLCH\\Icons\\add1.png")); // NOI18N
        bt1.setText("Thêm");
        bt1.setIcon(gui.getImg("add1.png"));
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });

        bt2.setIcon(new javax.swing.ImageIcon("G:\\QLCH\\QLCH\\Icons\\look.png")); // NOI18N
        bt2.setText("Xem");
        bt2.setIcon(gui.getImg("look.png"));
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed();
            }
        });

        bt3.setIcon(new javax.swing.ImageIcon("G:\\QLCH\\QLCH\\Icons\\edit.png")); // NOI18N
        bt3.setText("Sửa");
        bt3.setIcon(gui.getImg("edit.png"));
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });

        bt4.setIcon(new javax.swing.ImageIcon("G:\\QLCH\\QLCH\\Icons\\delete1.png")); // NOI18N
        bt4.setText("Xóa");
        bt4.setIcon(gui.getImg("delete1.png"));
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });

        bt8.setIcon(new javax.swing.ImageIcon("G:\\QLCH\\QLCH\\Icons\\cake.png")); // NOI18N
        bt8.setText("Bánh");
        bt8.setIcon(gui.getImg("cake.png"));
        bt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt8ActionPerformed(evt);
            }
        });

        bt9.setIcon(new javax.swing.ImageIcon("G:\\QLCH\\QLCH\\Icons\\candy.png")); // NOI18N
        bt9.setText("Kẹo");
        bt9.setIcon(gui.getImg("candy.png"));
        bt9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt9ActionPerformed(evt);
            }
        });

        bt10.setIcon(new javax.swing.ImageIcon("G:\\QLCH\\QLCH\\Icons\\drink.png")); // NOI18N
        bt10.setText("Nước");
        bt10.setIcon(gui.getImg("drink.png"));
        bt10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt10ActionPerformed(evt);
            }
        });

        bt11.setIcon(new javax.swing.ImageIcon("G:\\QLCH\\QLCH\\Icons\\fastfood.png")); // NOI18N
        bt11.setText("Thức ăn nhanh");
        bt11.setIcon(gui.getImg("fastfood.png"));
        bt11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt11ActionPerformed(evt);
            }
        });

        bt12.setIcon(new javax.swing.ImageIcon("G:\\QLCH\\QLCH\\Icons\\fruit.png")); // NOI18N
        bt12.setText("Trái cây");
        bt12.setIcon(gui.getImg("fruit.png"));
        bt12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt12ActionPerformed(evt);
            }
        });

        bt13.setIcon(new javax.swing.ImageIcon("G:\\QLCH\\QLCH\\Icons\\noodle.png")); // NOI18N
        bt13.setText("Mỳ");
        bt13.setIcon(gui.getImg("noodle.png"));
        bt13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt13ActionPerformed(evt);
            }
        });

        cbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bánh", "Kẹo", "Nước", "Thức ăn nhanh", "Trái cây", "Mỳ" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb8)
                                .addGap(18, 18, 18)
                                .addComponent(tf7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bt14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 66, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bt11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bt8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bt12, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(bt9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt13, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bt3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt10, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bt1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bt4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt2, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb0)
                                .addGap(95, 95, 95))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb1)
                                    .addComponent(lb2)
                                    .addComponent(lb3)
                                    .addComponent(lb4)
                                    .addComponent(lb5)
                                    .addComponent(lb6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf6, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(tf4)
                                    .addComponent(tf3)
                                    .addComponent(tf2)
                                    .addComponent(tf1)
                                    .addComponent(cbx, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(16, 16, 16))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt7)
                            .addComponent(bt6)
                            .addComponent(bt5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lb0)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbx, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tf6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lb6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt8)
                    .addComponent(bt9)
                    .addComponent(bt10)
                    .addComponent(bt1)
                    .addComponent(bt2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt11)
                    .addComponent(bt12)
                    .addComponent(bt13)
                    .addComponent(bt3)
                    .addComponent(bt4))
                .addGap(29, 29, 29))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt5ActionPerformed
        DefaultTableModel models = (DefaultTableModel)tb.getModel();
        models.addRow(new Object[] {});
    }//GEN-LAST:event_bt5ActionPerformed

    private void bt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt6ActionPerformed
        DefaultTableModel models = (DefaultTableModel)tb.getModel();
        models.removeRow(tb.getSelectedRow());
    }//GEN-LAST:event_bt6ActionPerformed

    private void bt7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt7ActionPerformed
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");
        tf6.setText("");
        for(int i=0;i<tb.getRowCount();i++)
        {
            if(tb.isRowSelected(i))
            {
                 tb.setValueAt("", i, 0);
                 tb.setValueAt("", i, 1);
                 tb.setValueAt("", i, 2);
                 tb.setValueAt("", i, 3);
                 tb.setValueAt("", i, 4);
                 tb.setValueAt("", i, 5);
            }
        }
    }//GEN-LAST:event_bt7ActionPerformed

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        DefaultTableModel models = (DefaultTableModel)tb.getModel(); 
        try
        {
            // spbll=new SP_BLL();
            // MASP=tf1.getText();
            // Name=tf2.getText();
            // sl=Integer.parseInt(tf3.getText());
            // gia=Integer.parseInt(tf4.getText());
            // Loai= InpType.get(String.valueOf(cbx.getSelectedItem()));

            // System.out.println(Loai);

            // MANCC=tf6.getText();      
            // spdto=new SP_DTO(MASP,Name,sl,gia,Loai,MANCC);
            // spbll.Add(spdto);
            // tb.setValueAt(MASP, i,0);
            // tb.setValueAt(Name, i,1);
            // tb.setValueAt(sl, i,2);
            // tb.setValueAt(gia, i,3);
            // tb.setValueAt(spdto.getLoaiVN(), i,4);
            // tb.setValueAt(MANCC, i,5);
            // models.addRow(new Object[] {});
            // i++;      
            NewOrder order = new NewOrder(user);
        }
        catch (NumberFormatException ne)
        {
            JFrame fr=new JFrame(); 
            JOptionPane.showMessageDialog(fr,"Điền thông tin vào các trường");
        }
    }//GEN-LAST:event_bt1ActionPerformed

    private void bt2ActionPerformed() {//GEN-FIRST:event_bt2ActionPerformed
        spbll=new SP_BLL();
        DefaultTableModel models = (DefaultTableModel)tb.getModel();
        for(int i=0;i<spbll.View().size();i++)
        {
            tb.setValueAt(spbll.View().get(i).getMasp(), i, 0);
            tb.setValueAt(spbll.View().get(i).getTensp(), i, 1);
            tb.setValueAt(spbll.View().get(i).getSl(), i, 2);
            tb.setValueAt(spbll.View().get(i).getDongia(), i, 3);
            tb.setValueAt(spbll.View().get(i).getLoaiVN(), i, 4);
            tb.setValueAt(spbll.View().get(i).getNcc(), i, 5);
            models.addRow(new Object[] {});
        }        
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
       if(tb.getSelectedRowCount()==1)
        {
            if(tb.getSelectedRowCount()==1)
            {
                spbll=new SP_BLL();
                String selectedID=String.valueOf(tb.getValueAt(tb.getSelectedRow(),0));     //Chọn 1 hàng cần chỉnh sửa
                MASP=tf1.getText();
                Name=tf2.getText();
                sl=Integer.parseInt(tf3.getText());
                gia=Integer.parseInt(tf4.getText());
                Loai=String.valueOf(cbx.getSelectedItem());
                MANCC=tf6.getText();
                spdto=new SP_DTO(MASP,Name,sl,gia,Loai,MANCC);
                spbll.Edit(spdto, selectedID);
                tb.setValueAt(MASP, tb.getSelectedRow(),0);       //Cập nhật trên table
                tb.setValueAt(Name, tb.getSelectedRow(),1);
                tb.setValueAt(sl, tb.getSelectedRow(),2);
                tb.setValueAt(gia, tb.getSelectedRow(),3);
                tb.setValueAt(Loai, tb.getSelectedRow(),4);
                tb.setValueAt(MANCC, tb.getSelectedRow(),5);
        }else if(tb.getSelectedRowCount()==0)
        {
            JFrame fr=new JFrame(); 
            JOptionPane.showMessageDialog(fr,"Chọn 1 trường để chỉnh sửa");
        }
        else
        {
            JFrame fr=new JFrame(); 
            JOptionPane.showMessageDialog(fr,"Bạn chỉ được chọn 1 trường để chỉnh sửa");
        }
        }
        else if(tb.getSelectedRowCount()<1) 
        {
            JFrame fr=new JFrame(); 
            JOptionPane.showMessageDialog(fr,"Chọn trường bạn muốn chỉnh sửa"); 
        }
        else
        {
            JFrame fr=new JFrame(); 
            JOptionPane.showMessageDialog(fr,"Bạn chỉ được chọn 1 trường để chỉnh sửa"); 
        }  
    }//GEN-LAST:event_bt3ActionPerformed

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed
        spbll=new SP_BLL();
       if(tb.getSelectedRowCount()==1)
       {
            String selectedID=String.valueOf(tb.getValueAt(tb.getSelectedRow(),0));
            spbll.Delete(selectedID);
            tb.setValueAt("", tb.getSelectedRow(), 0);       //Xóa trên table
            tb.setValueAt("", tb.getSelectedRow(), 1);
            tb.setValueAt("", tb.getSelectedRow(), 2);
            tb.setValueAt("", tb.getSelectedRow(), 3);
            tb.setValueAt("", tb.getSelectedRow(), 4);
            tb.setValueAt("", tb.getSelectedRow(), 5);   
        }
        else if(tb.getSelectedRowCount()==0)     
        {
            JFrame fr=new JFrame(); 
            JOptionPane.showMessageDialog(fr,"Chọn 1 trường để xóa");
        }
        else
        {
            JFrame fr=new JFrame(); 
            JOptionPane.showMessageDialog(fr,"Bạn chỉ được chọn 1 trường để xóa");
        }
    }//GEN-LAST:event_bt4ActionPerformed

    private void bt8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt8ActionPerformed
        spbll=new SP_BLL();
            DefaultTableModel models = (DefaultTableModel)tb.getModel();
            for(int i=0;i<spbll.Cookie().size();i++)
            {
                tb.setValueAt(spbll.Cookie().get(i).getMasp(), i, 0);
                tb.setValueAt(spbll.Cookie().get(i).getTensp(), i, 1);
                tb.setValueAt(spbll.Cookie().get(i).getSl(), i, 2);
                tb.setValueAt(spbll.Cookie().get(i).getDongia(), i, 3);
                tb.setValueAt(spbll.Cookie().get(i).getLoaiVN(), i, 4);
                tb.setValueAt(spbll.Cookie().get(i).getNcc(), i, 5);
                models.addRow(new Object[] {});
            }     
    }//GEN-LAST:event_bt8ActionPerformed

    private void bt9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt9ActionPerformed
        spbll=new SP_BLL();
            DefaultTableModel models = (DefaultTableModel)tb.getModel();
            for(int i=0;i<spbll.Candy().size();i++)
            {
                tb.setValueAt(spbll.Candy().get(i).getMasp(), i, 0);
                tb.setValueAt(spbll.Candy().get(i).getTensp(), i, 1);
                tb.setValueAt(spbll.Candy().get(i).getSl(), i, 2);
                tb.setValueAt(spbll.Candy().get(i).getDongia(), i, 3);
                tb.setValueAt(spbll.Candy().get(i).getLoaiVN(), i, 4);
                tb.setValueAt(spbll.Candy().get(i).getNcc(), i, 5);
                models.addRow(new Object[] {});
            }    
    }//GEN-LAST:event_bt9ActionPerformed

    private void bt10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt10ActionPerformed
        spbll=new SP_BLL();
            DefaultTableModel models = (DefaultTableModel)tb.getModel();
            for(int i=0;i<spbll.Drink().size();i++)
            {
                tb.setValueAt(spbll.Drink().get(i).getMasp(), i, 0);
                tb.setValueAt(spbll.Drink().get(i).getTensp(), i, 1);
                tb.setValueAt(spbll.Drink().get(i).getSl(), i, 2);
                tb.setValueAt(spbll.Drink().get(i).getDongia(), i, 3);
                tb.setValueAt(spbll.Drink().get(i).getLoaiVN(), i, 4);
                tb.setValueAt(spbll.Drink().get(i).getNcc(), i, 5);
                models.addRow(new Object[] {});
            }       
    }//GEN-LAST:event_bt10ActionPerformed

    private void bt11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt11ActionPerformed
        spbll=new SP_BLL();
            DefaultTableModel models = (DefaultTableModel)tb.getModel();
            for(int i=0;i<spbll.FastFood().size();i++)
            {
                tb.setValueAt(spbll.FastFood().get(i).getMasp(), i, 0);
                tb.setValueAt(spbll.FastFood().get(i).getTensp(), i, 1);
                tb.setValueAt(spbll.FastFood().get(i).getSl(), i, 2);
                tb.setValueAt(spbll.FastFood().get(i).getDongia(), i, 3);
                tb.setValueAt(spbll.FastFood().get(i).getLoaiVN(), i, 4);
                tb.setValueAt(spbll.FastFood().get(i).getNcc(), i, 5);
                models.addRow(new Object[] {});
            }     
    }//GEN-LAST:event_bt11ActionPerformed

    private void bt12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt12ActionPerformed
        spbll=new SP_BLL();
            DefaultTableModel models = (DefaultTableModel)tb.getModel();
            for(int i=0;i<spbll.Fruit().size();i++)
            {
                tb.setValueAt(spbll.Fruit().get(i).getMasp(), i, 0);
                tb.setValueAt(spbll.Fruit().get(i).getTensp(), i, 1);
                tb.setValueAt(spbll.Fruit().get(i).getSl(), i, 2);
                tb.setValueAt(spbll.Fruit().get(i).getDongia(), i, 3);
                tb.setValueAt(spbll.Fruit().get(i).getLoaiVN(), i, 4);
                tb.setValueAt(spbll.Fruit().get(i).getNcc(), i, 5);
                models.addRow(new Object[] {});
            }   
    }//GEN-LAST:event_bt12ActionPerformed

    private void bt13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt13ActionPerformed
       spbll=new SP_BLL();
            DefaultTableModel models = (DefaultTableModel)tb.getModel();
            for(int i=0;i<spbll.Noodle().size();i++)
            {
                tb.setValueAt(spbll.Noodle().get(i).getMasp(), i, 0);
                tb.setValueAt(spbll.Noodle().get(i).getTensp(), i, 1);
                tb.setValueAt(spbll.Noodle().get(i).getSl(), i, 2);
                tb.setValueAt(spbll.Noodle().get(i).getDongia(), i, 3);
                tb.setValueAt(spbll.Noodle().get(i).getLoaiVN(), i, 4);
                tb.setValueAt(spbll.Noodle().get(i).getNcc(), i, 5);
                models.addRow(new Object[] {});
            } 
    }//GEN-LAST:event_bt13ActionPerformed

    private void bt14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt14ActionPerformed
        spbll=new SP_BLL();
      String search=tf7.getText();
      DefaultTableModel models = (DefaultTableModel)tb.getModel();
      for(int i=0;i<spbll.Search(search).size();i++)
      {
        tb.setValueAt(spbll.Search(search).get(i).getMasp(), i, 0);
        tb.setValueAt(spbll.Search(search).get(i).getTensp(), i, 1);
        tb.setValueAt(spbll.Search(search).get(i).getSl(), i, 2);
        tb.setValueAt(spbll.Search(search).get(i).getDongia(), i, 3);
        tb.setValueAt(spbll.Search(search).get(i).getLoaiVN(), i, 4);
        tb.setValueAt(spbll.Search(search).get(i).getNcc(), i, 5);
        models.addRow(new Object[] {});
       }
    }//GEN-LAST:event_bt14ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonCustomed bt1;
    private ButtonCustomed bt10;
    private ButtonCustomed bt11;
    private ButtonCustomed bt12;
    private ButtonCustomed bt13;
    private ButtonCustomed bt14;
    private ButtonCustomed bt2;
    private ButtonCustomed bt3;
    private ButtonCustomed bt4;
    private ButtonCustomed bt5;
    private ButtonCustomed bt6;
    private ButtonCustomed bt7;
    private ButtonCustomed bt8;
    private ButtonCustomed bt9;
    private javax.swing.JComboBox<String> cbx;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb0;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb8;
    private javax.swing.JTable tb;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf6;
    private javax.swing.JTextField tf7;
    // End of variables declaration//GEN-END:variables
}