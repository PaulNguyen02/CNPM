package BLL;

import java.util.ArrayList;

import DAO.CTDN_DAO;
import DTO.CTDN_DTO;

public class CTDN_BLL {
    private CTDN_DAO dao = new CTDN_DAO();
    public ArrayList<CTDN_DTO> pullData(String ID){
        return dao.pullData(ID);
    }
    public void updateData(ArrayList<CTDN_DTO> olddata, ArrayList<CTDN_DTO> data, String ID){
        
        dao.preUpdateData(olddata);
        dao.updateData(data, ID);
    }
}
