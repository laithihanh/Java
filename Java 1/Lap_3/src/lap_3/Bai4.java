/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_3;

import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bai4 {
    public static void main(String[] args) {
        int a;
        
        Scanner input = new Scanner(System.in);
        System.out.printf("Nhập số a: ");
        a = input.nextInt();
        int count=0;
         for (int i = 2; i<=sqrt(a); i++) {
            if (a % i == 0) {
                count++;
            }
        }
        if(count==0){
            System.out.println("Số "+a+" là số nguyên tố ");
        }else{
              System.out.println("Số "+a+" không là số nguyên tố ");
        }
    }
}
