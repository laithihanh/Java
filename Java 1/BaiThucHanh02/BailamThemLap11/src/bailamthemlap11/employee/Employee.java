/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bailamthemlap11.employee;

import bailamthemlap11.Bai2.Person;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Employee extends Person {
    private String TenCongTy;//Tên công ty
    private String PhongBan;//- Phòng ban
    private String ViTri;//- Vị trí
    private float TongLuong;//  Tổng lương

    public Employee() {
    }

    public Employee(String TenCongTy, String PhongBan, String ViTri, float TongLuong, String HoTen, Boolean GioiTinh, LocalDate NgaySinh, String QueQuan) {
        super(HoTen, GioiTinh, NgaySinh, QueQuan);
        this.TenCongTy = TenCongTy;
        this.PhongBan = PhongBan;
        this.ViTri = ViTri;
        this.TongLuong = TongLuong;
    }

    public String getTenCongTy() {
        return TenCongTy;
    }

    public void setTenCongTy(String TenCongTy) {
        this.TenCongTy = TenCongTy;
    }

    public String getPPhongBan() {
        return PhongBan;
    }

    public void setPhonhBan(String PhongBan) {
        this.PhongBan = PhongBan;
    }

    public String getViTri() {
        return ViTri;
    }

    public void setViTri(String ViTri) {
        this.ViTri = ViTri;
    }

    public float getTongLuong() {
        return TongLuong;
    }

    public void setTongLuong(float TongLuong) {
        this.TongLuong = TongLuong;
    }
    @Override
    public void input() {
        super.input();
       Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập tên công ty:");
        TenCongTy = input.nextLine();
        System.out.printf("\tNhập phòng ban:");
        PhongBan = input.nextLine();
        System.out.printf("\tNhập vị trí:");
        ViTri = input.nextLine();
        System.out.printf("\tNhập tổng lương:");
        TongLuong = input.nextFloat();
    }

    @Override
    public void display() {
        super.display();
        System.out.println("\tTên công ty: "+TenCongTy);
        System.out.println("\tPhòng ban "+TenCongTy);
        System.out.println("\tGiá xe: "+ViTri);
        System.out.println("\tGiá xe: "+TongLuong);
    }
}
