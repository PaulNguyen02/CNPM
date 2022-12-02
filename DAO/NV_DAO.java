/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NV_DTO;
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
public class NV_DAO {
    private static String URL="jdbc:sqlserver://localhost:1433; DatabaseName=MiniStore24H;integratedSecurity=true" ;
    private static String User="paul"; 
    private static String Password="00000";
   private ArrayList<NV_DTO>listnv=new ArrayList<>();
   private NV_DTO nvdto;
   private String MANV, Name, Dob, Address, Phonenumber, Role, Pass ;
   private Connection getConnection(String URL, String User, String Password)
    {
        Connection conn=null;
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn=DriverManager.getConnection(URL, User, Password);
            System.out.println("connect successfully!");
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println("Connection Failed");
        }
        return conn;
    }
   public void Add(NV_DTO nvdto)         //Thao tác thêm trên SQL
   {
       try {
            Connection conn = getConnection(URL, User, Password);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO NHANVIEN VALUES('"+nvdto.getManv()+"','"+nvdto.getTenv()+"','"+nvdto.getNgsinh()+"','"+nvdto.getDchi()+"','"+nvdto.getSdt()+"','"+nvdto.getCvu()+"','"+nvdto.getPass()+"','"+0+"')"); 
        
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(NV_DAO.class.getName()).log(Level.SEVERE, null, ex);
            JFrame fr=new JFrame(); 
            JOptionPane.showMessageDialog(fr,"Trùng mã nhân viên");
        }    
   }
   public ArrayList<NV_DTO> View()
   {
       Connection conn = getConnection(URL, User, Password);
       try {
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select * from NHANVIEN where isdeleted='"+0+"'");
            while(rs.next())
            {
                MANV=rs.getString(1);
                Name=rs.getString(2);
                Dob=rs.getString(3);
                Address=rs.getString(4);
                Phonenumber=rs.getString(5);
                Role=rs.getString(6);
                Pass=rs.getString(7);
                nvdto=new NV_DTO(MANV,Name,Dob,Address,Phonenumber,Role,Pass);
                listnv.add(nvdto);
            }
            conn.close();
        }catch (SQLException ex) {
            Logger.getLogger(NV_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return listnv;
   }
   public void Edit(NV_DTO nvdto, String isdeleted)         //Thao tác thêm trên SQL
   {
       try {
            Connection conn = getConnection(URL, User, Password);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE NHANVIEN SET MANV='"+nvdto.getManv()+"', TEN='"+nvdto.getTenv()+"', NGSINH='"+nvdto.getNgsinh()+"', DCHI='"
            +nvdto.getDchi()+"' , SDT='"+nvdto.getSdt()+"', CVU='"+nvdto.getCvu()+"', PASS='"+nvdto.getPass()+"', isdeleted = '" + isdeleted + "' WHERE MANV='"+nvdto.getManv()+"'"); 
        
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(NV_DAO.class.getName()).log(Level.SEVERE, null, ex);
            JFrame fr=new JFrame(); 
            JOptionPane.showMessageDialog(fr,"Trùng mã nhân viên");
        }    
   }
   public void Delete(String selectedid)         //Thao tác thêm trên SQL
   {
       try {
            Connection conn = getConnection(URL, User, Password);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE NHANVIEN SET ISDELETED='"+1+"' WHERE MANV='"+selectedid+"'"); 
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(NV_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
   }
   public ArrayList<NV_DTO> Search(String search)
   {
       Connection conn = getConnection(URL, User, Password);
       try {
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select * from NHANVIEN where ten='"+search+"' and isdeleted='"+0+"'");
            while(rs.next())
            {
                MANV=rs.getString(1);
                Name=rs.getString(2);
                Dob=rs.getString(3);
                Address=rs.getString(4);
                Phonenumber=rs.getString(5);
                Role=rs.getString(6);
                Pass=rs.getString(7);
                nvdto=new NV_DTO(MANV,Name,Dob,Address,Phonenumber,Role,Pass);
                listnv.add(nvdto);
            }
            
            conn.close();
        }catch (SQLException ex) {
            Logger.getLogger(NV_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return listnv;
   }

   public NV_DTO getNV(String id)
   {
       Connection conn = getConnection(URL, User, Password);
       NV_DTO NV = null;
       try {
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select * from NHANVIEN where MANV='"+id+"' and isdeleted="+0+"");
            if (rs.next()){
                MANV = rs.getString(1);
                Name = rs.getString(2);
                Dob = rs.getString(3);
                Address = rs.getString(4);
                Phonenumber = rs.getString(5);
                Role = rs.getString(6);
                Pass = rs.getString(7);
                NV = new NV_DTO(MANV, Name, Dob, Address, Phonenumber, Role, Pass);
            }
            conn.close();
        }catch (SQLException ex) {
            Logger.getLogger(NV_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return NV;
   }
}
