/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Phuc;
import java.util.Calendar;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.util.Date;

/**
 *
 * @author Paul
 */
public class Time {
    //private Date date;
    private LocalDateTime current;
    private DateTimeFormatter formatter;
    private String time;
    public Time()
    {  
        current= LocalDateTime.now();
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    }
    public String Month()
    {
        Calendar calendar = Calendar.getInstance();
        int month;
        month= calendar.get(Calendar.MONTH);
        return String.valueOf(month+1);
    }
    public String Date()
    {
        Calendar calendar = Calendar.getInstance();
        int day, month, year;
        day = calendar.get(Calendar.DATE);
        month= calendar.get(Calendar.MONTH);
        year= calendar.get(Calendar.YEAR);
        return String.valueOf(day)+"-"+String.valueOf(month+1)+"-"+String.valueOf(year);
    }
    public String toString()
    {
        time=current.format(formatter);
        return time;
    }
}
