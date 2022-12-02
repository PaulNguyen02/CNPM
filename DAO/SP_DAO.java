package DAO;
import BLL.SP_BLL;
import DTO.NV_DTO;
import DTO.SP_DTO;
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

import org.apache.poi.ss.formula.functions.T;

/**
 *
 * @author Paul
 */
public class SP_DAO {
    private final String URL="jdbc:sqlserver://localhost:1433; DatabaseName=MiniStore24H;integratedSecurity=true" ;
    private final String User="paul"; 
    private final String Password="00000";
    private ArrayList <SP_DTO> listsp =new ArrayList();
    //private ArrayList <SP_DTO> listsp1 =new ArrayList();
    private String a,b,e,f;
    private int c,d;
    private SP_DTO spdto;
    private SP_BLL spbll;
    private String search;
    public SP_DAO() {
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
    public ArrayList<SP_DTO> Search(int search)
    {
        spbll=new SP_BLL();
       Connection conn = getConnection(URL, User, Password);
       try {
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select * from SANPHAM where gia='"+search+"'and isdeleted='"+0+"'");
            while(rs.next())
            {
                a=rs.getString(1);
                b=rs.getString(2);
                c=rs.getInt(3);
                d=rs.getInt(4);
                e=rs.getString(5);
                f=rs.getString(6);
                spdto=new SP_DTO(a,b,c,d,e,f);
                listsp.add(spdto);
            }
            conn.close();
       }catch (SQLException ex) {
            Logger.getLogger(SP_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
       return listsp;
    }
    public ArrayList<SP_DTO> Search1(String search)
    {
        spbll=new SP_BLL();
       Connection conn = getConnection(URL, User, Password);
       try {
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select * from SANPHAM where masp='"+search+"' and isdeleted='"+0+"'");
            while(rs.next())
            {
                a=rs.getString(1);
                b=rs.getString(2);
                c=rs.getInt(3);
                d=rs.getInt(4);
                e=rs.getString(5);
                f=rs.getString(6);
                spdto=new SP_DTO(a,b,c,d,e,f);
                listsp.add(spdto);
            }
            conn.close();
       }catch (SQLException ex) {
            Logger.getLogger(SP_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
       return listsp;
    }
    public ArrayList<SP_DTO> View()      
    {
       spbll=new SP_BLL();
       Connection conn = getConnection(URL, User, Password);
       try {
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select * from SANPHAM where isdeleted='"+0+"'");
            while(rs.next())
            {
                a=rs.getString(1);
                b=rs.getString(2);
                c=rs.getInt(3);
                d=rs.getInt(4);
                e=rs.getString(5);
                f=rs.getString(6);
                spdto=new SP_DTO(a,b,c,d,e,f);
                listsp.add(spdto);
            }
            conn.close();
       }catch (SQLException ex) {
            Logger.getLogger(SP_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
       return listsp;
    }
    public ArrayList<SP_DTO> Candy()      
    {
       spbll=new SP_BLL();
       Connection conn = getConnection(URL, User, Password);
       try {
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select * from SANPHAM where LOAI='Candy' and isdeleted='"+0+"'");
            while(rs.next())
            {
                a=rs.getString(1);
                b=rs.getString(2);
                c=rs.getInt(3);
                d=rs.getInt(4);
                e=rs.getString(5);
                f=rs.getString(6);
                spdto=new SP_DTO(a,b,c,d,e,f);
                listsp.add(spdto);
            }
            conn.close();
       }catch (SQLException ex) {
            Logger.getLogger(SP_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
       return listsp;
    }
    public ArrayList<SP_DTO> Cookie()      
    {
       spbll=new SP_BLL();
       Connection conn = getConnection(URL, User, Password);
       try {
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select * from SANPHAM where LOAI='Cookie' and isdeleted='"+0+"'");
            while(rs.next())
            {
                a=rs.getString(1);
                b=rs.getString(2);
                c=rs.getInt(3);
                d=rs.getInt(4);
                e=rs.getString(5);
                f=rs.getString(6);
                spdto=new SP_DTO(a,b,c,d,e,f);
                listsp.add(spdto);
            }
            conn.close();
       }catch (SQLException ex) {
            Logger.getLogger(SP_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
       return listsp;
    }
    public ArrayList<SP_DTO> Drink()      
    {
       spbll=new SP_BLL();
       Connection conn = getConnection(URL, User, Password);
       try {
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select * from SANPHAM where LOAI='Drink' and isdeleted='"+0+"'");
            while(rs.next())
            {
                a=rs.getString(1);
                b=rs.getString(2);
                c=rs.getInt(3);
                d=rs.getInt(4);
                e=rs.getString(5);
                f=rs.getString(6);
                spdto=new SP_DTO(a,b,c,d,e,f);
                listsp.add(spdto);
            }
            conn.close();
       }catch (SQLException ex) {
            Logger.getLogger(SP_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
       return listsp;
    }
    public ArrayList<SP_DTO> FastFood()      
    {
       spbll=new SP_BLL();
       Connection conn = getConnection(URL, User, Password);
       try {
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select * from SANPHAM where LOAI='FastFood' and isdeleted='"+0+"'");
            while(rs.next())
            {
                a=rs.getString(1);
                b=rs.getString(2);
                c=rs.getInt(3);
                d=rs.getInt(4);
                e=rs.getString(5);
                f=rs.getString(6);
                spdto=new SP_DTO(a,b,c,d,e,f);
                listsp.add(spdto);
            }
            conn.close();
       }catch (SQLException ex) {
            Logger.getLogger(SP_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
       return listsp;
    }
    public ArrayList<SP_DTO> Fruit()      
    {
       spbll=new SP_BLL();
       Connection conn = getConnection(URL, User, Password);
       try {
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select * from SANPHAM where LOAI='Fruit' and isdeleted='"+0+"'");
            while(rs.next())
            {
                a=rs.getString(1);
                b=rs.getString(2);
                c=rs.getInt(3);
                d=rs.getInt(4);
                e=rs.getString(5);
                f=rs.getString(6);
                spdto=new SP_DTO(a,b,c,d,e,f);
                listsp.add(spdto);
            }
            conn.close();
       }catch (SQLException ex) {
            Logger.getLogger(SP_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
       return listsp;
    }
    public ArrayList<SP_DTO> Noodle()      
    {
       spbll=new SP_BLL();
       Connection conn = getConnection(URL, User, Password);
       try {
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select * from SANPHAM where LOAI='Noodle' and isdeleted='"+0+"'");
            while(rs.next())
            {
                a=rs.getString(1);
                b=rs.getString(2);
                c=rs.getInt(3);
                d=rs.getInt(4);
                e=rs.getString(5);
                f=rs.getString(6);
                spdto=new SP_DTO(a,b,c,d,e,f);
                listsp.add(spdto);
            }
            conn.close();
       }catch (SQLException ex) {
            Logger.getLogger(SP_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
       return listsp;
    }
    public void Add(SP_DTO spdto)
    {
        try {
            Connection conn = getConnection(URL, User, Password);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO SANPHAM VALUES('"+spdto.getMasp()+"','"+spdto.getTensp()
            +"','"+spdto.getSl()+"','"+spdto.getDongia()+"','"+ spdto.getLoai()+"','"+spdto.getNcc()+"','"+0+"')");
        
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SP_DAO.class.getName()).log(Level.SEVERE, null, ex);
            JFrame fr=new JFrame(); 
            JOptionPane.showMessageDialog(fr,"Trùng mã sản phẩm");
        }
    }
    public void Edit(SP_DTO spdto, String selectedid)
    {
        try {
            Connection conn = getConnection(URL, User, Password);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE SANPHAM SET MASP='"+spdto.getMasp()+"', TENSP='"+spdto.getTensp()+"', SL='"+spdto.getSl()+
            "', GIA='"+spdto.getDongia()+"' , LOAI='"+spdto.getLoai()+"', MANCC='"+spdto.getNcc()+"' WHERE MASP='"+selectedid+"'");
        
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SP_DAO.class.getName()).log(Level.SEVERE, null, ex); 
            JFrame fr=new JFrame(); 
            JOptionPane.showMessageDialog(fr,"Trùng mã sản phẩm");
        }
    }
    public void Delete(String selectedid)
    {
        try {
            Connection conn = getConnection(URL, User, Password);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE SANPHAM SET ISDELETED='"+1+"' WHERE MASP='"+selectedid+"'");
        
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SP_DAO.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }

    public SP_DTO find(String ID){
        SP_DTO product = null;
        try {
            Connection conn = getConnection(URL, User, Password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from sanpham where masp ='"+ID+"' and isdeleted = 0");
            if(rs.next()){
                product = new SP_DTO(ID, rs.getString(2), rs.getInt(3), rs.getInt(4));
            }
            else{
                JOptionPane optionPane = new JOptionPane("Không tìm thấy sản phẩm");
                optionPane.setVisible(true);
            }
            conn.close();
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return product;
    }
}
