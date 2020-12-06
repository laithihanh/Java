/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import static BTTL.Bai2.i;
import java.util.Random;

/**
 *
 * @author USER
 */
public class Bai5 {
    static public int i;

    static class Thread1 extends Thread {

        @Override
        public void run() {
            while (true) {
                Random gen = new Random();
                synchronized (this) {
                    i = gen.nextInt(100);
                    System.out.println("Số nhẫu nhiên: " + i);
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

    static class Thread2 extends Thread {

        @Override
        public void run() {
            while (true) {
                if(i % 2==0){
                System.out.println(i+ " là số chẵn");
                }else{
                    System.out.println(i+ " là số lẻ");
                }
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new Thread1().start();
        new Thread2().start();
    }
}
