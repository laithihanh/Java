/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_8;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class GiangVienThinhGiang extends Bai1{
    private String CoQuanLamViec; 
    private float  GioCoTheGiangDay; 

    public GiangVienThinhGiang() {
    }

    public GiangVienThinhGiang(String CoQuanLamViec, float GioCoTheGiangDay, String TenGiangVien, String DiaChi, String DienThoai, float SoGioGiang) {
        super(TenGiangVien, DiaChi, DienThoai, SoGioGiang);
        this.CoQuanLamViec = CoQuanLamViec;
        this.GioCoTheGiangDay = GioCoTheGiangDay;
    }

    public String getCoQuanLamViec() {
        return CoQuanLamViec;
    }

    public void setCoQuanLamViec(String CoQuanLamViec) {
        this.CoQuanLamViec = CoQuanLamViec;
    }

    public float getGioCoTheGiangDay() {
        return GioCoTheGiangDay;
    }

    public void setGioCoTheGiangDay(float GioCoTheGiangDay) {
        this.GioCoTheGiangDay = GioCoTheGiangDay;
    }
    
    @Override
    public void input() {
        super.input();
        Scanner nhap = new Scanner(System.in);
        System.out.printf("\tNhập cơ quan làm việc:");
        this.CoQuanLamViec = nhap.nextLine();
        System.out.printf("\tGiờ có thể giảng dạy:");
        this.GioCoTheGiangDay = nhap.nextFloat();
        
    }
    @Override
    public void display() {
        super.display();
        System.out.println("\tCơ quan làm việc:"+CoQuanLamViec);
        System.out.println("\tGiờ có thể giảng dạy:"+GioCoTheGiangDay);
        System.out.println("|\t\tLương thỏa thuận:"+getCoQuanLamViec() + "\t|\tSố giờ có thể giảng dạy:" + GioCoTheGiangDay);
    }
}
