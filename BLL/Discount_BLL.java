package BLL;

import java.util.ArrayList;

import DAO.CTKM_DAO;
import DAO.Discount_DAO;
import DTO.CTKM_DTO;
import DTO.Discount_DTO;

public class Discount_BLL {
    public Discount_BLL(){
    }
    public ArrayList<Discount_DTO> getAllDiscount(){
        Discount_DAO dao = new Discount_DAO();
        return dao.getAllDiscount();
    }
    public Discount_DTO getDiscount(String MaSP){
        CTKM_DAO ctkm = new CTKM_DAO();
        Discount_DAO dao = new Discount_DAO();
        String MAKM = ctkm.getDiscount(MaSP);
        return dao.getDiscount(MAKM);
    }
    public String getNewID(){
        return "KM"+(new Discount_DAO()).getNewID();
    }
    public void saveData(Discount_DTO KM, ArrayList<CTKM_DTO> ctkm){
        (new Discount_DAO()).saveData(KM, ctkm);
    }
}
