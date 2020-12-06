/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_6;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai7 {
    public static void main(String[] args) {
        int [] arr;
        int n;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập n: ");
        n = input.nextInt();
        arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("Nhập phần tử mảng thứ "+i+":");
                arr[i] = input.nextInt();
            }
        System.out.printf("\tMảng vừa nhập là:");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + "\t");
        }
        System.out.println(" ");
        System.out.printf("\tSố chẵn trong mảng là:");
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2==0){
                System.out.printf(arr[i]+ "\t");
            }
        }
        System.out.println(" ");
     }
}
