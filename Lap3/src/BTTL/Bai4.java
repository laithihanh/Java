/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai4 implements Serializable{
    private String proId;
    private String proName;
    private String producer;
    private int yearMaking;
    private float price;

    public Bai4() {
    }

    public Bai4(String proId, String proName, String producer, int yearMaking, float price) {
        this.proId = proId;
        this.proName = proName;
        this.producer = producer;
        this.yearMaking = yearMaking;
        this.price = price;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getYearMaking() {
        return yearMaking;
    }

    public void setYearMaking(int yearMaking) {
        this.yearMaking = yearMaking;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public void input(){
    Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập proId:");
        proId = sc.nextLine();
        System.out.printf("\tNhập proName:");
        proName = sc.nextLine();
        System.out.printf("\tNhập producer:");
        producer = sc.nextLine();
        System.out.printf("\tNhập yearMaking:");
        yearMaking = sc.nextInt();
        System.out.printf("\tNhập price:");
        price = sc.nextFloat();
    }

    @Override
    public String toString() {
        return "Bai4{" + "proId=" + proId + ", proName=" + proName + ", producer=" + producer + ", yearMaking=" + yearMaking + ", price=" + price + '}';
    }
    
}
