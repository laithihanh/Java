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
public class Bai11 {
    public static void main(String[] args) {
    String color;
    Scanner input = new Scanner(System.in);
    System.out.printf("Nhập mã màu : ");
    color = input.nextLine();
    
        if(color.equals("R") || color.equals("r")){
            System.out.printf("Red ");
        }else if(color.equals("G") || color.equals("g")){
            System.out.printf("Green ");
        }else if(color.equals("B") || color.equals("b")){
            System.out.printf("Blue");
        }else{
            System.out.printf("Black");
        }
    }
}
