/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_6;

import java.util.Random;

/**
 *
 * @author USER
 */
public class Bai2 {
    public static void main(String[] args) {
        Random rd = new Random();
        int number = rd.nextInt(9);  
        
        System.out.println("Số vừa được sinh ra là " + number);
    }
}
