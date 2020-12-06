/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bailamthemlap11;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bai1 implements Comparable<Bai1>{

    private String HoTen;//(30 ký tự)
    private  LocalDate  NgaySinh;// (kiểu ngày)
    private float Luong; //(số thực)
    private int GioiTinh;//(0. Nữ, 1. Nam)

    public Bai1() {
    }

    public Bai1(String HoTen, LocalDate NgaySinh, float Luong, int GioiTinh) {
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.Luong = Luong;
        this.GioiTinh = GioiTinh;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public LocalDate getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(LocalDate NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public float getLuong() {
        return Luong;
    }

    public void setLuong(float Luong) {
        this.Luong = Luong;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
    @Override
    public String toString() {
//        System.out.println("Danh sách vừa nhập là:");
        System.out.println("\tTên:"+HoTen);
        System.out.println("\tNăm sinh:"+NgaySinh);
        System.out.println("\tLương:"+Luong);
        System.out.println("\tGiới tính:"+(GioiTinh == 0 ? "Nữ" : "Nam"));
        return "";
    }

    @Override
    public int compareTo(Bai1 o) {
       return this.NgaySinh.getYear()-o.NgaySinh.getYear();
    }
    
    
}
