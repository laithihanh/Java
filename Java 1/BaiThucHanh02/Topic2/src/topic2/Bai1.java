/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic2;

import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai1 {
    public static void main(String[] args) {
        int a,b,chon,n,i;
        Scanner input = new Scanner(System.in);
    while(true){
    System.out.println("\t==========**MENU**==========");
    System.out.println("\t1. Tìm UCLN và BCNN của hai số a và b cho trước");
    System.out.println("\t2. In ra chuỗi Fibonacci của một số n cho trước và liệt kê tất cả các số nguyên tố nhỏ hơn số n");
    System.out.println("\t3. Có một số, cho biết đó có phải là số Thuận/Nghịch không.");
    System.out.println("\t4.Thoát");
    
    
    System.out.printf("Mời bạn chọn:");
    chon = input.nextInt();

        switch(chon){
            case 1:
                System.out.printf("Nhập số a: ");
                a = input.nextInt();
                System.out.printf("Nhập số b: ");
                b = input.nextInt();

                System.out.println("UCLN của "+a+" và "+b+" là:" +UCLN(a,b));
                System.out.println("BCNN "+a+" và "+b+" là:" +((a*b)/UCLN(a,b)));
                break;
            case 2:
                System.out.printf("nhap n: ");
                n = input.nextInt();
                System.out.printf("So Fibonacci thu %d la: %d\n", n, Fibonacci(n));
                System.out.printf("Các số nguyên tố nhỏ hơn %d là:",n);
                
                if (n >= 2) {
                    System.out.printf("%d ",2);
                }
                for (i = 3; i < n; i+=2) {
                    if (KtraSoNguyenTo(i) == 1) {
                        System.out.printf(" %d ",i);
                    }
                }
                 System.out.println("");
                break;
            case 3:
                System.out.print("Nhập số n = ");
                n = input.nextInt();
                
                System.out.println(n + "  " + soThuanNghich(n));
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Bạn chọn sai mời chọn lại!!!!");
                 break;
        }
    }
    }
    public static int UCLN(int a, int b){
        while(a!= b){
            if(a>b){
               a= a-b;
            } 
            else{
                b= b-a;
            } 
        }
        return (a);
    }
    public static int Fibonacci(int n)
    {
        if (n == 1 || n == 2)
            return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
    public static int KtraSoNguyenTo(int n) {
        // so nguyen n < 2 khong phai la so nguyen to
        if (n < 2) {
            System.out.println(n+"Không phải là số nguyên tố");
        }
    // check so nguyen to khi n >= 2
        int i;
        int CanBac2 = (int) sqrt(n);
            for (i = 2; i <= CanBac2; i++) {
                if (n % i == 0) {
                   return 0;
                }
            }
            return 1;
    }
    public static String soThuanNghich(int n) {
        // chuyển đổi số n thành một chuỗi String
        String numberStr = String.valueOf(n);
        // kiểm tra tính thuận nghịch
        int size = numberStr.length();
        for (int i = 0; i < (size/2); i++) {
            if (numberStr.charAt(i) != numberStr.charAt(size - i - 1)) {
                return "không là số thuận nghịch";
            }
        }
        return "là số thuận nghich";
    }
}
