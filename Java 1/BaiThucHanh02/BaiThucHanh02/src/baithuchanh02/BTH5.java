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
public class BTH5 {
    public static void main(String[] args) {
    int n;
    int sum = 0, temp;
        Scanner songuyen = new Scanner(System.in);
        System.out.print("Nhập số nguyên có 3 chữ số n: ");
        n = songuyen.nextInt();
        
        while (n != 0) {
        temp = n % 10;
        if (temp % 2 == 0)
            sum += temp;
        n /= 10;
        }
         System.out.print("Tổng các số chẵn trong số nguyên n là: "+sum);
         System.out.println(" ");
    }
}
