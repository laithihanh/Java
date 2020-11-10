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
public class bai6 {
    public static void main(String[] args) {
        int n1,m1,n1m1;
        float n2,m2,n2m2,c;
        Scanner songuyen = new Scanner(System.in);
        
        System.out.print("Nhập số nguyên n1: ");
        n1 = songuyen.nextInt();
        
        System.out.print("Nhập số nguyên m1: ");
        m1 = songuyen.nextInt();
        
        System.out.print("Nhập số thực n2: ");
        n2 = songuyen.nextFloat();
        
        System.out.print("Nhập số thực m2: ");
        m2 = songuyen.nextFloat();
        
        n1m1 = m1+n1;
        n2m2 = n2+m2;
        c = n1+n2;
        
        System.out.println("Tổng 2 số nguyên vừa nhập là:" +n1m1);
        System.out.println("Tổng 2 số thực vừa nhập là:" +n2m2);
        System.out.println("Tổng 2 số thực và nguyên vừa nhập là:" +c);
    }
}
