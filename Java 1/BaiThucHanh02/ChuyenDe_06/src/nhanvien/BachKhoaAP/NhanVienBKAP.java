/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhanvien.BachKhoaAP;

import java.util.Scanner;
import nhanvien.NhanVien;

/**
 *
 * @author ADMIN
 */
public class NhanVienBKAP extends NhanVien{
    float thuong; // Thưởng

    public float getThuong() {
        return thuong;
    }

    public void setThuong(float thuong) {
        this.thuong = thuong;
    }

    @Override
    public float tinhLuong() {
        return soNgayLam * (luongCoBan / 26);
    }
    public float tinhLuong(boolean coThuong) {
        if (coThuong) {
            return soNgayLam * (luongCoBan / 26) + thuong;
        } else {
            return tinhLuong();
        }
    }
    
    public void input() {
        System.out.printf("\tHọ và tên: ");
        this.ten = Inputor.getString();
        System.out.printf("\tĐịa chỉ: ");
        this.diaChi = Inputor.getString();
        System.out.printf("\tLương cơ bản (tháng): ");
        this.luongCoBan = Inputor.getFloat();
        System.out.printf("\tSố ngày làm: ");
        this.soNgayLam = Inputor.getInteger();
        System.out.printf("\tThưởng: ");
        this.thuong = Inputor.getFloat();
        System.out.printf("\tCảm ơn!");
    }

    @Override
    public String xepLoai() {
        if (soNgayLam <= 10) {
            return "KÉM";
        } else if (soNgayLam > 10 && soNgayLam <= 20) {
            return "TRUNG BÌNH";
        } else if (soNgayLam > 20 && soNgayLam <= 24) {
            return "KHÁ";
        } else if (soNgayLam > 24 && soNgayLam <= 26) {
            return "TỐT";
        } else if (soNgayLam > 26) {
            return "XUẤT SẮC";
        } else {
            return "KHÔNG XÁC ĐỊNH";
        }
    }

    @Override
    public void intro() {
        System.out.println("\tXin chào: " + this.ten);
        System.out.println("\t(" + this.diaChi + ")");
        System.out.println("\tLương cơ bản: " + this.luongCoBan);
        System.out.println("\tLương thực lĩnh: " + tinhLuong());
        System.out.println("\tLương thực lĩnh (+ thưởng): " + tinhLuong(true));
        System.out.println("\tXếp loại: " + xepLoai());
    }
    
    
}
