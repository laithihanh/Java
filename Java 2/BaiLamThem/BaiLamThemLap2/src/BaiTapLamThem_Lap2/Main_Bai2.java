/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTapLamThem_Lap2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Main_Bai2 {
    List<Bai2> lstSua = new ArrayList();
    public void nhap(){
        Scanner nhap = new Scanner(System.in);
        System.out.printf("Nhập số lượng sữa:");
        int n = nhap.nextInt();
        nhap.nextLine();
        for(int i = 0 ; i< n; i++){
           System.out.println("Hộp " + (i + 1));
            Bai2 bai2= new Bai2();
            bai2.input();
            lstSua.add(i, bai2);
            
        }  
    }
    public void display(){
        System.out.println("Danh sách sản phẩm vừa nhập là:");
        System.out.println("NhanHieu \t TrongLuong \t HSD ");
        for (Bai2 f: lstSua) {
            f.display();
            System.out.println("");
            System.out.println("================================================");
        }
        
    }
    public void sort(){
        
        Collections.sort(lstSua, (Bai2 o1,Bai2 o2)-> (int) (o1.YearHSD() - o2.YearHSD()));
        System.out.println("Danh sách sản phẩm tăng dần theo hạn sử dụng là:");
        System.out.println("NhanHieu \t TrongLuong \t HSD ");
        for (Bai2 f: lstSua) {
            f.display();
            System.out.println("");
            System.out.println("================================================");
        }
       
        
    }
    public static void main(String[] args) {
        Main_Bai2 bai2 = new Main_Bai2();
        bai2.nhap();
        bai2.display();
        bai2.sort();
    }
}
