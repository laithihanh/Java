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
public class Bai3 {
     public static void main(String[] args) {
        int a,b;
        
        Scanner input = new Scanner(System.in);
        System.out.printf("Nhập số a: ");
        a = input.nextInt();
        System.out.printf("Nhập số b: ");
        b = input.nextInt();
        
        System.out.println("UCLN của "+a+" và "+b+" là:" +UCLN(a,b));
        System.out.println("BCNN "+a+" và "+b+" là:" +((a*b)/UCLN(a,b)));
     }
       public static int UCLN(int a, int b){
                while(a!= b){
                    if(a>b){
                       a= a-b;
                    } 
                    else{
                        b= b-a;
                    } 
                }
                return (a);
            }
}
