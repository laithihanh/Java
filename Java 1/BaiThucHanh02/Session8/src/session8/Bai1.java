/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session8;

import java.util.Scanner;
import sun.security.util.Length;

/**
 *
 * @author ADMIN
 */
public class Bai1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float [] arr;
        int n;
        Scanner input = new Scanner(System.in);
        System.out.printf("Nhập n: ");
        n = input.nextInt();
        arr = new float[n];
        
        System.out.print("Nhập các phần tử mảng:\n");
        for(int i = 0; i <arr.length ; i++){
            System.out.printf("a[%d] = ",i);
            arr[i] = input.nextFloat();
        }
        
        for(int i=0; i<arr.length; i++){
            System.out.println("Mảng vừa nhập là:"+arr[i]);
        }
    }
    
}
