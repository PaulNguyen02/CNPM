package DTO;

public class DoanhThu_DTO {
    private String date;
    private int income;
    private int sold;

    public DoanhThu_DTO(String date, int income, int sold){
        this.date = date;
        this.income = income;
        this.sold = sold;
    }

    public String getDate() {
        return date;
    }
    
    public int getIncome() {
        return income;
    }

    public int getSold() {
        return sold;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }
}
