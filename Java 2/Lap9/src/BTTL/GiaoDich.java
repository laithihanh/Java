/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class GiaoDich {
    private int MaGD;
    private String TenGD;
    private String LoaiDG;
    private LocalTime GioGD;
    private LocalDate NgayGD;
    private String Mota;

    public GiaoDich() {
    }
    

    public GiaoDich(int MaGD, String TenGD, String LoaiDG, LocalTime GioGD, LocalDate NgayGD, String Mota) {
        this.MaGD = MaGD;
        this.TenGD = TenGD;
        this.LoaiDG = LoaiDG;
        this.GioGD = GioGD;
        this.NgayGD = NgayGD;
        this.Mota = Mota;
    }

    public int getMaGD() {
        return MaGD;
    }

    public void setMaGD(int MaGD) {
        this.MaGD = MaGD;
    }

    public String getTenGD() {
        return TenGD;
    }

    public void setTenGD(String TenGD) {
        this.TenGD = TenGD;
    }

    public String getLoaiDG() {
        return LoaiDG;
    }

    public void setLoaiDG(String LoaiDG) {
        this.LoaiDG = LoaiDG;
    }

    public LocalTime getGioGD() {
        return GioGD;
    }

    public void setGioGD(LocalTime GioGD) {
        this.GioGD = GioGD;
    }

    public LocalDate getNgayGD() {
        return NgayGD;
    }

    public void setNgayGD(LocalDate NgayGD) {
        this.NgayGD = NgayGD;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập tên giao dich:");
        TenGD = sc.nextLine();
        while(true){
            if(TenGD.length()> 0){
                 break;
            }else{
                System.err.printf("\tTên giao dịch không được để trống\n");
                System.out.printf("\tNhập lại:");
                TenGD = sc.nextLine(); 
            }
        }
        System.out.printf("\tNhập loại giao dịch:");
        LoaiDG = sc.nextLine();
        while(true){
            if(LoaiDG.length()> 0){
                 break;
            }else{
                System.err.printf("\tLoại giao dịch không được để trống\n");
                System.out.printf("\tNhập lại:");
                LoaiDG = sc.nextLine(); 
            }
        }
        
        while(true){
            System.out.printf("\tNhập giờ giao dịch:");
            try {
                this.GioGD = LocalTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("HH:mm"));
                break;
            } catch (Exception e) {
                System.out.println("\tKhông đúng định dạng: hh:mm");
            }
        }
        
        while(true){
            System.out.printf("\tNhập ngày giao dịch:");
            try {
                this.NgayGD = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch (Exception e) {
                System.out.println("\tKhông đúng định dạng: dd/MM/yyyy");
            }
        }
        
        System.out.printf("\tNhập mô tả:");
        Mota = sc.nextLine();
        while(true){
            if(Mota.length()> 0){
                 break;
            }else{
                System.err.printf("\tMô tả không được để trống\n");
                System.out.printf("\tNhập lại:");
                Mota = sc.nextLine(); 
            }
        }
    }
    public void output() {
        System.out.printf("%-14d %-14s %-16s %-19s %-22s %-2s\n",
        this.MaGD, this.TenGD, this.LoaiDG, this.GioGD, this.NgayGD, this.Mota);
    }
//    public void output(ETransaction eTran) {
//        System.out.printf("%-14d %-14s %-16s %-19s %-22s %-2s\n",
//        this.MaGD, this.TenGD, this.LoaiDG, this.GioGD, this.NgayGD, this.Mota,
//        eTran.getDateformat(this.ngaynhap));
//        eTran.getCurrency(this.Mota));
//        getText
//    }
    
}