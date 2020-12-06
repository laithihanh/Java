/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_4;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bai1 {
    private String maHĐ;
    private String ngayLap;
    private String tenKH;
    private String diaChiGiaoHang;
    private int soLuong;
    private float giaBan;
    private float tongTien;
    private float tienKM;
     private float tongTienThanhToan;
    
    public Bai1() {
    }
    
     public Bai1(String maHĐ, String ngayLap, String tenKH, String diaChiGiaoHang,int soLuong, float giaBan,float tongTien,float tienKM,float tongTienThanhToan) {
        this.maHĐ = maHĐ;
        this.ngayLap = ngayLap;
        this.tenKH = tenKH;
        this.diaChiGiaoHang = diaChiGiaoHang;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public String getMaHĐ() {
        return maHĐ;
    }

    public void setMaHĐ(String maHĐ) {
        this.maHĐ = maHĐ;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChiGiaoHang() {
        return diaChiGiaoHang;
    }

    public void setDiaChiGiaoHang(String diaChiGiaoHang) {
        this.diaChiGiaoHang = diaChiGiaoHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public float getTongTien() {
        tongTien=giaBan*soLuong;
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public float getTienKM() {
        if(soLuong>=10 && soLuong<100){
            this.tienKM=((giaBan/100)*10)*soLuong;
        }else if(soLuong>=100){
            this.tienKM=((tongTien/100)*20);
        }else{
            this.tienKM=0;  
        }
        return tienKM;
    }

    public void setTienKM(float tienKM) {       
        this.tienKM = tienKM;
    }

    public float getTongTienThanhToan() {
        tongTienThanhToan=tongTien-tienKM;
        return tongTienThanhToan;
    }

    public void setTongTienThanhToan(float tongTienThanhToan) {
        this.tongTienThanhToan = tongTienThanhToan;
    }
     
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập mã đơn hàng:");
        maHĐ = sc.nextLine();
        System.out.printf("Ngày lập hóa đơn:");
        ngayLap = sc.nextLine();
        System.out.printf("Nhập tên khách hàng:");
        tenKH = sc.nextLine();
        System.out.printf("Nhap địa chỉ giao hàng:");
        diaChiGiaoHang = sc.nextLine();
        System.out.printf("Nhập số lượng bánh cần giao:");
        soLuong = sc.nextInt();
        System.out.printf("Nhập giá bán 1 chiếc bánh:");
        giaBan =sc.nextFloat();

    }
    
    public void display(){
        System.out.println("Đơn hàng:");
        System.out.println("\tmã đơn hàng:"+maHĐ);
        System.out.println("\tNgày lập hóa đơn:"+ngayLap);
        System.out.println("\tTên khách hàng:"+tenKH);
        System.out.println("\tĐịa chỉ giao hàng:"+diaChiGiaoHang);
        System.out.println("\tSố lượng bánh cần giao:"+soLuong);
        System.out.println("\tGiá bán 1 chiếc bánh:"+giaBan);
        System.out.println("\tTổng tiền hàng:"+getTongTien());
        System.out.println("\tSố tiền khuyễn mại:"+getTienKM());
         System.out.println("\tTổng tiền phải trả:"+getTongTienThanhToan());
    }
}
