/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paul
 */
public class DT_DAO {
    private final String URL="jdbc:sqlserver://localhost:1433; DatabaseName=MiniStore24H;integratedSecurity=true" ;
    private final String User="paul"; 
    private final String Password="00000";
    private int total;
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
    public int Statistic()
    {
        Connection conn = getConnection(URL, User, Password);
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("select sum(hoadon.TONGTIEN) from HOADON where isdeleted='"+0+"'");
            while(rs.next())
            {
                total=rs.getInt(1);               
            }
            conn.close();
        }catch (SQLException ex) {
            Logger.getLogger(DT_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return total;
    }
    public void Delete()
    {
        Connection conn = getConnection(URL, User, Password);
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE HOADON SET ISDELETED='"+1+"'");           
            conn.close();
        }catch (SQLException ex) {
            Logger.getLogger(DT_DAO.class.getName()).log(Level.SEVERE, null, ex);
       } 
    }
}
