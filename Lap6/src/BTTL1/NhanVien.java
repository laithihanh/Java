/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL1;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class NhanVien {
    private int MaNV; 
    private String HoTen; 
    private int NamSinh; 
    private String PhongBan; 
    private String Email; 

    public NhanVien() {
    }

    public NhanVien(int MaNV, String HoTen, int NamSinh, String PhongBan, String Email) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.NamSinh = NamSinh;
        this.PhongBan = PhongBan;
        this.Email = Email;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public int getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(int NamSinh) {
        this.NamSinh = NamSinh;
    }

    public String getPhongBan() {
        return PhongBan;
    }

    public void setPhongBan(String PhongBan) {
        this.PhongBan = PhongBan;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public void input() {
    Scanner s = new Scanner(System.in);
    // System.out.println("Mã sản phẩm: ");
    // this.MaNV = s.nextInt();
    System.out.printf("\tTên nhân viên: ");
    this.HoTen = s.nextLine();
    System.out.printf("\tNăm sinh: ");
    this.NamSinh = s.nextInt();
     s.nextLine(); 
    System.out.printf("\tPhòng ban: ");
    this.PhongBan = s.nextLine();
    System.out.printf("\tEmail: ");
    this.Email = s.nextLine();
    
    }
    public void output() {
        System.out.printf("%d %13s %15d %10s %25s\n",
           this.MaNV, this.HoTen, this.NamSinh, this.PhongBan, this.Email);
    }
}
