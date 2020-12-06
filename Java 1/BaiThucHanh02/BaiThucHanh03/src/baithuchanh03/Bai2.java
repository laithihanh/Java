/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baithuchanh03;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai2 {
    public static void main(String[] args) {
        int n;
    Scanner input = new Scanner(System.in);
    System.out.printf("Nhập vào số phần tử mảng:");
    n = Integer.parseInt(input.nextLine());
    int[] arr = new int[n];
    
        do{
            System.out.println("\t**********MENU**********");
            System.out.println("\t1.Nhập giá trị phần tử mảng");
            System.out.println("\t2.In ra các giá trị phần tử mảng");
            System.out.println("\t3.In ra phần tử có giá trị lớn nhất, nhỏ nhất");
            System.out.println("\t4.In ra phần tử có giá trị là số nguyên tố");
            System.out.println("\t5.In ra phần tử có giá trị là số hoàn hảo");
            System.out.println("\t6.Sắp xếp mảng giảm dần");
            System.out.println("\t7.Thoát");
            System.out.print("Sự lựa chọn của bạn: ");
            
            int choice = Integer.parseInt(input.nextLine());
            switch(choice){
                case 1:
                    System.out.println("Nhập giá trị phần tử mảng:");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.printf("Phần tử mảng thứ "+i+":",i);
                        arr[i] = Integer.parseInt(input.nextLine());
                    }
                    break;
                case 2:
                    System.out.printf("\tMảng vừa nhập là:");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.printf(arr[i] + "\t");
                    }
                    System.out.println("");
                    break;
                case 3:
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
                break;
                case 4:
                    for (int i=0;i<arr.length;i++) {
                    if (check(arr[i])  )
                        System.out.print("Số nguyên tố là: "+arr[i]);
                    }
                    System.out.println("");
                break;
                case 5:
                    Bai2 shh = new Bai2();
                    for (int i = 0; i < n; i++) {
                        if (shh.checkSHH(arr[i]) == true) {
                            System.out.print("Số hoàn hảo là: ");
                            System.out.print(arr[i] + " ");
                        }
                    }

                    System.out.println("");
                    break;
                case 6:
                    sortDESC(arr);
                    System.out.printf("Dãy số được sắp xếp giảm dần: ");
                    show(arr);
                    System.out.println("");
                break;
                case 7:
                   System.exit(0);
                default:
                    System.out.println("Vui lòng nhập từ 1 đến 7");
            }
            
        }while(true);
    }
    public static boolean check(int n){
        if(n<=1) return false;
        for (int i = 2;i<= Math.sqrt(n); i++)
            if(n%i==0) return false;
        //Nếu không chia hết thì trả về true
        return true;
    }
    public static void sortDESC(int [] arr) {
        int temp = arr[0];
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
    public static void show(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public boolean checkSHH(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        if (sum == n) {
            return true;
        }
        return false;
    }
}
