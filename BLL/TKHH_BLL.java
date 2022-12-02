/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.TKHH_DAO;
import DTO.TKHH_DTO;
import java.util.ArrayList;

/**
 *
 * @author Paul
 */
public class TKHH_BLL {
    ArrayList <TKHH_DTO> tkhhdto=new ArrayList();
    private TKHH_DAO tkhhdao;
    public TKHH_BLL() {
    }
    public ArrayList<TKHH_DTO>Statistic()
    {
        tkhhdao=new TKHH_DAO();
        return tkhhdao.Statistic();
    }
    public TKHH_DTO Search(String masearch)
    {
        tkhhdao=new TKHH_DAO();
        return tkhhdao.Search(masearch);
    }
}
