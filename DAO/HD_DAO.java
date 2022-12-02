/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CTHD_DTO;
import DTO.HD_DTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Paul
 */
public class HD_DAO {
    private final String URL="jdbc:sqlserver://localhost:1433; DatabaseName=MiniStore24H;integratedSecurity=true" ;
    private final String User="paul"; 
    private final String Password="00000";
    private HD_DTO hddto;
    private String a,b,c;
    private int d;
    private ArrayList <HD_DTO> listhd =new ArrayList<>(); 

    public HD_DAO() {
    }
    private Connection getConnection(String URL, String User, String Password)
    {
        Connection conn=null;
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn=DriverManager.getConnection(URL, User, Password);
            System.out.println("connect successfully!");
        }
        catch(Exception e)
        {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
        return conn;
    }
    public void Edit(HD_DTO hddto, String selectedid, ArrayList<CTHD_DTO> details)
    { 
        Connection conn = getConnection(URL, User, Password);
        try {
                Statement stmt = conn.createStatement();     
                stmt.executeUpdate("UPDATE HOADON SET MAHD='"+hddto.getMahd()+"', NGAYXUAT='"+hddto.getNgxuat()+"', MANV='"+hddto.getManv()+"', TONGTIEN='"+hddto.getTongtien()+"' WHERE MAHD='"+selectedid+"' ");    //Thực hiện cập nhật row khi ID trong csdl trùng với ID của hàng được chọn
        
                for (CTHD_DTO sp : details) {
                    stmt.executeUpdate("INSERT INTO cthd VALUES('"+sp.getMahd()+"','"+sp.getMasp()+"','"+sp.getSoluong()
                    +"','"+sp.getMakm()  +"','"+sp.getTotal()+"')"); 
                    stmt.executeUpdate("UPDATE SANPHAM SET SL=SL-'"+sp.getSoluong()+"' WHERE MASP='"+sp.getMasp()+"'"); 
                }
                conn.close();
            }catch (SQLException ex) {
            Logger.getLogger(HD_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    public void Delete(String selectedid )
    {
        Connection conn = getConnection(URL, User, Password);
        Statement stmt;
        try {
                   stmt = conn.createStatement();  //Xóa trên database
                   stmt.executeUpdate("UPDATE HOADON SET isdeleted='"+1+"' WHERE MAHD='"+selectedid+"'");
                   conn.close();
            } catch (SQLException ex) {
            Logger.getLogger(HD_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public ArrayList<HD_DTO> View()
    {
        Connection conn = getConnection(URL, User, Password);
       try {
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select MAHD, NgayXuat, MANV, Tongtien from HOADON where isdeleted='"+0+"'");
            while(rs.next())
            {
                a=rs.getString(1);
                b=rs.getString(2);
                c=rs.getString(3);
                d=Integer.parseInt(rs.getString(4));
                hddto=new HD_DTO(a,b,c,d);
                listhd.add(hddto);
            }
            conn.close();
       }catch (SQLException ex) {
            Logger.getLogger(HD_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
       return listhd;
    }
    public ArrayList<HD_DTO> ASC()
    {
        Connection conn = getConnection(URL, User, Password);
       try {
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select MAHD, NgayXuat, MANV, Tongtien from HOADON where isdeleted='"+0+"' ORDER BY Tongtien ASC");
            while(rs.next())
            {
                a=rs.getString(1);
                b=rs.getString(2);
                c=rs.getString(3);
                d=Integer.parseInt(rs.getString(4));
                hddto=new HD_DTO(a,b,c,d);
                listhd.add(hddto);
            }
            conn.close();
       }catch (SQLException ex) {
            Logger.getLogger(HD_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
       return listhd;
    }
    public ArrayList<HD_DTO> DESC()
    {
        Connection conn = getConnection(URL, User, Password);
       try {
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select MAHD, NgayXuat, MANV, Tongtien from HOADON where isdeleted='"+0+"' ORDER BY Tongtien DESC");
            while(rs.next())
            {
                a=rs.getString(1);
                b=rs.getString(2);
                c=rs.getString(3);
                d=Integer.parseInt(rs.getString(4));
                hddto=new HD_DTO(a,b,c,d);
                listhd.add(hddto);
            }
            conn.close();
       }catch (SQLException ex) {
            Logger.getLogger(HD_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
       return listhd;
    }
    public void Save(HD_DTO hoadon, ArrayList<CTHD_DTO>details )
    {
        Connection conn = getConnection(URL, User, Password);
        try {
            Statement stmt = conn.createStatement();  
            stmt.executeUpdate("INSERT INTO HOADON VALUES('"+hoadon.getMahd()+"','"+hoadon.getNgxuat()+"','"
            +hoadon.getManv()+"','"+hoadon.getTongtien()+"','"+0+"')");    
            
            for (CTHD_DTO sp : details) {
                stmt.executeUpdate("INSERT INTO cthd VALUES('"+sp.getMahd()+"','"+sp.getMasp()+"','"+sp.getSoluong()
                +"','"+sp.getMakm()  +"','"+sp.getTotal()+"')"); 
                stmt.executeUpdate("UPDATE SANPHAM SET SL=SL-'"+sp.getSoluong()+"' WHERE MASP='"+sp.getMasp()+"'"); 
            }                          
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CTHD_DAO.class.getName()).log(Level.SEVERE, null, ex);
            JFrame fr=new JFrame(); 
            JOptionPane.showMessageDialog(fr,"Trùng mã hóa đơn");
        }
    }
    
    
    public HD_DTO getBill(String ID){
        Connection conn = getConnection(URL, User, Password);
        HD_DTO bill = null;
        try {
            Statement stmt = conn.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from hoadon where mahd = '" + ID + "' and isdeleted = 0");
            if (rs.next()){
                bill = new HD_DTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bill;
    }

    
}
