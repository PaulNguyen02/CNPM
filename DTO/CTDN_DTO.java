
package DTO;

public class CTDN_DTO {
    private String madn;
    private String masp;
    private int sl;
    private int gia;

    public CTDN_DTO(String madn, String masp, int sl, int gia){
        this.madn = madn;
        this.masp = masp;
        this.sl = sl;
        this.gia = gia;
    }

    public String getMadn() {
        return madn;
    }

    public String getMasp() {
        return masp;
    }

    public int getSl() {
        return sl;
    }

    public int getGia() {
        return gia;
    }

    public void setMadn(String madn) {
        this.madn = madn;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
}
