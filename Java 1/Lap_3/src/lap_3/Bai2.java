/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_3;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bai2 {
    public static void main(String[] args) {
        int i,n, sum=0;
        Scanner input = new Scanner(System.in);
        System.out.printf("Nhập số nguyên n:");
        n=input.nextInt();
        for(i=0; i<=n; i++){
            sum = sum +i;
        }
        System.out.println("Tổng là:"+sum);
    }
}
