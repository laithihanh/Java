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
public class BTH7 {
    public static void main(String[] args) {
    int a;
    Scanner input = new Scanner(System.in);
    System.out.print("Nhập số a: ");
        a = input.nextInt();
        
    System.out.println("Giai thừa của " +a+ " là: "+ BTH7.tinhGiaithua(a));
    }
    public static long tinhGiaithua(int n) {
        long giai_thua = 1;
        if (n == 0 || n == 1) {
            return giai_thua;
        } else {
            for (int i = 2; i <= n; i++) {
                giai_thua *= i;
            }
            return giai_thua;
        }
    }
}
