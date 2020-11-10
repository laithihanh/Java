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
public class Car implements Icar{
    private String name;
    private String producer;
    private int year;
    private int seat;
     float rootPrice;

    public Car() {
    }

    public Car(String name, String producer, int year, int seat, float rootPrice) {
        this.name = name;
        this.producer = producer;
        this.year = year;
        this.seat = seat;
        this.rootPrice = rootPrice;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public float getRootPrice() {
        return rootPrice;
    }

    public void setRootPrice(float rootPrice) {
        this.rootPrice = rootPrice;
    }
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập tên xe:");
        name = sc.nextLine();
        while (name.length()>30) {
            System.err.printf("\tTên xe phải không vượt quá 30 ký tự\n");
            System.out.printf("\tNhập tên xe:");
            name = sc.nextLine(); 
        }
        System.out.printf("\tNhập người sản xuất:");
        producer = sc.nextLine();
        while (producer.length()>30) {
            System.err.printf("\tNgười sản xuất phải không vượt quá 30 ký tự\n");
            System.out.printf("\tNhập người sản xuất:");
            producer = sc.nextLine(); 
        }
        while (true) {
            try {
                System.out.printf("\tNhập năm sản xuất:");
                year = sc.nextInt();
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số nguyên:");
                  sc.nextLine();
            }
        }
        while (true) {
            try {
                System.out.printf("\tNhập số ghế:");
                seat = sc.nextInt();
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số nguyên:");
                  sc.nextLine();
            }
        }
        while (true) {
            try {
                System.out.printf("\tNhập giá gốc:");
                rootPrice = sc.nextFloat();
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số thực:");
                  sc.nextLine();
            }
        }
    }
    
    @Override
    public float calculateTax() {
        float Tax = 0;
        if(seat<7){
            Tax = (float) (rootPrice*0.6);
            return Tax;
        }else{
            Tax = (float) (rootPrice*0.7);
             return Tax;
        } 
    }

    @Override
    public float calculatePrice() {
        float SumPrice =0;
        SumPrice = rootPrice + calculateTax();
        return SumPrice;
    }

    @Override
    public void getInfor() {
        System.out.printf("\tXe "+name);
        System.out.printf(" được sản xuất bởi "+producer);
        System.out.printf(" vào năm "+year);
        System.out.printf(" có "+seat);
        System.out.printf(" ghế với tổng giá bán là "+calculatePrice()+ " $\n");
    }
    
}
