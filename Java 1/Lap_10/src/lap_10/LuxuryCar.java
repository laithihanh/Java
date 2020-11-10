/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_10;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class LuxuryCar extends Car{
    private float specialRate;

    public LuxuryCar() {
    }

    public LuxuryCar(float specialRate,String name,String producer,int year,int seat,float rootPrice) {
    super(name, producer, year, seat,rootPrice);
        this.specialRate = specialRate;
    }

    public float getSpecialRate() {
        return specialRate;
    }

    public void setSpecialRate(float specialRate) {
        this.specialRate = specialRate;
    }
    @Override
    public void input() {
        super.input();
       Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập specialRate:");
        specialRate = sc.nextFloat();
    }

//    @Override
//    public float calculatePrice() {
//        return super.calculatePrice()+specialRate; 
//    }
//     public float calculatePrice(float transportCost) {
//        float SumPrice_transportCost =0;
//        transportCost=20000;
//        SumPrice_transportCost = calculatePrice() + transportCost;
//        return SumPrice_transportCost;
//    } 
}
