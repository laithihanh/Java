/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import static BTTL.Bai5.i;
import java.util.Random;

/**
 *
 * @author USER
 */
public class Bai6 {
    static public int a;

    static class Thread1 extends Thread {

        @Override
        public void run() {
            while (true) {
                Random gen = new Random();
                synchronized (this) {
                    a = gen.nextInt(100);
                    System.out.println("Số nhẫu nhiên: " + a);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }
    static class Thread2 extends Thread {
        @Override
        public void run() {
            int answer=0;
            while (true) {
                int i=1;
                i++;
                if(a %i ==0){
                    answer++;
                }
                System.out.println("Ước của "+a+" là:"+answer);
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
