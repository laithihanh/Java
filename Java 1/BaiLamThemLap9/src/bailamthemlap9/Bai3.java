/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bailamthemlap9;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai3 {
    String NhanHieu;
    float TrongLuong;
    Date HanSuDung;

    public Bai3() {
    }

    public Bai3(String NhanHieu, float TrongLuong, Date HanSuDung) {
        this.NhanHieu = NhanHieu;
        this.TrongLuong = TrongLuong;
        this.HanSuDung = HanSuDung;
    }

    public String getNhanHieu() {
        return NhanHieu;
    }

    public void setNhanHieu(String NhanHieu) {
        this.NhanHieu = NhanHieu;
    }

    public float getTrongLuong() {
        return TrongLuong;
    }

    public void setTrongLuong(float TrongLuong) {
        this.TrongLuong = TrongLuong;
    }

    public Date getHanSuDung() {
        return HanSuDung;
    }

    public void setHanSuDung(Date HanSuDung) {
        this.HanSuDung = HanSuDung;
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập nhãn hiệu sữa:");
        NhanHieu = sc.nextLine();
        System.out.printf("\tNhập trọng lượng:");
        TrongLuong = sc.nextFloat();
        System.out.printf("\tNhập hạn sử dụng:");
//        HanSuDung = sc.nextDate();
        

    }
    public void display(){
       
        System.out.println("\tNhãn hiệu:"+NhanHieu);
        System.out.println("\tTrọng lượng:"+TrongLuong);
        System.out.println("\tHạn sử dụng:"+HanSuDung);
    }
}
