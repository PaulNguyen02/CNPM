package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import DTO.CTDN_DTO;

public class CTDN_DAO {
    private final String URL="jdbc:sqlserver://localhost:1433; DatabaseName=MiniStore24H;integratedSecurity=true" ;
    private final String User="paul"; 
    private final String Password="00000";
    public CTDN_DAO() {
    }
    private Connection getConnection(String URL, String User, String Password)
    {
        Connection conn=null;
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn=DriverManager.getConnection(URL, User, Password);
        }
        catch(Exception e)
        {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
        return conn;
    }
    public void SaveUpdateData(CTDN_DTO detail)
    {
       Connection conn = getConnection(URL, User, Password);
       try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into ctdn values('"+detail.getMadn()+"', '"+detail.getMasp()+"', "
            +detail.getSl() + ", " + detail.getGia() +")");

            stmt.executeUpdate("update sanpham set sl=sl+"+detail.getSl()+", gia="+detail.getGia()+" where masp='"+detail.getMasp()+"'");
            conn.close();
       }catch (Exception ex) {
            ex.printStackTrace();
        } 
    }

    public void SaveRawData(CTDN_DTO detail){
        Connection conn = getConnection(URL, User, Password);
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into ctdn values('" + detail.getMadn() + "', '" + detail.getMasp() + "', "
                    + detail.getSl() + ", " + detail.getGia() + ")");

            stmt.executeUpdate("insert into sp values('" + detail.getMasp() + "','', '"
                    + detail.getSl() + ", " + detail.getGia() + ", '', 'VNVS', 0)");

            conn.close();
        }catch (Exception ex) {
             ex.printStackTrace();
         } 
     }

    public ArrayList<CTDN_DTO> pullData(String ID){
        Connection conn = getConnection(URL, User, Password);
        ArrayList<CTDN_DTO> data = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from ctdn where madn = '"+ID+"'");
            while (rs.next()) {
                data.add(new CTDN_DTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
            conn.close();
        } catch
         (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public void preUpdateData(ArrayList<CTDN_DTO> data){
        Connection conn = getConnection(URL, User, Password);
        try {
            Statement stmt = conn.createStatement();
            for (CTDN_DTO ctdn_DTO : data) {
                stmt.executeUpdate("update sanpham set sl = sl - "+ctdn_DTO.getSl()+" where masp = '" +ctdn_DTO.getMasp()+"'");
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateData(ArrayList<CTDN_DTO> data, String ID){
        Connection conn = getConnection(URL, User, Password);
        try {
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("delete from ctdn where madn = '"+ID+"'");
            for (CTDN_DTO ctdn_DTO : data) {
                stmt.executeUpdate("insert into ctdn values('"+ID+"', '"+ctdn_DTO.getMasp()+"', "+ctdn_DTO.getSl()+", "+ctdn_DTO.getGia()+") ");
                stmt.executeUpdate("update sanpham set sl = sl + "+ctdn_DTO.getSl()+" where masp = '" +ctdn_DTO.getMasp()+"'");
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
