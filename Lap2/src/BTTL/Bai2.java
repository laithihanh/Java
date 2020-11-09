/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author USER
 */
public class Bai2 {
    Set<String> words = new HashSet<String>();
    
    public void input(){
        Scanner nhap = new Scanner(System.in);
        System.out.printf("Nhập số lượng thành phố:");
        int n = nhap.nextInt();
         nhap.nextLine();
        for(int i = 0 ; i< n; i++){
            System.out.printf("[%d]:" ,i + 1);
            String m = nhap.nextLine();
            words.add(m);
        }  
    }
    public void display(){
        System.out.printf("Danh sách thành phố vừa nhập là:");
        System.out.println(words);
    }
    public void sortASC(){
        System.out.printf("Danh sách thành phố tăng dần là:");
        TreeSet myTreeSet = new TreeSet<>(words);
        System.out.println(words);
    }
    public static void main(String[] args) {
        Bai2 bai2 = new Bai2();
        bai2.input();
        bai2.display();
        bai2.sortASC();
    }
    
}
