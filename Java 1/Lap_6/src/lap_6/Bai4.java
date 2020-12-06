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
public class Bai4 {
    public static void main(String[] args) {
        int [] arr;
        int n;
        Scanner input = new Scanner(System.in);
        System.out.printf("Nhập n: ");
        n = input.nextInt();
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Nhập phần tử mảng "+i+" ");
            arr[i] = input.nextInt();
        }
        System.out.printf("\tMảng vừa nhập là:");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + "\t");
        }
        System.out.println("");
        int min=arr[0];
        int max=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<min){
                min=arr[i];
            }if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println("\tGiá trị nhỏ nhất là:"+min);
        System.out.println("\tGiá trị lớn nhất là:"+max);
    }
}
