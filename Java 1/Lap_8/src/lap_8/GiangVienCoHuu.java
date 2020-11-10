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
public class GiangVienCoHuu extends Bai1{
    private double Luong; 
   private static int SoGioQuyDinh = 40;

    public GiangVienCoHuu() {
    }

    public GiangVienCoHuu(double Luong, String TenGiangVien, String DiaChi, String DienThoai, float SoGioGiang) {
        super(TenGiangVien, DiaChi, DienThoai, SoGioGiang);
        this.Luong = Luong;
    }

    public double getLuong() {
        return Luong;
    }

    public void setLuong(double Luong) {
        this.Luong = Luong;
    }
    
    @Override
    public void input() {
        super.input();
        Scanner nhap = new Scanner(System.in);
        System.out.printf("\tNhập lương thỏa thuận:");
        this.Luong = nhap.nextDouble();
        nhap.nextLine();
    }
    @Override  
    public void display() {
        super.display();
        System.out.println("|\t\tLương thỏa thuận:"+getLuong() + "\t|\tSô giờ có thể giảng dạy:" + SoGioQuyDinh);
    }
}
