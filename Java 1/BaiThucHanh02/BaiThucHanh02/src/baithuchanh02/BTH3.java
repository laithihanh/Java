/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baithuchanh02;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class BTH3 {
     public static void main(String[] args) {
    int  ChiSoCu,ChiSoMoi,DinhMuc=50,DonGiaDinhMuc=230,TienThueBaoDienKe=1000,PhanDinhMuc,PhanVuotDinhMuc,LuongDienSuDung;
    
    Scanner input = new Scanner(System.in);
    System.out.printf("Nhập vào chỉ số cũ: ");
    ChiSoCu = input.nextInt();
    System.out.printf("Nhập vào chỉ số mới: ");
    ChiSoMoi = input.nextInt();
    
    LuongDienSuDung= ChiSoMoi-ChiSoCu;
        if (LuongDienSuDung > DinhMuc){
            PhanDinhMuc=DinhMuc;
            PhanVuotDinhMuc = LuongDienSuDung - DinhMuc;//Nếu dùng quá định mức
            //thì phần vượt định mức bằng lượng điện sử dụng trừ đi định mức
        }else{
            PhanVuotDinhMuc = 0;//Nếu dùng không quá định mức thì phần vượt định mức = 0
            PhanDinhMuc=LuongDienSuDung;
        }
    int DonGiaVuotDinhMuc =0;
        if(PhanVuotDinhMuc <= 50){
            DonGiaVuotDinhMuc = 480;
        }else if(PhanVuotDinhMuc <100){
            DonGiaVuotDinhMuc = 700;
        }else if(PhanVuotDinhMuc <= 100){
             DonGiaVuotDinhMuc = 900;
        }
    int TienTraDinhMuc = PhanDinhMuc * DonGiaDinhMuc;
    int TienVuotDinhMuc = PhanVuotDinhMuc * DonGiaVuotDinhMuc;
    int TongTienPhaiTra = TienTraDinhMuc+TienVuotDinhMuc + TienThueBaoDienKe;
    
    System.out.println("Chỉ sô cũ là: "+ChiSoCu);
    System.out.println("Chỉ sô mới là: "+ChiSoMoi);
    System.out.println("Tiền trả định mức là: "+TienTraDinhMuc);
    System.out.println("Tiền trả vượt định mức là: "+TienVuotDinhMuc);
    System.out.println("Tổng tiền phải trả là: "+TongTienPhaiTra);
    }
}
