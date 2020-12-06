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
public class Bai7 {
    public static void main(String[] args) {
        int n,i;
        int sum = 0;
        float TBC;
        Scanner input = new Scanner(System.in);
        System.out.printf("Nhập vào số n: ");
        n = input.nextInt();
        System.out.printf("Các số lẻ <n là:"); 
         for( i=1;i<n;i++){
              if(i%2 == 1)
               System.out.print(i+ " ");
              
         }
        System.out.println( "");
        for( i = 1; i <=n; i++){
            if(i%2!=0){
                sum +=i*i;
            }
        }
        System.out.printf("Tổng bình phương các số lẻ là: " +sum);
        System.out.println( "");
        
        int tong=0;
        for( i = 1; i <=n; i++){
            tong +=i;
        }
        TBC=(float)tong/n;
        System.out.println( "TBC của N số nguyên dương là:" +TBC);
    }
}
