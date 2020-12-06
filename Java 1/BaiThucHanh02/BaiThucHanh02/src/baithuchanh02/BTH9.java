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
public class BTH9 {
    public static void main(String[] args) {
    float SoTienGui,LaiSuatNam,SoThangGui;
    
    Scanner input = new Scanner(System.in);
    System.out.print("Nhập số tiền gửi là: ");
        SoTienGui = input.nextFloat();
    System.out.print("Nhập lãi xuất tính theo năm là: ");
        LaiSuatNam = input.nextFloat();
     System.out.print("Nhập số tháng gửi là: ");
        SoThangGui = input.nextFloat();
    }
}
