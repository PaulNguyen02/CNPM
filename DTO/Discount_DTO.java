package DTO;

import java.util.ArrayList;

public class Discount_DTO {
    private String ID;
    private String NHL;
    private ArrayList<CTKM_DTO> Details = new ArrayList<>();
    public Discount_DTO(String ID, String NHL){
        this.ID = ID;
        this.NHL = NHL;
    }public Discount_DTO(){
    }
    public String getID() {
        return ID;
    }
    public String getNHL() {
        return NHL;
    }
    public ArrayList<CTKM_DTO> getDetails() {
        return Details;
    }
    public void setID(String iD) {
        ID = iD;
    }
    public void setNHL(String nHL) {
        NHL = nHL;
    }
    public void setDetails(ArrayList<CTKM_DTO> details) {
        Details = details;
    }
    public int getDiscount(String MaSP){
        for (CTKM_DTO ctkm : Details) {
            if (ctkm.getMASP().equals(MaSP)){
                return ctkm.getGIAM();
            }
        }
        return 0;
    }
    
}
