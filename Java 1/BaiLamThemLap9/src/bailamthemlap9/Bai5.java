/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bailamthemlap9;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai5 {
    private String  TenSach;//tối đa 50 ký tự//
    private String TenTacGia;//tối đa 30 ký tự
    private int NamXuatBan;

    public Bai5() {
    }

    public Bai5(String TenSach, String TenTacGia, int NamXuatBan) {
        this.TenSach = TenSach;
        this.TenTacGia = TenTacGia;
        this.NamXuatBan = NamXuatBan;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public String getTenTacGia() {
        return TenTacGia;
    }

    public void setTenTacGia(String TenTacGia) {
        this.TenTacGia = TenTacGia;
    }

    public int getNamXuatBan() {
        return NamXuatBan;
    }

    public void setNamXuatBan(int NamXuatBan) {
        this.NamXuatBan = NamXuatBan;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập tên sách:");
        TenSach = sc.nextLine();
        while (TenSach.length()>50) {
            System.out.printf("\tTên không quá 50 ký tự\n");
            System.out.printf("\tNhập tên sách:");
            TenSach = sc.nextLine(); 
        }
        System.out.printf("\tNhập tác giả:");
        TenTacGia = sc.nextLine();
        while (TenTacGia.length()>30) {
            System.out.printf("\tTên tác giả không quá 30 ký tự\n");
            System.out.printf("\tNhập tên tác giả:");
            TenTacGia = sc.nextLine(); 
        }
        while (true) {
            try {
            
                System.out.printf("\tNhập năm xuất bản :");
                NamXuatBan = sc.nextInt();
                break;
            } catch (Exception ex) {
                System.out.println("Yêu cầu nhập số:");
                System.out.println(""+ex.getLocalizedMessage());
                  sc.nextLine();
            }
        }
    }
    public void display(){
       
        System.out.println("\tTên sách:"+TenSach);
        System.out.println("\tTên tác giả:"+TenTacGia);
        System.out.println("\tNăm xuất bản:"+NamXuatBan);
    }
}
