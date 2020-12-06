/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL2;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Book {
   private int MaSach;
   private String TenSach;
   private int TheLoai;
   private int NXB;
   private int SoTrang;
   private float GiaTien;

    public Book() {
    }

    public Book(int MaSach, String TenSach, int TheLoai, int NXB, int SoTrang, float GiaTien) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TheLoai = TheLoai;
        this.NXB = NXB;
        this.SoTrang = SoTrang;
        this.GiaTien = GiaTien;
    }

    public int getMaSach() {
        return MaSach;
    }

    public void setMaSach(int MaSach) {
        this.MaSach = MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public int getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(int TheLoai) {
        this.TheLoai = TheLoai;
    }

    public int getNXB() {
        return NXB;
    }

    public void setNXB(int NXB) {
        this.NXB = NXB;
    }

    public int getSoTrang() {
        return SoTrang;
    }

    public void setSoTrang(int SoTrang) {
        this.SoTrang = SoTrang;
    }

    public float getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(float GiaTien) {
        this.GiaTien = GiaTien;
    }
   
    public void input() {
        Scanner s = new Scanner(System.in);
        // System.out.println("Mã sản phẩm: ");
        // this.MaSach = s.nextInt();
        System.out.printf("\tTên sách: ");
        this.TenSach = s.nextLine();
        while(true){
            if(TenSach.length()> 0){
                 break;
            }else{
                System.err.printf("\tTên sách không được để trống\n");
                System.out.printf("\tNhập lại:");
                TenSach = s.nextLine(); 
            }
        }
        
        while (true) {
            try {
                System.out.printf("\tThể loại sách: ");
                this.TheLoai = s.nextInt();
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số");
                  s.nextLine();
            }
        }
        // s.nextLine(); // clear
        
        while (true) {
            try {
                System.out.printf("\tNhà xuất bản: ");
                this.NXB = s.nextInt();
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số");
                  s.nextLine();
            }
        }
       
        while (true) {
            try {
                System.out.printf("\tSố trang: ");
                this.SoTrang = s.nextInt();
                while(SoTrang < 0){
                    System.err.println("\tSố trang phải lớn hơn 0");
                    System.out.printf("\tNhập lại:");
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số");
                  s.nextLine();
            }
        }
        
        while (true) {
            try {
                System.out.printf("\tGiá tiền: ");
                this.GiaTien = s.nextFloat();
                while(GiaTien < 0){
                    System.err.println("\tGiá tiền phải lớn hơn 0");
                    System.out.printf("\tNhập lại:");
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số");
                  s.nextLine();
            }
        }
        
        System.out.printf("Cảm ơn");
    }
}
