package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import BLL.CTKM_BLL;
import DTO.CTKM_DTO;
import DTO.Discount_DTO;

public class Discount_DAO {
    private final String URL="jdbc:sqlserver://localhost:1433; DatabaseName=MiniStore24H;integratedSecurity=true" ;
    private final String User="paul"; 
    private final String Password="00000";
    private Connection conn;
    public Discount_DAO(){
        
    }
    private Connection getConnection(String URL, String User, String Password)
    {
        conn=null;
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

    public ArrayList<Discount_DTO> getAllDiscount(){
        conn = getConnection(URL, User, Password);
        ArrayList<Discount_DTO> discount = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select MAKM, NHL from KHUYENMAI where isdeleted = 0");
            while(rs.next()){
                Discount_DTO dto = new Discount_DTO(rs.getString(1), rs.getString(2));
                CTKM_BLL bll = new CTKM_BLL();
                dto.setDetails(bll.getAllCTKM(rs.getString(1)));
                discount.add(dto);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return discount;
    }

    public Discount_DTO getDiscount(String MaKM){
        conn = getConnection(URL, User, Password);
        Discount_DTO discount = null;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select makm, nghl from KHUYENMAI where isdeleted = 0 and makm = '"+MaKM+"'");
            if(rs.next()){
                Discount_DTO dto = new Discount_DTO(rs.getString(1), rs.getString(2));
                CTKM_BLL bll = new CTKM_BLL();
                dto.setDetails(bll.getAllCTKM(rs.getString(1)));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return discount;
    }

    public int getNewID(){
        int id = 0;
        conn = getConnection(URL, User, Password);
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from khuyenmai");
            while (rs.next()) {
                id++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public void saveData(Discount_DTO KM, ArrayList<CTKM_DTO> ctkm){
        conn = getConnection(URL, User, Password);
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into khuyenmai values('" +KM.getID()+ "', '" + KM.getNHL() + "', 0)");
            for (CTKM_DTO row : ctkm) {
                stmt.executeUpdate("insert into ctkm values('" +KM.getID()+ "', '" + row.getMASP() + "', "+ row.getGIAM() +")");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
