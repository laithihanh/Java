/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import static BTTL.Bai6.a;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author USER
 */
public class Bai3 {
    static public String a;
    static public String[] listName;
    static class Thread1 extends Thread {
        String[] listName = {"nGuYeN hOa bInH","lE tHaNh hAi","tRan mAnH tIeN","lE qUAnG qUaN"};
        @Override
        public void run() {
            for (int i = 0; i <5; i++) {
                Random sc = new Random();
                synchronized (this) {
                    int b = sc.nextInt(listName.length);
                    a = listName[b];
                    System.out.println("Tên:"+ a);
                }
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
     static class Thread2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i <5; i++){
                StringTokenizer s1= new StringTokenizer(a);
            StringBuffer kq= new StringBuffer();
                while(s1.hasMoreTokens()){
                    String s2= s1.nextToken();
                    s2=s2.toLowerCase();
                    String s3= s2.substring(0, 1);
                    s2=s2.replaceFirst(s3, s3.toUpperCase());
                    kq.append(s2).append(" ");

                }
            System.out.println("Chuẩn hóa: "+kq);
            
            try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
