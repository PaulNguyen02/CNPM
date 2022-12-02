
package DTO;

public class HD_DTO {
    
    private String mahd, ngxuat, manv, selectedid;
    private int tongtien, isdeleted;

    public HD_DTO(String mahd, String ngxuat, String manv, int tongtien) {
        this.mahd = mahd;
        this.ngxuat = ngxuat;
        this.manv = manv;
        this.tongtien = tongtien;
    }

    public HD_DTO(String mahd){
        this.mahd = mahd;
        
    }
    public String getMahd() {
        return mahd;
    }

    public String getNgxuat() {
        return ngxuat;
    }

    public String getManv() {
        return manv;
    }

    public int getTongtien() {
        return tongtien;
    }

    public int getIsdeleted() {
        return isdeleted;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public void setNgxuat(String ngxuat) {
        this.ngxuat = ngxuat;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public void setIsdeleted(int isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getSelectedid() {
        return selectedid;
    }
    
}
