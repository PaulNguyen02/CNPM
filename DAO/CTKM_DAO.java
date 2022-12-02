package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.CTKM_DTO;

public class CTKM_DAO {
    private final String URL="jdbc:sqlserver://localhost:1433; DatabaseName=MiniStore24H;integratedSecurity=true" ;
    private final String User="paul"; 
    private final String Password="00000";
    private Connection conn;
    public CTKM_DAO(){
        
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
    
    public ArrayList<CTKM_DTO> getAllCTKM(String MAKM){
        ArrayList<CTKM_DTO> km = new ArrayList<>();
        try {
            
            conn = getConnection(URL, User, Password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from CTKM where MAKM ='"+MAKM+"'");
            while (rs.next()){
                //String MaKM = rs.getString(1);
                String MaSP = rs.getString(2);
                int    Giam = rs.getInt(3);
                CTKM_DTO ctkm = new CTKM_DTO(MaSP, Giam);
                km.add(ctkm);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return km;
    }
    public String getDiscount(String MaSP){
        String discount = "";
        try {
            
            conn = getConnection(URL, User, Password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select ctkm.makm from CTKM, khuyenmai where MASP ='"+MaSP+"' and khuyenmai.isdeleted = 0");
            if (rs.next()){
                discount = rs.getString(1);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return discount;
    }
}
