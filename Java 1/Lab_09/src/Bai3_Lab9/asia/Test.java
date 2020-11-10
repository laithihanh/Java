/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai3_Lab9.asia;

import Bai3_Lab9.Country;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.ToDoubleFunction;

/**
 *
 * @author USER
 */
public class Test {
    List<Country> lstQuocGia = new ArrayList<>();
    public Test(){
        
    }
   
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\t==========Chon menu=========");
            System.out.println("\t1. Input");
            System.out.println("\t2.Display");
            System.out.println("\t3. Sort descending<giảm dần> by area and display result ");
            System.out.println("\t4. Sort ascending<tăng dần> by area and display result ");
            System.out.println("\t5. Find information by countryName ");
            System.out.println("\t6. Exit");
            System.out.print("Chọn chức năng 1->6: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display(lstQuocGia);
                    break;
                case 3:
                   sortDescending();
                    break;
                case 4:
                   sortAscending();
                    break;
                case 5:
                    search(sc);
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
    public void input(Scanner sc) {
        System.out.printf("Số quốc gia cần nhập: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
                AsiaCountry quocgia = new AsiaCountry();
                quocgia.input();
                lstQuocGia.add(quocgia);
        }
    }
    public void display(List<Country> lst) {
        for(Country f : lst){
            f.display();
        }
    }
    public void sortDescending(){
        Collections.sort(lstQuocGia, new Comparator<Country>(){
            @Override
            public int compare(Country o1,Country o2){
                if(o1.area < o2.area ){
                    return 1;
                }else{
                    if(o1.area == o2.area){
                        return 0;
                    }else{
                        return -1;
                    }
                }
            }    
        });  
        System.out.println("Danh sách sắp xếp giảm dần là: ");
        for(int i=0;i<lstQuocGia.size();i++){
            lstQuocGia.get(i).display();
            
        }
    }
    
     public void sortAscending(){
        Collections.sort(lstQuocGia, new Comparator<Country>(){
            @Override
            public int compare(Country o1,Country o2){
                if(o1.area > o2.area ){
                    return 1;
                }else{
                    if(o1.area == o2.area){
                        return 0;
                    }else{
                        return -1;
                    }
                }
            }    
        });  
        System.out.println("Danh sách sắp xếp tăng dần là: ");
        for(int i=0;i<lstQuocGia.size();i++){
            lstQuocGia.get(i).display();
            
        }
    }
    
    public void search(Scanner sc){
        Country searchSer;
        Country setSer = new Country();
        int i;
         System.out.print("Nhập tên quốc gia: ");
         String search = sc.nextLine();
         setSer.setCountryName(search);
         System.out.println(" Danh sách tìm thấy: ");
        for(i=0; i<lstQuocGia.size();i++){
             searchSer = (Country) lstQuocGia.get(i);
            if(searchSer.getCountryName().contains(search)){
                searchSer.display();
            }
        }
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Test app = new Test();
        app.run();
    }
}
