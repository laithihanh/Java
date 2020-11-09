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
public class Bai1 {
    private int mahh; // Mã hàng hóa
    private String tenhh; // Tên hàng
    private String nhasx; // Nhà sản xuất
    private int soluong; // Số lượng (trong kho)
    private float giagoc; // Giá gốc (VNĐ)
    private int vat;

    public Bai1() {
    }

    public Bai1(int mahh, String tenhh, String nhasx, int soluong, float giagoc, int vat) {
        this.mahh = mahh;
        this.tenhh = tenhh;
        this.nhasx = nhasx;
        this.soluong = soluong;
        this.giagoc = giagoc;
        this.vat = vat;
    }

    public int getMahh() {
        return mahh;
    }

    public void setMahh(int mahh) {
        this.mahh = mahh;
    }

    public String getTenhh() {
        return tenhh;
    }

    public void setTenhh(String tenhh) {
        this.tenhh = tenhh;
    }

    public String getNhasx() {
        return nhasx;
    }

    public void setNhasx(String nhasx) {
        this.nhasx = nhasx;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getGiagoc() {
        return giagoc;
    }

    public void setGiagoc(float giagoc) {
        this.giagoc = giagoc;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }
    
    public void input() {
        Scanner s = new Scanner(System.in);
        // System.out.println("Mã sản phẩm: ");
        // this.mahh = s.nextInt();
        System.out.println("Tên sản phẩm: ");
        this.tenhh = s.nextLine();
        System.out.println("Nhà sản xuất: ");
        this.nhasx = s.nextLine();
        // s.nextLine(); // clear
        System.out.println("Số lượng: ");
        this.soluong = s.nextInt();
        System.out.println("Giá gốc: ");
        this.giagoc = s.nextFloat();
        System.out.println("VAT: ");
        this.vat = s.nextInt();
        System.out.println("Cảm ơn");
    }
    public void output() {
        System.out.printf("%2d %-15s %-15s %3d %8.2f %2d\n",
        this.mahh, this.tenhh, this.nhasx, this.soluong, this.giagoc, this.vat);
    }
}
