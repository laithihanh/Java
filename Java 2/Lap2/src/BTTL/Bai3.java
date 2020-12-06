/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
import sun.reflect.generics.tree.Tree;

/**
 *
 * @author USER
 */
public class Bai3 {
    public static void main(String[] args) {
        Map<Integer, String> quocgia = new HashMap<Integer, String>();
        TreeSet sortASC = new TreeSet<Integer>();
        Scanner nhap = new Scanner(System.in);
        System.out.printf("Nhập số lượng quốc gia:");
        int n = nhap.nextInt();
        nhap.nextLine();
        for(int i = 0 ; i< n; i++){
            System.out.printf("[%d]:" ,i + 1);
            String m = nhap.nextLine();
            quocgia.put(i, m);
            sortASC.add(m);
        }
        System.out.printf("Danh sách thành phố vừa nhập là:");
        System.out.println(quocgia);
        
        System.out.println("");
        
        System.out.printf("Danh sách thành phố tăng dần là:");
        System.out.println(sortASC);
    }  
       
    
}
