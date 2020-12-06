/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class BTH3 extends Thread{
    int startNumber, endNumber;
    int total = 0;

    public BTH3(String name, int startNum, int endNum) {
        super(name);
        this.startNumber = startNum;
        this.endNumber = endNum;
    }

    @Override
    public void run() {
        for (int i = startNumber; i <= endNumber; i++) {
        total += i;
        System.out.println(getName() + " is alive: " + isAlive());
            try {
            Thread.sleep(110);
            } catch (InterruptedException ex) {
            Logger.getLogger(BTH3.class.getName()).log(Level.SEVERE, null,
            ex);
            }
        }
    }
}
class TestJoin {
//Bước 3: Viết phương thức start()
    public void start() {
        try {
            SumTotal sum1 = new SumTotal("Thread 1", 0, 3);
            SumTotal sum2 = new SumTotal("Thread 2", 4, 16);
            sum1.start();
            sum2.start();
            sum1.join();
            System.out.println(sum1.getName() + " join");
            sum2.join();
            System.out.println(sum2.getName() + " join");
            System.out.println(sum1.getName() + " is alive: " + sum1.isAlive());
            System.out.println(sum2.getName() + " is alive: " + sum2.isAlive());
            int total = sum1.total + sum2.total;
            System.out.println("Kết quả tổng = " + total);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestJoin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public class SumTotal extends Thread {
        int startNumber, endNumber;
        int total = 0;
        public SumTotal(String name, int startNum, int endNum) {
            super(name);
            this.startNumber = startNum;
            this.endNumber = endNum;
        }
        @Override
        public void run() {
            for (int i = startNumber; i <= endNumber; i++) {
                total += i;
                System.out.println(getName() + " is alive: " + isAlive());
                try {
                Thread.sleep(110);
                } catch (InterruptedException ex) {
                Logger.getLogger(TestJoin.class.getName()).log(Level.SEVERE, null,
                ex);
                }
            }
        }
    }
    //Bước 4: Viết hàm main()
    public static void main(String[] args) {
    TestJoin test = new TestJoin();
    test.start();
    }
    
}