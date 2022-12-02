package BLL;

import java.util.ArrayList;

import DAO.CTKM_DAO;
import DTO.CTKM_DTO;

public class CTKM_BLL {
    public CTKM_BLL(){
    }

    public ArrayList<CTKM_DTO> getAllCTKM(String MaKM){
        CTKM_DAO ctkm = new CTKM_DAO();
        return ctkm.getAllCTKM(MaKM);
    }

    public String getGiam(String MaSP){
        CTKM_DAO ctkm = new CTKM_DAO();
        return ctkm.getDiscount(MaSP);
    }
}
