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
    //Cách tự làm
    /*@Override
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
*/
    //Cách 2
    public static void main(String[] args) {
        String[] cityNames = {
            "Ha Noi",
            "Ha nam",
            "Da Nang",
            "Hai Phong"
        };
        ThreadA t1 = new ThreadA(cityNames.length);
        ThreadB t2 = new ThreadB(t1, cityNames);
        t1.start();
        t2.start();
    }
}
class ThreadA extends Thread{
    private int num;
    
    public ThreadA(int num){
        this.num= num;
    }
    public int getRandom(){
        return (int)(Math.random()*num);
    }

    @Override
    public void run() {
        super.run(); 
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.getRandom();
        }
    }
}

class ThreadB extends Thread{
    ThreadA t;
    String[] cityNames;
    public ThreadB(ThreadA t, String[] cityNames){
        this.t= t;
        this.cityNames=cityNames;
    }

    @Override
    public void run() {
        super.run(); 
        while(true){
            System.out.println(cityNames[t.getRandom()]);
        }
    }
    
}