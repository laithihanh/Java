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
public class Bai14 {
    public static void main(String[] args) {
    float luong,gio;
    Scanner input = new Scanner(System.in);
    System.out.printf("Nhập vào số giờ: ");
    gio = input.nextFloat();
    System.out.printf("Nhập vào số lương của một giờ: ");
    luong = input.nextFloat();
    
        if(gio>40){
            System.out.printf("Tổng số tiền lương la:%.3f\n",luong*40 +(gio-40)*luong*1.5);
        }else{
            System.out.printf("Tổng số tiền lương la:%.3f\n",luong*gio);
        }
    }
}
