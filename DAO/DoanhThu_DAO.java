package DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.DoanhThu_DTO;

public class DoanhThu_DAO {
    private final String URL="jdbc:sqlserver://localhost:1433; DatabaseName=MiniStore24H;integratedSecurity=true" ;
    private final String User="paul"; 
    private final String Password="00000";
    private Connection conn = null;

    private void startConnection(String Message){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(URL, User, Password);
            System.out.println(Message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<DoanhThu_DTO> getTable(){
        ArrayList<DoanhThu_DTO> list = new ArrayList<>();
        try {
            startConnection("Get Doanh Thu Table");
            Statement stmt = conn.createStatement();
            ResultSet rs  = stmt.executeQuery("select * from doanhthu");
            while(rs.next()){
                list.add(new DoanhThu_DTO(rs.getString(1), rs.getInt(2), rs.getInt(3)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
