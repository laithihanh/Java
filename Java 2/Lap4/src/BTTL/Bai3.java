/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Bai3 extends Thread{
    String name;

    public Bai3(String name) {
    this.name = name;
    }
    @Override
    public void run() {
        Random sc = new Random();
        int songaunhien = sc.nextInt(100);
      
          try {
            for(int i=0;i<1;i++){
                System.out.println(name+ "Số ngẫu nhiên "+songaunhien);
                 Thread.sleep(1000);
               }
          } catch (InterruptedException e) {
             Logger.getLogger(Bai3.class.getName()).log(Level.SEVERE, null, e);
          }
    }
    
}
class Bai3_1 extends Thread{
    String name;

    public Bai3_1(String name) {
    this.name = name;
    }
    
    @Override
    public void run() {
        Random sc = new Random();
        int songaunhien = sc.nextInt(100);
      
          try {
            for(int i=0;i<1;i++){
                LocalTime hour = java.time.LocalTime.now();
                System.out.println(name+ "Giờ hệ thống "+hour.getHour()+":"+hour.getMinute()+":"+hour.getSecond());
                System.out.println("Bây giờ là "+hour.getHour());
                 Thread.sleep(1000);
               }
          } catch (InterruptedException e) {
             Logger.getLogger(Bai3.class.getName()).log(Level.SEVERE, null, e);
          }
    }
    public static void main(String[] args) {
        Bai3 T1 = new Bai3("Thread-1:");
        T1.start();

        Bai3_1 T2 = new Bai3_1("Thread-2:");
        T2.start();
    }
}
