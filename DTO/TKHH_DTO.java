/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Paul
 */
public class TKHH_DTO {
    private String MASP, Ten, Loai;
    private int SL, ConLai;

    public TKHH_DTO(String MASP, String Ten, String Loai, int SL, int ConLai) {
        this.MASP = MASP;
        this.Ten = Ten;
        this.Loai = Loai;
        this.SL = SL;
        this.ConLai = ConLai;
    }

    public void setMASP(String MASP) {
        this.MASP = MASP;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    public void setConLai(int ConLai) {
        this.ConLai = ConLai;
    }

    public String getMASP() {
        return MASP;
    }

    public String getTen() {
        return Ten;
    }

    public String getLoai() {
        return Loai;
    }

    public int getSL() {
        return SL;
    }

    public int getConLai() {
        return ConLai;
    }
    
}
