/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.DN_DAO;
import DTO.DN_DTO;
import DTO.SP_DTO;
import java.util.ArrayList;

/**
 *
 * @author Paul
 */
public class DN_BLL {
    private DN_DAO dndao;
    public DN_BLL() {
    }
    
    public void Add(DN_DTO dndto, ArrayList <SP_DTO>listsp)
    {
        dndao=new DN_DAO();
        //dndao.Add(dndto, listsp);

    }
    public ArrayList<DN_DTO> View()
    {
        dndao=new DN_DAO();
        return dndao.View();
    }
    
}
