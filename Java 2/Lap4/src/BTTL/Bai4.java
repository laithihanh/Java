/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author USER
 */
public class Bai4 extends Thread{
    String[] arrSinhVien = new String[]{"Hoàng", "Tuấn", "Quỳnh", "Trang", "Vũ"};
    
    String name;

    public Bai4(String name) {
    this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i < arrSinhVien.length; i++) {
            Random sc = new Random();
            int tenngaunhien = sc.nextInt(arrSinhVien.length);
            System.out.println(name+ "Tên:"+ arrSinhVien[tenngaunhien]);
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Bai4_1 extends Thread{
   
    String[] arrHanhDong = new String[]{"...đang ăn", "...đang ngủ", "...đang xem phim","...đang làm bài tập", "...đang học"};
    String name;
    public Bai4_1(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        
        for (int i = 0; i < arrHanhDong.length; i++) {
            Random sc = new Random();
            int HanhDong = sc.nextInt(arrHanhDong.length);
            System.out.println(name+ "Hành động:"+ arrHanhDong[HanhDong]);
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
     public static void main(String[] args) {
        Bai4 T1 = new Bai4("Thread A:");
        T1.start();

        Bai4_1 T2 = new Bai4_1("Thread B:");
        T2.start();
       
    }
}
