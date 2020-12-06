/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session8;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bai2 {
    public static void main(String[] args) {
        String [] arr;
        int n;
        Scanner input = new Scanner(System.in);
        System.out.printf("Nhập n sinh viên: ");
        n = Integer.parseInt(input.nextLine());
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập sinh viên thứ "+i+":");
            arr[i] = input.nextLine();
        }
        System.out.printf("\tDanh sách sinh viên vừa nhập:");
        for (int i = 0; i < n; i++) {
            System.out.printf(arr[i] + "\t");
        }
        System.out.println("");
    }
}
