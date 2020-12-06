/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baithuchanh02;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class BTH1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a,b,c,d,x,y,max;
        Scanner songuyen = new Scanner(System.in);
        System.out.print("Nhập số nguyên a: ");
        a = songuyen.nextInt();
        
        System.out.print("Nhập số nguyên b: ");
        b = songuyen.nextInt();
        
        System.out.print("Nhập số nguyên c: ");
        c = songuyen.nextInt();
        
        System.out.print("Nhập số nguyên d: ");
        d = songuyen.nextInt();
        
        x=a;
        y=c;
        if(a<b){
            x=b;
        }
        if(c<d){
            y=d;
        }
        max=x;
        if(y>x){
            max=y;
            System.out.print("Số lớn nhất là: "+max);
        }
    }
    
}
