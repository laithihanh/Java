/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_7;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bai1 implements Comparable<Bai1>{

    private String cityId; //Mã thành phố
    private String cityName; //Tên thành phố
    private String country; //Tên nước
    private Double area; //diện tích

    public Bai1() {
    }

    public Bai1(String cityId, String cityName, String country, double area) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.country = country;
        this.area = area;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tMã thành phố:");
        cityId = sc.nextLine();
        System.out.printf("\tTên thành phố:");
        cityName = sc.nextLine();
        System.out.printf("\tTên nước:");
        country = sc.nextLine();
        System.out.printf("\tDiện tích:");
        area = sc.nextDouble();
        

    }
    
    public void display(){
       
        System.out.println("\tMã thành phố:"+cityId);
        System.out.println("\tTên thành phố:"+cityName);
        System.out.println("\tTên nước:"+country);
        System.out.println("\tDiện tích:"+area);
    }
   
    @Override
    public int compareTo(Bai1 o) {
        return this.getCityName().compareTo(o.getCityName());
    }
    
}
