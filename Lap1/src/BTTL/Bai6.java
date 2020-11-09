/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.Random;

/**
 *
 * @author USER
 */
public class Bai6 {
    public static void main(String[] args) {
        Random rd = new Random(); 
        int number = rd.nextInt(90); 
        System.out.println("Số ngẫu nhiên là: " +number);
        
        double A = 2*sin(number) + cos(number) / 2;
        System.out.println("A = " +A);
       
        
        
    }
    
}
