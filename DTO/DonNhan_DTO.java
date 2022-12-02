
package DTO;

public class DonNhan_DTO {
    private String madn, ngnhan, manv;
    private int tong;

    public DonNhan_DTO(String madn, String ngnhan, String manv,  int tong) {
        this.madn = madn;
        this.ngnhan = ngnhan;
        this.manv = manv;
        this.tong = tong;
    }
    public DonNhan_DTO(String madn, String manv) {
        this.madn = madn;
        this.manv = manv;
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


}
