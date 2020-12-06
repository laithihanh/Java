/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_3;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai6 {
     public static void main(String[] args) {
     int n,m,i,j;
     Scanner input = new Scanner(System.in);
        System.out.printf("Nhập chiều dài n: ");
        n = input.nextInt();
        System.out.printf("Nhập chiều rộng m: ");
        m = input.nextInt();
        
        for(;n<=0 || m <= 0;){
            if(n <= 0){
                System.out.printf("Phai nhap n > 0 \nNhap lai n: ");
                 n = input.nextInt();
            }
            if(m <= 0){
                System.out.printf("Phai nhap m > 0 \nNhap lai m: ");
                n = input.nextInt();
            }
        }
        for( i = 1; i <= n; i++){
        for(  j = 1 ; j <= m; j++){
            if(i == 1 || j == 1 || i == n || j == m){
                System.out.printf("*");
            }
            else{
                System.out.printf(" ");
            }
        }
        System.out.printf("\n");
    }
     }
}
