/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic3;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai1 {

    String ten;
    String nhaSanXuat;
    int soLuongBanhXe;
    
    public Bai1(){
    }

    public Bai1(String ten, String nhaSanXuat, int soLuongBanhXe) {
        this.ten = ten;
        this.nhaSanXuat = nhaSanXuat;
        this.soLuongBanhXe = soLuongBanhXe;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getSoLuongBanhXe() {
        return soLuongBanhXe;
    }

    public void setSoLuongBanhXe(int soLuongBanhXe) {
        this.soLuongBanhXe = soLuongBanhXe;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập tên xe:");
        ten = sc.nextLine();
        System.out.printf("Nhà sản xuất:");
        nhaSanXuat = sc.nextLine();
        System.out.printf("Số lượng bánh xe:");
        soLuongBanhXe = sc.nextInt();
        System.out.println("Cảm ơn!!!");

    }
    
    public String display(){
       return "Bai1{" + "ten=" + ten+ ", nhaSanXuat=" + nhaSanXuat+ ",soLuongBanhXe=" + soLuongBanhXe + '}';
        
    }
    
}
