/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_2;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai6 {
    public static void main(String[] args) {
       int n;
       
        Scanner songuyen = new Scanner(System.in);
        System.out.print("Nhập số nguyên n: ");
        n = songuyen.nextInt();
        
        if(n % 2==0){
            System.out.println("N là số chẵn");
        }else{
            System.out.println("N là số lẻ");
        }
    }
    
}
