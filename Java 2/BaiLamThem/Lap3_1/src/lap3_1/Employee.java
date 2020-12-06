/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap3_1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Employee {
    private String MaNv;
    private String HoTen;
    private boolean GioiTinh;
    private LocalDate NgaySinh;
    private String QueQuan;
    private String PhongBan;
    private String ViTri;
    private float TongLuong;

    public Employee() {
    }

    public Employee(String MaNv, String HoTen, boolean GioiTinh, LocalDate NgaySinh, String QueQuan, String PhongBan, String ViTri, float TongLuong) {
        this.MaNv = MaNv;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.QueQuan = QueQuan;
        this.PhongBan = PhongBan;
        this.ViTri = ViTri;
        this.TongLuong = TongLuong;
    }

    public String getMaNv() {
        return MaNv;
    }

    public void setMaNv(String MaNv) {
        this.MaNv = MaNv;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
    public String getGioiTinh(){
        return GioiTinh == true ? "Nữ":"Nam";
    }

    public LocalDate getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(LocalDate NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String QueQuan) {
        this.QueQuan = QueQuan;
    }

    public String getPhongBan() {
        return PhongBan;
    }

    public void setPhongBan(String PhongBan) {
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
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập mã nhân viên:");
        MaNv = sc.nextLine();
        System.out.printf("\tNhập tên:");
        HoTen= sc.nextLine();
        System.out.printf("\tNhập giới tính:");
        GioiTinh= sc.nextBoolean();
        sc.nextLine();
        System.out.printf("\tNhập ngày sinh:");
        NgaySinh = string2LocalDate(sc);
        System.out.printf("\tNhập quê quán:");
        QueQuan = sc.nextLine();
        System.out.printf("\tNhập phòng ban:");
        PhongBan = sc.nextLine();
        System.out.printf("\tNhập vị trí:");
        ViTri = sc.nextLine();
        System.out.printf("\tNhập tổng lương:");
        TongLuong = sc.nextFloat();
    }
    public LocalDate string2LocalDate( Scanner sc){
        LocalDate ld = null;
        try{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ld = LocalDate.parse(sc.nextLine(),dateTimeFormatter);
        }catch(DateTimeParseException e){
               System.err.println("\tNgày sinh không hợp lệ (dd/MM/yyyy)");
               System.out.printf("\tNhập lại :");
               sc.nextLine();
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return ld;
    }
    @Override
    public String toString() {
        return  "MaNv=" + MaNv + ", HoTen=" + HoTen + ", GioiTinh=" + getGioiTinh() + ", NgaySinh=" + NgaySinh + ", QueQuan=" + QueQuan + ", PhongBan=" + PhongBan + ", ViTri=" + ViTri + ", TongLuong=" + TongLuong;
    }

    int compareTo(Employee value) {
        return (int) getTongLuong();
    }
   
    
}
