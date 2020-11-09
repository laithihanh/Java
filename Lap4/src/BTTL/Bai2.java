/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai2 extends Thread{

    @Override
    public void run() {
        String [] arr;
        int n;
        Scanner input = new Scanner(System.in);
        System.out.printf("Nhập n tỉnh: ");
        n = input.nextInt();
        input.nextLine();
        arr = new String[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("\tNhập tỉnh %d :",i+1);
            arr[i] = input.nextLine();
        }
        System.out.printf("Tỉnh vừa nhập là:");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + "\t");
        }
        System.out.println("");
       
        for(int i=0;i < arr.length;i++){
            String[] array;
            Random ran = new Random();
            int a = ran.nextInt(arr.length);
            System.out.println("\tTỉnh ngẫu nhiên:"+ arr[a]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
        }
    }
   
    public static void main(String[] args) {
        Bai2 app = new Bai2();
        Thread thread = new Thread(app);
            thread.start();
    }
}
