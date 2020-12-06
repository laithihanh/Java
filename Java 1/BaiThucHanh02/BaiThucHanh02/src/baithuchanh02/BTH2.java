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
public class BTH2 {
    public static void main(String[] args) {
        int thang,nam;
        
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập tháng : ");
        thang = input.nextInt();
        System.out.print("Nhập năm : ");
        nam = input.nextInt();
        
        switch (thang){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.printf("Tháng %d có 31 ngày",thang);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                 System.out.printf("Tháng %d có 30 ngày",thang);
                 break;
            case 2:
                if(nam % 4==0){
                    if(nam %100 ==0){
                        if(nam % 400==0){
                            System.out.print("Năm" +nam+ "là năm nhuận và có 29 ngày");
                        }else{
                            System.out.println("Năm " + nam + " không phải là năm nhuận và có 28 ngày");
                        }
                    }else{
                        System.out.println("Năm " + nam + " là năm nhuận và có 29 ngày");
                    }
                }else{
                    System.out.println("Năm " + nam + " không phải là năm nhuận và có 28 ngày");
                }
        }
    }
}
