/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bai1 {
    List<Integer> SoNguyen = new ArrayList<>();
    
    public void input(){
        Scanner nhap = new Scanner(System.in);
        System.out.printf("Nhập số lượng phần tử:");
        int n = nhap.nextInt();
        for(int i = 0 ; i< n; i++){
            System.out.printf("[%d]:" ,i + 1);
            int m = nhap.nextInt();
            SoNguyen.add(m);
        }  
    }
    public void display(){
        System.out.printf("Danh sách số nguyên vừa nhập là:");
            System.out.println(SoNguyen);
    }
    
    public void sort(){
        System.out.printf("Danh sách số nguyên tăng dần là:");
        SoNguyen.sort((o1,o2)->o1-o2);
        System.out.println(SoNguyen);
    }
    public static void main(String[] args) {
        Bai1 bai1 = new Bai1();
        bai1.input();
        bai1.display();
        bai1.sort();
    }
}

