/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DonNhan_DTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Paul
 */
public class DonNhan_DAO {
    private final String URL="jdbc:sqlserver://localhost:1433; DatabaseName=MiniStore24H;integratedSecurity=true" ;
    private final String User="paul";
    private final String Password="00000";
    private String madon, ngay, manv;
    private int total;
    private ArrayList<DonNhan_DTO>listdn=new ArrayList<>();
    private DonNhan_DTO dndto;
    public DonNhan_DAO() {
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
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println("Connection Failed");
        }
        return conn;
    }
    public void Add(DonNhan_DTO dndto)
    {
        try {
            Connection conn = getConnection(URL, User, Password);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO DONNHAN VALUES('" + dndto.getMadn() + "','" + dndto.getNgnhan()
                     + "','" + dndto.getManv() + "','" + dndto.getTong() + "', 0)"); 
                    
            conn.close();
        } 
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    public ArrayList<DonNhan_DTO>View()
    {
        Connection conn = getConnection(URL, User, Password);
        try 
        {    
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from DONNHAN where isdeleted = 0");
            while(rs.next())
            {
               madon=rs.getString(1);
               ngay=rs.getString(2);
               manv=rs.getString(3);
               total=rs.getInt(4);
               dndto=new DonNhan_DTO(madon,ngay,manv,total);
               listdn.add(dndto);
            }
            conn.close();
        }catch (SQLException e) {
            System.out.println(e);
        } 
        return listdn;
    }
    public int getRowCount(){
        int count = 0;
        Connection conn = getConnection(URL, User, Password);
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from donnhan");
            while(rs.next()){
                count++;
            }
        conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public ArrayList<DonNhan_DTO> getDateFilter(String Date){
        Connection conn = getConnection(URL, User, Password);
        ArrayList<DonNhan_DTO> inputs = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from donnhan where ngnhan like '%" + Date + "%' and isdeleted = 0");
            while (rs.next()) {
                inputs.add(new DonNhan_DTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
            conn.close();   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputs;
    }
    public ArrayList<DonNhan_DTO> getIDFilter(String ID){
        Connection conn = getConnection(URL, User, Password);
        ArrayList<DonNhan_DTO> inputs = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from donnhan where madn = '" + ID + "' and isdeleted = 0");
            if (rs.next()) {
                inputs.add(new DonNhan_DTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
            conn.close();   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputs;
    }

    public ArrayList<DonNhan_DTO> delData(String ID){
        Connection conn = getConnection(URL, User, Password);
        ArrayList<DonNhan_DTO> inputs = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("update donnhan set isdeleted = 1 where madn = '"+ID+"'");
            conn.close();   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputs;
    }

    public DonNhan_DTO getData(String ID){
        Connection conn = getConnection(URL, User, Password);
        DonNhan_DTO data = null;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from donnhan where isdeleted = 0 and madn = '"+ID+"'");
            if (rs.next()){
                data = new DonNhan_DTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
            conn.close();   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public void updateData(DonNhan_DTO order){
        Connection conn = getConnection(URL, User, Password);
        try {
            Statement  stmt = conn.createStatement();
            stmt.executeUpdate("update donnhan set tong = "+order.getTong()+" where madn = '"+order.getMadn()+"'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
