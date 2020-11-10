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
public class Bai5 {
    public static void main(String[] args) {
        int [] arr;
        int n;
        Scanner input = new Scanner(System.in);
        System.out.printf("Nhập n: ");
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
        System.out.print("\tCác số nguyên tố là: ");
        for (int i=0;i<arr.length;i++) {
            if (check(arr[i])  )
                System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
    public static boolean check(int n){
        if(n<=1) return false;
        for (int i = 2;i<= Math.sqrt(n); i++)
            if(n%i==0) return false;
        //Nếu không chia hết thì trả về true
        return true;
    }
}
