/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_2;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai12 {
    public static void main(String[] args) {
    String pheptinh;
    float x,y;
    Scanner input = new Scanner(System.in);
    System.out.printf("Nhập vào x : ");
    x = input.nextFloat();
    System.out.printf("Nhập vào y : ");
    y = input.nextFloat();
    
    input.nextLine();
    System.out.printf("Nhập vào một phép tính(+,-,*,/):");
    pheptinh = input.nextLine();
    
    switch(pheptinh){
        case "+":
            System.out.printf("Tổng là:%f\n",x+y);
            break;
        case "-":
            System.out.printf("Hiệu là:%f\n",x-y);
            break;
        case "*":
            System.out.printf("Tích là:%f\n",x*y);
            break;
        case "/":
            if(y==0){
                System.out.printf("Không chia được");
            }else{
                System.out.printf("Thương là:%f\n",x/y);
            }
            break;         
    }
    }
}
