/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic2;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai3 {
    public static void main(String[] args) {
       int num, n;
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập n: ");
		num = sc.nextInt();
		System.out.println();
		n = num;
		// vẽ phần tam giác ngược
		for (int i = 1; i <= num; i++) {
			// phần 1
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
//			 phần 2
			for (int k = 1; k <= n; k++) {
				System.out.print("*");
			}
//			 phần 3
			for (int k = num - i; k>= 1; k--) {
				System.out.print("*");
			}
			n--;
			System.out.println();
		}
		
		// vẽ tam giác khuyết đỉnh
		for (int i = 2; i <= num; i++) {
			// phần 1
			for (int j = num - i + 1; j >= 1; j--) {
				System.out.print(" ");
			}
			// phần 2
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			// phần 3
			for (int k = i - 1; k>= 1; k--) {
				System.out.print("*");
			}
			System.out.println();
		}

    }
}
