/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import java.util.ArrayList;

import DAO.CTHD_DAO;
import DAO.HD_DAO;
import DTO.CTHD_DTO;

/**
 *
 * @author Paul
 */
public class CTHD_BLL {
    private int num;
    private CTHD_DAO cthddao;
    public int MAHD()
    {
        cthddao=new CTHD_DAO();
        num=cthddao.MAHD();
        return num;
    }
    public ArrayList<CTHD_DTO> getDetails(String Bill_ID){
        if ((new HD_DAO().getBill(Bill_ID) == null)){
            return null;
        }
        return (new CTHD_DAO()).getDetails(Bill_ID);
    }
}
