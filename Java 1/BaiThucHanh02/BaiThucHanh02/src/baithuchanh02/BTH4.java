/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baithuchanh02;

import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class BTH4 {
    public static void main(String[] args) {
        int a,b,c;
        float p,s,cv;
        Scanner songuyen = new Scanner(System.in);
        System.out.print("Nhập số nguyên a: ");
        a = songuyen.nextInt();
        
        System.out.print("Nhập số nguyên b: ");
        b = songuyen.nextInt(); 
        
        System.out.print("Nhập số nguyên c: ");
        c = songuyen.nextInt(); 
        if((a + b > c) || (a + c > b) || (b + c > a)){
            System.out.println("Đây là tam giác!");
                if((a == b && a!=c)){
                    System.out.println("Đây là tam giác cân !");
                    
                }else if((a == b) && (b == c) && (c == a)){
                    System.out.println("Đây là tam giác đều !");
                }else if((a * a == b * b + c * c) || (b * b == a * a + c * c) || (c * c == b * b + a * a)){
                    System.out.println("Đây là tam giác vuông !");
                }else{
                     System.out.println("Đây là tam giác thường !");
                }
        }else{
             System.out.println("Đây không là tam giác !");
        }
        
        
     }
}
