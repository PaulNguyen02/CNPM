
package DTO;

public class CTHD_DTO {
    private String mahd;
    private String masp;
    private String makm;
    private int soluong;
    private int total;

    public CTHD_DTO(String mahd, String masp, int soluong, String makm, int total) {
        this.mahd = mahd;
        this.masp = masp;
        this.soluong = soluong;
        this.makm = makm;
        this.total=total;
    }

    public String getMasp() {
        return masp;
    }
    public void setMasp(String masp) {
        this.masp = masp;
    }
    public int getSoluong() {
        return soluong;
    }
    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getMakm() {
        return makm;
    }
    public void setMakm(String makm) {
        this.makm = makm;
    }

    public String getMahd() {
        return mahd;
    }
    
    public int getTotal() {
        return total;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }
    
    public void setTotal(int sl) {
        this.total = sl;
    }
    
}
