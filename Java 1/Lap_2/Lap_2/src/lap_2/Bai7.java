/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_2;

import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai7 {
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
        if((a>0 && b>0 && c>0) && ((a + b > c) || (a + c > b) || (b + c > a))){
                if((a == b && a!=c)){
                    System.out.println("Đây là tam giác cân !");
                    
                }else if((a == b) && (b == c) && (c == a)){
                    System.out.println("Đây là tam giác đều !");
                }else if((a * a == b * b + c * c) || (b * b == a * a + c * c) || (c * c == b * b + a * a)){
                    System.out.println("Đây là tam giác vuông !");
                }else{
                     System.out.println("Đây là tam giác thường !");
                }
                p=(a+b+c)/2;
                cv = p*2;
                s=(float) sqrt(p*(p-a)*(p-b)*(p-c));
                System.out.println("Chu vi là:"+cv);
                System.out.println("Diện tích là:"+s);
        }else{
             System.out.println("Đây không là tam giác !");
        }
        
        
     }
}
