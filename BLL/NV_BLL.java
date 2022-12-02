/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.NV_DAO;
import DTO.NV_DTO;
import java.util.ArrayList;

/**
 *
 * @author Paul
 */
public class NV_BLL {
    private NV_DAO nvdao;

    public NV_DTO getNV(String id){
        
        nvdao=new NV_DAO();
        return  nvdao.getNV(id);
    }
    public void Add(NV_DTO nvdto)
    {
        nvdao=new NV_DAO();
        nvdao.Add(nvdto);
    }
    public ArrayList<NV_DTO> View()
    {
        nvdao=new NV_DAO();
        return nvdao.View();
    }
    public void Edit(NV_DTO nvdto, String status)
    {
        nvdao=new NV_DAO();
        nvdao.Edit(nvdto, status);
    }
    public void Delete(String selectedid)
    {
        nvdao=new NV_DAO();
        nvdao.Delete(selectedid);
    }
    public ArrayList<NV_DTO> Search(String search)
    {
        nvdao=new NV_DAO();
        return nvdao.Search(search);
    }
}
