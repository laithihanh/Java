/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author ADMIN
 */
public class mainBai5 {
    Map<Integer, Bai5> product = new HashMap<Integer, Bai5>();
    
    
    public void nhap(){
        Scanner nhap = new Scanner(System.in);
        System.out.printf("Nhập số lượng sản phẩm:");
        int n = nhap.nextInt();
        nhap.nextLine();
        for(int i = 0 ; i< n; i++){
           System.out.println("Sản phẩm " + (i + 1));
            Bai5 bai5= new Bai5();
            bai5.input();
            product.put(i, bai5);
            
        }  
    }
    public void display(){
        System.out.println("Danh sách sản phẩm vừa nhập là:");
        System.out.println("isbn \t bookName \t author \t publisher \t price ");
        for (Map.Entry<Integer, Bai5> entrySet : product.entrySet()) {
            Integer key = entrySet.getKey();
            Bai5 value = entrySet.getValue();
            System.out.println(key + " - " + value);
        }
        
    }
   
   public void sortASC(){
        List<Bai5> peopleByAge = new ArrayList<Bai5>(product.values());
       Collections.sort(peopleByAge, (Bai5 o1, Bai5 o2) -> o1. getYearMaking() - o2. getYearMaking());
       System.out.println("Danh sách thành phố tăng dần là:");
       System.out.println("isbn \t bookName \t author \t publisher \t price ");
//      
        for (Bai5 p : peopleByAge) {
            p.toString();
       }
       
   }
    public static void main(String[] args) {
        mainBai5 b5 = new mainBai5();
        b5.nhap();
        b5.display();
        b5.sortASC();
    }
}
