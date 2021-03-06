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
public class Bai10 {
    
	private static void nhap_mang(int []A, int n) {
            Scanner scn =  new Scanner(System.in);
            for(int i=0; i<n; i++) {
                System.out.print("Nhập số phần tử mảng "+i+" : ");
                A[i] = scn.nextInt();
            }
	}
	
	private static void xuat_mang(int []A, int n) {
            for(int i=0; i<n; i++) {
                System.out.println("\tPhần tử mảng thứ "+i+" là: "+A[i]);
            }
	}
	
	private static void sap_xep_chen(int []A, int n) {
            for(int i=1; i<n; i++) {
                int x = A[i];
                int y = i;
                while( y > 0 && A[ y - 1 ] > x ) {
                    A[y]=A[y-1];
                    y--;
                }
                A[y]=x;
            }
	}

	public static void main(String[] args) {
            int []A;
            int n=0;
            Scanner scn = new Scanner(System.in);
            System.out.print("Nhập n số phần tử: ");
            n = scn.nextInt();
            A = new int[n];
            nhap_mang(A, n);
            System.out.println("\tMảng sau khi sắp xếp (Insertion Sort)");
            sap_xep_chen(A, n);
            xuat_mang(A, n);
	}
}
