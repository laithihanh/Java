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
public class BTH8 {
    public static void main(String[] args) {
        int nhap,n;
        Scanner input = new Scanner(System.in);
    while(true){
    System.out.println("\t========MENU=======");
    System.out.println("\t1. Nhập một số nguyên n");
    System.out.println("\t2. Chuyển đổi sang số nhị phân");
    System.out.println("\t3. Chuyển đổi sang số bát phân");
    System.out.println("\t4. Chuyển đổi sang số thập lục phân");
    System.out.println("\t5. Thoát");
    
    System.out.printf("Mời bạn chọn:");
    nhap = input.nextInt();

        switch(nhap){
            case 1:
                System.out.printf("Nhập số nguyên n:");
                n = input.nextInt();
                break;
            case 2:
                System.out.printf("Nhập số nguyên n:");
                n = input.nextInt();
                System.out.println("Số nhị phân của "+n+" = " + Integer.toString(n, 2));
                break;
            case 3:
                System.out.printf("Nhập số nguyên n:");
                n = input.nextInt();
                System.out.println("Số bát phân của "+n+" = " + Integer.toString(n, 8));
                break;
            case 4:
                System.out.printf("Nhập số nguyên n:");
                n = input.nextInt();
                System.out.println("Số thập lục phân của "+n+" = " + Integer.toString(n, 16));
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Bạn chọn sai mời chọn lại!!!!");
        }
        }
    }
}
