/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.DT_DAO;
/**
 *
 * @author Paul
 */

public class DT_BLL {
    DT_DAO dtdao;
    public int Statistic()
    {
       dtdao=new DT_DAO();
       return dtdao.Statistic();
    }
    public void Delete()
    {
        dtdao=new DT_DAO();
        dtdao.Delete();
    }
}

