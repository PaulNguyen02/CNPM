package BLL;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import DAO.Statistic_DAO;
import DTO.Statistic_DTO;

public class Statistic_BLL {
    public Statistic_BLL(){

    }

    public ArrayList<Statistic_DTO> getData(){
        return (new Statistic_DAO()).getData();
    }
    
    public ArrayList<Statistic_DTO> getData(String Month, String Year){
        return (new Statistic_DAO()).getData(Year + "-" +  Month);
    }   

    public void addData(String Date, int Income, int Sold){
        if (checkDay()){
            (new Statistic_DAO()).addData(new Statistic_DTO(Date, Income, Sold));
            return;
        }
        (new Statistic_DAO()).increaseIcome(Date, Income, Sold);
    }

    private boolean checkDay(){
        Statistic_DTO data = (new Statistic_DAO()).getLastestRow();
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(data.getDate(), formatter);
        if (date.isBefore(now)) 
            return true;
        return false;
    }
    
    public void decData(String Date, int Income, int Sold){
        (new Statistic_DAO()).decData(Date, Income, Sold);
    }
    
}
