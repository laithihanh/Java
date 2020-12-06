/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1_Lab9.test;

import Bai1_Lab9.Vehicles;
import Bai1_Lab9.car.Car;
import Bai1_Lab9.truck.Truck;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Test {
    List<Vehicles> lstXe = new ArrayList<>();
    
    public Test(){
        
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\t==========Chon menu=========");
            System.out.println("\t1. Input");
            System.out.println("\t2.Display");
            System.out.println("\t3. Sort descending<giảm dần> and ascending<tăng dần> by price");
            System.out.println("\t4. Search by model.");
            System.out.println("\t5. Exit");
            System.out.print("Chọn chức năng 1->5: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display();
                    break;
                case 3:
                   sortDescending();
                   sortAscending();
                    break;
                case 4:
                    search(sc);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
    public void input(Scanner sc) {
        System.out.printf("Nhập car chọn(C); Nhập Truck chọn (T)");
        String str =  sc.nextLine();
         char c = ' ';
        if(str.length() >= 0){
             c = str.charAt(0);
        }
       
        System.out.printf("Số lượng xe cần nhập: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (c == 'C' || c == 'c') {
                Car xe = new Car();
                xe.input();
                lstXe.add(xe);
            } else {
                Truck xe = new Truck();
                System.out.println("");
                xe.input();
                lstXe.add(xe);
            }
        }
    }
    public void display() {
        for (int i = 0; i < lstXe.size(); i++) {
            if (lstXe.get(i) instanceof Car) {
                ((Car) lstXe.get(i)).display();
            } else {
                 System.out.println("");
                ((Truck) lstXe.get(i)).display();
            }
        }
    }
    public void sortDescending(){
        Collections.sort(lstXe, new Comparator<Vehicles>(){
            @Override
            public int compare(Vehicles o1,Vehicles o2){
                if(o1.price < o2.price ){
                    return 1;
                }else{
                    if(o1.price == o2.price){
                        return 0;
                    }else{
                        return -1;
                    }
                }
            }    
        });  
        System.out.println("Danh sách sắp xếp giảm dần là: ");
        for(int i=0;i<lstXe.size();i++){
            lstXe.get(i).display();
            
        }
    }
    public void sortAscending(){
        Collections.sort(lstXe, new Comparator<Vehicles>(){
            @Override
            public int compare(Vehicles o1,Vehicles o2){
                if(o1.price > o2.price ){
                    return 1;
                }else{
                    if(o1.price == o2.price){
                        return 0;
                    }else{
                        return -1;
                    }
                }
            }    
        });  
        System.out.println("Danh sách sắp xếp tăng dần là: ");
        for(int i=0;i<lstXe.size();i++){
            lstXe.get(i).display();
            
        }
    }
    
    public void search(Scanner sc){
        Vehicles searchSer;
        Vehicles setSer = new Vehicles();
        int i;
         System.out.print("Nhập mẫu xe cần tìm: ");
         String search = sc.nextLine();
         setSer.setModel(search);
        System.out.println("Danh sách mẫu xe tìm thấy: ");
        for(i=0; i<lstXe.size();i++){
            searchSer = (Vehicles) lstXe.get(i);
            if(searchSer.getModel().contains(search)){
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
