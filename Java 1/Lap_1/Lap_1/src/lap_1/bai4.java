/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_1;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class bai4 {
    public static void main(String[] args) {
        String a;
        int n;
        float m;
       
        Scanner songuyen = new Scanner(System.in);
        System.out.print("Nhập chuỗi a: ");
        a = songuyen.nextLine();
        
        System.out.print("Nhập n: ");
        n = songuyen.nextInt();
        
        System.out.print("Nhập m: ");
        m = songuyen.nextFloat();
        
        System.out.println("Chuỗi a vừa nhập là:" +a);
        System.out.println("Số nguyên n vừa nhập là:" +n);
        System.out.println("Số thực m vừa nhập là:" +m);
           
       
    }
}
