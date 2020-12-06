/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH;

/**
 *
 * @author ADMIN
 */
public class BTH2 {
    boolean flag = false;

    public synchronized void Question(String msg) {
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(msg);
        flag = true;
        notify();
    }

    public synchronized void Answer(String msg) {
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(msg);
        flag = false;
        notify();
    }
    public static void main(String[] args) {
        BTH2 m = new BTH2();
        new Anna(m);
        new Michael(m);
    }
}
class Anna implements Runnable {

    BTH2 m;
    String[] s1 = {"Hi", "How are you ?", "I am also doing fine!"};

    public Anna(BTH2 m1) {
        this.m = m1;
        new Thread(this, "Question").start();
    }

    public void run() {
        for (int i = 0; i <s1.length; i++) {
        m.Question(s1[i]);
        }
    }
}
class Michael implements Runnable {

    BTH2 m;
    String[] s2 = {"Hi", "I am good, what about you?", "Great!"};

    public Michael(BTH2 m2) {
        this.m = m2;
        new Thread(this, "Answer").start();
    }

    public void run() {
        for (int i = 0; i <s2.length; i++) {
            m.Answer(s2[i]);
        }
    }
}

