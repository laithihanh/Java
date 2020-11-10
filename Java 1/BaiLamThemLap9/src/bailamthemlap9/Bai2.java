/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bailamthemlap9;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai2 {
    String name;
    float DiemToan;
    float DiemVan;
    float TrungBinh;

    public Bai2() {
    }

    public Bai2(String name, float DiemToan, float DiemVan, float TrungBinh) {
        this.name = name;
        this.DiemToan = DiemToan;
        this.DiemVan = DiemVan;
        this.TrungBinh = TrungBinh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDiemToan() {
        return DiemToan;
    }

    public void setDiemToan(float DiemToan) {
        this.DiemToan = DiemToan;
    }

    public float getDiemVan() {
        return DiemVan;
    }

    public void setDiemVan(float DiemVan) {
        this.DiemVan = DiemVan;
    }

    public float getTrungBinh() {
        TrungBinh= (DiemVan+DiemToan)/2;
        return TrungBinh;
    }

    public void setTrungBinh(float TrungBinh) {
        this.TrungBinh = TrungBinh;
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập tên học sinh:");
        name = sc.nextLine();
        while (name.length()>30) {
            System.out.printf("\tHọ tên phải không vượt quá 30 ký tự\n");
            System.out.printf("\tNhập tên nhân viên:");
            name = sc.nextLine(); 
        }
        while (true) {
            try {
            
                System.out.printf("\tNhập điểm toán:");
                DiemToan = sc.nextFloat();
                System.out.printf("\tNhập điểm văn:");
                DiemVan = sc.nextFloat();
                break;
            } catch (Exception ex) {
                System.out.println("Yêu cầu nhập số:");
                System.out.println(""+ex.getLocalizedMessage());
                  sc.nextLine();
            }
        }
        
       
        

    }
    public void display(){
       
        System.out.println("\tTên:"+name);
        System.out.println("\tĐiểm toán:"+DiemToan);
        System.out.println("\tĐiểm vawn:"+DiemVan);
        System.out.println("\tĐiển trung bình:"+getTrungBinh());
    }
    
    
}
