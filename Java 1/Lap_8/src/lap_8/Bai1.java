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
public class Bai1 {
    private String TenGiangVien; 
    private String DiaChi; 
    private String DienThoai; 
    private float SoGioGiang;

    public Bai1() {
    }

    public Bai1(String TenGiangVien, String DiaChi, String DienThoai, float SoGioGiang) {
        this.TenGiangVien = TenGiangVien;
        this.DiaChi = DiaChi;
        this.DienThoai = DienThoai;
        this.SoGioGiang = SoGioGiang;
    }

    public String getTenGiangVien() {
        return TenGiangVien;
    }

    public void setTenGiangVien(String TenGiangVien) {
        this.TenGiangVien = TenGiangVien;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public float getSoGioGiang() {
        return SoGioGiang;
    }

    public void setSoGioGiang(float SoGioGiang) {
        this.SoGioGiang = SoGioGiang;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập tên giảng viên:");
        TenGiangVien = sc.nextLine();
        System.out.printf("\tĐịa chỉ:");
        DiaChi = sc.nextLine();
        System.out.printf("\tSố điện thoại:");
        DienThoai = sc.nextLine();
        System.out.printf("\tSố giờ giảng:");
        SoGioGiang = sc.nextFloat();
        

    }
    
    public void display(){
        StringBuilder buider = new StringBuilder();
        buider.append("|");
        buider.append(TenGiangVien);
        buider.append("\t|\t");
        buider.append(DiaChi);
        buider.append("\t|\t");
        buider.append(DienThoai);
        buider.append("\t|\t");
        buider.append(SoGioGiang);
        
        System.out.print(buider.toString());
    }
}
