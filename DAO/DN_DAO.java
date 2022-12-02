/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DN_DTO;
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
public class DN_DAO {
    private final String URL="jdbc:sqlserver://localhost:1433; DatabaseName=MiniStore24H;integratedSecurity=true" ;
    private final String User="paul";
    private final String Password="00000";
    private String madon, ngay, manv, madd;
    private int dot, total;
    private ArrayList<DN_DTO>listdn=new ArrayList();
    private DN_DTO dndto;
    public DN_DAO() {
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
    public void Add(DN_DTO dndto)
    {
        try {
            Connection conn = getConnection(URL, User, Password);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO DONNHAN VALUES('" + dndto.getMadn() + "','" + dndto.getNgnhan()
                    + "','" + dndto.getDot() + "','" + dndto.getManv() + "','" + dndto.getTong() + "')"); 
                    
            conn.close();
        } 
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    public ArrayList<DN_DTO>View()
    {
        Connection conn = getConnection(URL, User, Password);
        try 
        {    
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from DONNHAN");
            while(rs.next())
            {
               madon=rs.getString(1);
               ngay=rs.getString(2);
               dot=rs.getInt(3);
               manv=rs.getString(4);
               total=rs.getInt(6);
               dndto=new DN_DTO(madon,ngay,manv,total,dot);
               listdn.add(dndto);
            }
            conn.close();
        }catch (SQLException e) {
            System.out.println(e);
        } 
        return listdn;
    }
}
