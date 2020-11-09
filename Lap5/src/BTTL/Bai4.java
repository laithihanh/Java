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
public class Bai4 {
    static public int a;
    
    static class Thread1 extends Thread {
        @Override
        public void run() {
            for(int i=0;i<50;i++){
              Random sc = new Random();
                a = sc.nextInt(50);
                    System.out.println("Số ngẫu nhiên:"+ a);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(a%2 == 0){
                    System.out.println("Là số chẵn");
                }else{
                    System.out.println("Là số lẻ");
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
