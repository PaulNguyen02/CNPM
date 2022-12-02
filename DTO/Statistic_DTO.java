package DTO;

public class Statistic_DTO {
    private String Date;
    private int Income;
    private int Sold;

    private int Day;
    private int Month;
    private int Year;

    public Statistic_DTO(String Date, int Income, int Sold){
        this.Date = Date;
        this.Income = Income;
        this.Sold = Sold;
        setupDate();
    }

    private void setupDate(){
        String[] date = Date.split("-");
        Day = Integer.parseInt(date[2]);
        Month = Integer.parseInt(date[1]);
        Year = Integer.parseInt(date[0]);
    }

    public int getDay() {
        return Day;
    }
    public int getMonth() {
        return Month;
    }
    public int getYear() {
        return Year;
    }
    public void setDay(int day) {
        Day = day;
    }
    public void setMonth(int month) {
        Month = month;
    }
    public void setYear(int year) {
        Year = year;
    }


    public String getDate() {
        return Date;
    }
    public int getIncome() {
        return Income;
    }
    public int getSold() {
        return Sold;
    }
    public void setDate(String date) {
        Date = date;
    }
    public void setIncome(int income) {
        Income = income;
    }public void setSold(int sold) {
        Sold = sold;
    }

}
