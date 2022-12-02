
package DTO;

public class NV_DTO {
    
    private String manv;
    private String tenv;
    private String ngsinh;
    private String dchi;
    private String sdt;
    private String pass;
    private int isdeleted;
    private role cvu;
    public static enum role{
        Manager, Casher, Warehouse
    }

    public NV_DTO(String manv, String tenv, String ngsinh, String dchi, String sdt, String cvu, String pass) {
        this.manv = manv;
        this.tenv = tenv;
        this.ngsinh = ngsinh;
        this.dchi = dchi;
        this.sdt = sdt;
        initCvu(cvu);
        this.pass=pass;
    }

    private void initCvu(String cvu){
        if (cvu.equals("manager")){
            this.cvu = role.Manager;
            return;
        }
        if (cvu.equals("warehouse")){
            this.cvu = role.Warehouse;
            return;
        }
        this.cvu = role.Casher;
    }

    public role getRole(){
        return cvu;
    }

    public String getCvu(){
        switch (cvu) {
            case Manager:
                return "manager";
            case Warehouse:
                return "warehouse";
            default:
                return "casher";
        }
    }
    public String getCvuVN(){
        switch (cvu) {
            case Manager:
                return "Quản Lý";
            case Warehouse:
                return "Kiểm Kho";
            default:
                return "Thu Ngân";
        }
    }

    public String getManv() {
        return manv;
    }

    public String getTenv() {
        return tenv;
    }

    public String getNgsinh() {
        return ngsinh;
    }

    public String getDchi() {
        return dchi;
    }

    public String getSdt() {
        return sdt;
    }

    public int getIsdeleted() {
        return isdeleted;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public void setTenv(String tenv) {
        this.tenv = tenv;
    }

    public void setNgsinh(String ngsinh) {
        this.ngsinh = ngsinh;
    }

    public void setDchi(String dchi) {
        this.dchi = dchi;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setIsdeleted(int isdeleted) {
        this.isdeleted = isdeleted;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }
    
}
