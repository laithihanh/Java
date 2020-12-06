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
public class Bai4 {
    private String  MaPhong;//tối đa 5 ký tự//
    private String TenPhong;//tối đa 30 ký tự
    float DonGiaThue;// số thực
    private int SoLuongGiuong;//số nguyên
    private int TinhTrangPhong;//0 rảnh,1 bân

    public Bai4() {
    }

    public Bai4(String MaPhong, String TenPhong, float DonGiaThue, int SoLuongGiuong, int TinhTrangPhong) {
        this.MaPhong = MaPhong;
        this.TenPhong = TenPhong;
        this.DonGiaThue = DonGiaThue;
        this.SoLuongGiuong = SoLuongGiuong;
        this.TinhTrangPhong = TinhTrangPhong;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public void setTenPhong(String TenPhong) {
        this.TenPhong = TenPhong;
    }

    public float getDonGiaThue() {
        return DonGiaThue;
    }

    public void setDonGiaThue(float DonGiaThue) {
        this.DonGiaThue = DonGiaThue;
    }

    public int getSoLuongGiuong() {
        return SoLuongGiuong;
    }

    public void setSoLuongGiuong(int SoLuongGiuong) {
        this.SoLuongGiuong = SoLuongGiuong;
    }

    public int getTinhTrangPhong() {
        return TinhTrangPhong;
    }

    public void setTinhTrangPhong(int TinhTrangPhong) {
        this.TinhTrangPhong = TinhTrangPhong;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập mã phòng:");
        MaPhong = sc.nextLine();
        while (MaPhong.length()>5) {
            System.out.printf("\tMã phòng không quá 5 ký tự\n");
            System.out.printf("\tNhập mã phòng:");
            MaPhong = sc.nextLine(); 
        }
        System.out.printf("\tNhập tên phòng:");
        TenPhong = sc.nextLine();
        while (TenPhong.length()>30) {
            System.out.printf("\tTên phòng không quá 30 ký tự\n");
            System.out.printf("\tNhập tên phòng:");
            TenPhong = sc.nextLine(); 
        }
        while (true) {
            try {
            
                System.out.printf("\tNhập đơn giá thuê :");
                DonGiaThue = sc.nextFloat();
                break;
            } catch (Exception ex) {
                System.out.println("Yêu cầu nhập số:");
                System.out.println(""+ex.getLocalizedMessage());
                  sc.nextLine();
            }
        }
        while (true) {
            try {
                System.out.printf("\tNhập số lượng giường :");
                SoLuongGiuong = sc.nextInt();
                break;
            } catch (Exception ex) {
                System.out.println("Yêu cầu nhập số:");
                System.out.println(""+ex.getLocalizedMessage());
                  sc.nextLine();
            }
        }
        System.out.printf("\tTình trạng phòng(0 rảnh,1 bận):");
        TinhTrangPhong = sc.nextInt();
        while ((TinhTrangPhong!=0) && (TinhTrangPhong !=1)) {
            System.out.printf("\tRảnh (0), Bận (1):");
            TinhTrangPhong = sc.nextInt(); 
        }
        
    }
    public void display(){
       
        System.out.println("\tMã:"+MaPhong);
        System.out.println("\tTên phòng:"+TenPhong);
        System.out.println("\tĐơn giá thuê:"+DonGiaThue);
        System.out.println("\tSố lượng giường:"+SoLuongGiuong);
        System.out.println("\tTình trạng phòng(0 rảnh,1 bận):"+TinhTrangPhong);
    }
}
