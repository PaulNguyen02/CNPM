/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Paul
 */
public class DT_DTO {
    private String Month;
    private int Total;

    public DT_DTO() {
    }
    public void set(String Month, int Total)
    {
        this.Month=Month;
        this.Total=Total;
    }
    public void setTotal(int Total) {
        this.Total = Total;
    }
    public String Month()
    {
        return Month;
    }
    public int getTotal() {
        return Total;
    }
    
}
