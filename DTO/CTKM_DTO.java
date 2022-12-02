package DTO;

public class CTKM_DTO {
    private String MASP;
    private int GIAM;
    public CTKM_DTO( String MASP, int GIAM){
        this.GIAM = GIAM;

        this.MASP = MASP;
    }
    public int getGIAM() {
        return GIAM;
    }
   
    public String getMASP() {
        return MASP;
    }
    public void setGIAM(int gIAM) {
        GIAM = gIAM;
    }
    public void setMASP(String mASP) {
        MASP = mASP;
    }
}
