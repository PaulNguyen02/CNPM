package BLL;

import java.util.ArrayList;

import DAO.DoanhThu_DAO;
import DTO.DoanhThu_DTO;

public class DoanhThu_BLL {
    private DoanhThu_DAO dao;
    public DoanhThu_BLL(){
    }

    public ArrayList<DoanhThu_DTO> getTable(){
        return dao.getTable();
    }

    

}
