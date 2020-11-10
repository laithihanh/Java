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
public class Bai9 {
        private static void nhap_mang(int []A, int n) {
            Scanner scn = new Scanner(System.in);
            for(int i = 0; i < n; i++) {
                System.out.print("Nhập số phần tử mảng "+i+" : ");
                A[i] = scn.nextInt();
            }
	}
	private static void xuat_mang(int []A, int n) {
            Scanner scn = new Scanner(System.in);
            for(int i = 0; i < n; i++) {
                System.out.println("\tPhần tử mảng thứ "+i+" là: "+A[i]);
            }
	}
	
	private static void hoan_vi(int []A, int a, int b) {
            int temp = A[a];
            A[a] = A[b];
            A[b] = temp;
	}
	
	private static void sap_xep_noi_bot(int []A, int n) {
            for(int i=0; i<n-1; i++) {
                for(int j=n-1; j>i; j--) {
                    if(A[j]<A[j-1]) {
                            hoan_vi(A, j, j-1);
                    }
                }
            }
	}

	public static void main(String[] args) {
            int []A;
            int n = 0;
            Scanner scn = new Scanner(System.in);
            System.out.print("Nhập n số phần tử: ");
            n = scn.nextInt();
            A = new int[n];
            nhap_mang(A, n);
            System.out.println("\tMảng sau khi sắp xếp (Bubble Sort)");
            sap_xep_noi_bot(A, n);
            xuat_mang(A, n);
	}
}
