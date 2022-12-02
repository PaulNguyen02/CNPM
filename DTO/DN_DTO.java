
package DTO;

public class DN_DTO {
    private String madn, ngnhan, manv;
    private int tong, dot;

    public DN_DTO(String madn, String ngnhan, String manv,  int tong, int dot) {
        this.madn = madn;
        this.ngnhan = ngnhan;
        this.manv = manv;

        this.tong = tong;
        this.dot = dot;
    }

    

    public String getMadn() {
        return madn;
    }

    public String getNgnhan() {
        return ngnhan;
    }

    public String getManv() {
        return manv;
    }

    public int getTong() {
        return tong;
    }

    public int getDot() {
        return dot;
    }

    public void setMadn(String madn) {
        this.madn = madn;
    }

    public void setNgnhan(String ngnhan) {
        this.ngnhan = ngnhan;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    

    public void setTong(int tong) {
        this.tong = tong;
    }

    public void setDot(int dot) {
        this.dot = dot;
    }

}
