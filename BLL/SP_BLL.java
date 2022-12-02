/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.SP_DAO;
import DTO.SP_DTO;
import java.util.ArrayList;

/**
 *
 * @author Paul
 */
public class SP_BLL {
    private String item;
    private int price;
    private SP_DAO spdao;
    private String noice;
    private ArrayList <String> listmasp=new ArrayList();
    //private SP_DTO spdto;
    public void setPrice(int price)
    {
        this.price=price;
    }
    public String getName()
    {
        return item;
    }
    public int getPrice()
    {
        return price;
    }
    public ArrayList<SP_DTO>Search(String search)
    {
        spdao=new SP_DAO();
        try
        {
            int s=Integer.parseInt(search);
            return spdao.Search(s);
        }
        catch(NumberFormatException ne)
        {
            return spdao.Search1(search);
        }
        
    }
    public ArrayList<SP_DTO>View()
    {
        spdao=new SP_DAO();
        return spdao.View();
    }
    public ArrayList<SP_DTO>Candy()
    {
        spdao=new SP_DAO();
        return spdao.Candy();
    }
    public ArrayList<SP_DTO>Cookie()
    {
        spdao=new SP_DAO();
        return spdao.Cookie();
    }
    public ArrayList<SP_DTO>Drink()
    {
        spdao=new SP_DAO();
        return spdao.Drink();
    }
    public ArrayList<SP_DTO>FastFood()
    {
        spdao=new SP_DAO();
        return spdao.FastFood();
    }
    public ArrayList<SP_DTO>Fruit()
    {
        spdao=new SP_DAO();
        return spdao.Fruit();
    }
    public ArrayList<SP_DTO>Noodle()
    {
        spdao=new SP_DAO();
        return spdao.Noodle();
    }
    public void Add(SP_DTO sp)
    {
        spdao=new SP_DAO();
        spdao.Add(sp);
    }
    public void Edit(SP_DTO sp, String selectedid)
    {
        spdao=new SP_DAO();
        spdao.Edit(sp, selectedid);
    }
    public void Delete(String selectedid)
    {
        spdao=new SP_DAO();
        spdao.Delete(selectedid);
    }
    public SP_DTO Find(String search)
    {    
        spdao=new SP_DAO();
        return spdao.find(search);     
    }
}
