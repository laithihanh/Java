/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class Bai1 extends Thread{
    
    @Override
    public void run(){
        
      for(int i=1;i<100;i++){
        Random sc = new Random();
        int songaunhien = sc.nextInt(100);
          System.out.println("Số ngẫu nhiên:"+ songaunhien);
          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
    }
    
    
    public static void main(String[] args) {
        Bai1 demo  = new Bai1();
        Thread thread = new Thread(demo);
            thread.start();
    }

   
}
