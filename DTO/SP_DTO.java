
package DTO;

public class SP_DTO {
    private String masp;
    private String tensp; 
    private String ncc;
    private int sl;
    private int dongia;
    private ProductType loai;
    public static enum ProductType {
        Fruit, Noodle, Cookie, Drink, FastFood, Candy
    }

    public void setLoai(String type){
        if (type.equals("Fruit")){
            loai = ProductType.Fruit;
            return;
        }

        if (type.equals("Candy")){
            loai = ProductType.Candy;
            return;
        }
        
        if (type.equals("Noodle")){
            loai = ProductType.Noodle;
            return;
        }
        
        if (type.equals("Drink")){
            loai = ProductType.Drink;
            return;
        }
        
        if (type.equals("Cookie")){
            loai = ProductType.Cookie;
            return;
        }
        loai = ProductType.FastFood;
    }

    public SP_DTO(String masp, String tensp, int sl, int dongia, String loai, String ncc) {
        this.masp = masp;
        this.tensp = tensp;
        this.ncc = ncc;
        setLoai(loai);
        this.sl = sl;
        this.dongia = dongia;
    }
    public SP_DTO(String masp, int sl, int dongia) {  
        this.masp = masp;
        this.sl = sl;
        this.dongia = dongia;
    }

    public SP_DTO(String masp, String tensp, int sl, int dongia) {  
        this.masp = masp;
        this.tensp = tensp;
        this.sl = sl;
        this.dongia = dongia;
    }
    public SP_DTO(String masp, String tensp, int dongia) {  
        this.masp = masp;
        this.tensp = tensp;
    
        this.dongia = dongia;
    }
    
    public void addProduct(int Amount){
        sl += Amount;
    }

    public void sellProduct(int Amount){
        sl -= Amount;
    }

    public String getLoaiVN(){
        switch (loai) {
            case Fruit:
                return "Trái Cây";
        
            case Candy:
                return "Kẹo";
            
            case FastFood:
            return "Thức Ăn Nhanh";
            
            case Noodle:
                return "Mì";
            
            case Cookie:
                return "Bánh";

            default:
                return "Nước Giải Khát";
        }
    }

    public String getLoai(){
        switch (loai) {
            case Fruit:
                return "Fruit";
        
            case Candy:
                return "Candy";
            
            case FastFood:
            return "FastFood";
            
            case Noodle:
                return "Noodle";
            
            case Cookie:
                return "Cookie";

            default:
                return "Drink";
        }
    }

    public String getMasp() {
        return masp;
    }

    public String getTensp() {
        return tensp;
    }

    public ProductType getType() {
        return loai;
    }

    public String getNcc() {
        return ncc;
    }

    public int getSl() {
        return sl;
    }

    public int getDongia() {
        return dongia;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public void setNcc(String ncc) {
        this.ncc = ncc;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }
}
