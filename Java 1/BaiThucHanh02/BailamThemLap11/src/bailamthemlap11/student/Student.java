/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bailamthemlap11.student;

import bailamthemlap11.Bai2.Person;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Student extends Person{
    private String MaSinhVien;//Mã sinh viên
    private String TenLop;//- Tên lớp
    private String KhoaHoc;//- Khóa học

    public Student() {
    }

    public Student(String MaSinhVien, String TenLop, String KhoaHoc, String HoTen, Boolean GioiTinh, LocalDate NgaySinh, String QueQuan) {
        super(HoTen, GioiTinh, NgaySinh, QueQuan);
        this.MaSinhVien = MaSinhVien;
        this.TenLop = TenLop;
        this.KhoaHoc = KhoaHoc;
    }

    public String getMaSinhVien() {
        return MaSinhVien;
    }

    public void setMaSinhVien(String MaSinhVien) {
        this.MaSinhVien = MaSinhVien;
    }

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String TenLop) {
        this.TenLop = TenLop;
    }

    public String getKhoaHoc() {
        return KhoaHoc;
    }

    public void setKhoaHoc(String KhoaHoc) {
        this.KhoaHoc = KhoaHoc;
    }

    @Override
    public void input() {
        super.input();
       Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập mã sinh viên:");
        MaSinhVien = input.nextLine();
        System.out.printf("\tNhập tên lớp:");
        TenLop = input.nextLine();
        System.out.printf("\tNhập khóa học:");
        KhoaHoc = input.nextLine();
    }

    @Override
    public void display() {
        super.display();
        System.out.println("\tMã sinh viên: "+MaSinhVien);
        System.out.println("\tTên lớp "+TenLop);
        System.out.println("\tKhóa học: "+KhoaHoc);
    }
    
}
