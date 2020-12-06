/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_7;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai2 implements Comparable<Bai2>{
    private String flowerID; //mã nhập
    private String flowerName; // tên hoa
    private String color; // màu hoa
    private int kindOfFlower; //số chủng loại của loài hoa này (Hoa Hồng: Hồng
    //Đỏ, Hồng Vàng, Hồng Trắng => số chủng loại = 3)

    public Bai2() {
    }

    public Bai2(String flowerID, String flowerName, String color, int kindOfFlower) {
        this.flowerID = flowerID;
        this.flowerName = flowerName;
        this.color = color;
        this.kindOfFlower = kindOfFlower;
    }

    public String getFlowerID() {
        return flowerID;
    }

    public void setFlowerID(String flowerID) {
        this.flowerID = flowerID;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getKindOfFlower() {
        return kindOfFlower;
    }

    public void setKindOfFlower(int kindOfFlower) {
        this.kindOfFlower = kindOfFlower;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập mã hoa:");
        flowerID = sc.nextLine();
        System.out.printf("\tTên hoa:");
        flowerName = sc.nextLine();
        System.out.printf("\tMàu hoa:");
        color = sc.nextLine();
        System.out.printf("\tNhap loai (1: Hoa Hong Do, 2: Hoa Hong Vang, 3: Hoa Hong Trang):");
        kindOfFlower = sc.nextInt();
        

    }
    
    public void display(){
       
        System.out.println("\tMã hoa:"+flowerID);
        System.out.println("\tTên hoa:"+flowerName);
        System.out.println("\tMàu hoa:"+color);
        System.out.println("\tSố chủng loại:"+kindOfFlower);
    }

    @Override
    public int compareTo(Bai2 o) {
        return this.getFlowerName().compareTo(o.getFlowerName());
    }
    
}
