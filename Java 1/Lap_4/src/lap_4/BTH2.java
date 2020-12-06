/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_4;
import java.util.Scanner;
/**
 *
 * @author ADMIN
 */
public class BTH2 {
    private String maSP;
    private String tenSP;
    private String nhaSX;
    private int namSX;
    private float giaBan;
    
    public BTH2() {
    }
    
    public BTH2(String maSP, String tenSP, String nhaSX, int namSX, float giaBan) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.nhaSX = nhaSX;
        this.namSX = namSX;
        this.giaBan = giaBan;
    }
    
    public String getMaSP() {
        return maSP;
    }
    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }
    public String getTenSP() {
        return tenSP;
    }
    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }
    public String getNhaSX() {
        return nhaSX;
    }
    public void setNhaSX(String nhaSX) {
        this.nhaSX = nhaSX;
    }
    public int getNamSX() {
        return namSX;
    }
    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }
    public float getGiaBan() {
        return giaBan;
    }
    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhap ma san pham:");
        maSP = sc.nextLine();
        System.out.printf("Nhap ten san pham:");
        tenSP = sc.nextLine();
        System.out.printf("Nhap ten nha san xuat:");
        nhaSX = sc.nextLine();
        System.out.printf("Nhap nam san xuat:");
        namSX = Integer.parseInt(sc.nextLine());
        System.out.printf("Nhap gia ban:");
        giaBan = Float.parseFloat(sc.nextLine());
    }
    
    public void display(){
        System.out.println("San pham:");
        System.out.println("\tMa san pham:"+maSP);
        System.out.println("\tTen san pham:"+tenSP);
        System.out.println("\tNha san xuat:"+nhaSX);
        System.out.println("\tNam san xuat:"+namSX);
        System.out.println("\tGia ban:"+giaBan);
    }
}

