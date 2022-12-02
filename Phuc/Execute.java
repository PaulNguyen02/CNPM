/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Phuc;

/**
 *
 * @author Paul
 */
public class Execute {
    private double sum,sl, total, sum1;
    public Execute(){}
    public double Res(double sl ,double sum)
    {
        this.sl=sl;
        this.sum=sum;
        return this.sum*this.sl;
    }
    public double Remain(double get ,double sum)
    {
        this.total=get;
        this.sum1=sum;
        return total-sum1;
    }
}
