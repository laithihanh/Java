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
public class Bai3 {
    public static void main(String[] args) {
        int [] arr;
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập n: ");
        n = input.nextInt();
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Nhập phần tử mảng:");
            arr[i] = input.nextInt();
        }
        System.out.printf("\tMảng vừa nhập là:");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + "\t");
        }
        System.out.println("");
    }
}
