/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_3;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai12 {
    public static void main(String[] args) {
    int n;
    Scanner input = new Scanner(System.in);
        System.out.printf("Nhập vào số n: ");
        n = input.nextInt();
        for (int i = 1; i < n; i++) {
            System.out.printf(fibonacci(i) + " ");
        }
    }

    public static int fibonacci(int m) {
        if (m < 0) {
            return -1;
        } else if (m == 0 || m == 1) {
            return m;
        } else {
            return fibonacci(m - 1) + fibonacci(m - 2);
        }
    }
    
}
