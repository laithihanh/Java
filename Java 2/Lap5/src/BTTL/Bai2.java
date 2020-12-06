/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.time.LocalTime;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Bai2{
    static public int i;

    static class Thread1 extends Thread {
        @Override
        public void run() {
          
                Random rd = new Random();
                synchronized (this) {
                    i = rd.nextInt(50);
                    System.out.println("Số ngẫu nhiên: " + i);
                }
        }
    }
    
    static class Thread2 extends Thread {

        @Override
        public void run() {
            if(i % 2==0){
            System.out.println("Là số chẵn");
            }else{
                System.out.println("Là số lẻ");
            }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new Thread1().start();
        new Thread2().start();
    }
}