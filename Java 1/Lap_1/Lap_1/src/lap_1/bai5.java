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
public class bai5 {
    public static void main(String[] args) {
        int n,m,c;
       
        Scanner songuyen = new Scanner(System.in);
        
        System.out.print("Nhập n: ");
        n = songuyen.nextInt();
        
        System.out.print("Nhập m: ");
        m = songuyen.nextInt();
        
        c=m+n;
        System.out.println("Tổng 2 số m n vừa nhập là:" +c);
  
    }
}
