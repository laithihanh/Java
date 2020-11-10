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
public class Bai13 {
    public static void main(String[] args) {
        int n;
	
               Scanner input = new Scanner(System.in);
		System.out.printf("Nhập vào số n: ");
                n = input.nextInt();
		if (n < 2)
			System.out.printf("Số nhập vào không hợp lệ ");
                System.out.printf( +n+ "=");
	for(int i=2;i<=n;i++){
        while(n%i==0){
            if(n==i)
                System.out.printf(i+" ");
            else 
                System.out.printf(i+ "*");
            n=n/i;
        }
        } 
    }
}
