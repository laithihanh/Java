/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2_Lab9.yamaha;

import Bai2_Lab9.Motor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Yamaha {
    List<Motor> lstXe = new ArrayList<>();
    
    public Yamaha(){
        
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\t==========Chon menu=========");
            System.out.println("\t1. Input");
            System.out.println("\t2.Display");
            System.out.println("\t3. Sort ");
            System.out.println("\t4. Search ");
            System.out.println("\t5. Exit");
            System.out.print("Chọn chức năng 1->5: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display(lstXe);
                    break;
                case 3:
                   sortBy();
                   sortByGiam();
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
        System.out.printf("Nhập serius chọn(S); Nhập Jupiter chọn (J):");
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
                Jupiter xe = new Jupiter();
                xe.inputInfor();
                lstXe.add(xe);
            } else {
                Serius xe = new Serius();
                System.out.println("");
                xe.inputInfor();
                lstXe.add(xe);
            }
        }
    }
    public void display(List<Motor> lstXe1) {
        for (int i = 0; i < lstXe.size(); i++) {
            if (lstXe.get(i) instanceof Jupiter) {
                ((Jupiter) lstXe.get(i)).displayInfor();
            } else {
                 System.out.println("");
                ((Serius) lstXe.get(i)).displayInfor();
            }
        }
    }

    
     private void sortBy() {
        
        Collections.sort(lstXe, new Comparator<Motor>() {
            @Override
            public int compare(Motor o1, Motor o2) {
                if((o1 instanceof Jupiter) && (o2 instanceof Jupiter)){
                    return ((Jupiter)o1).getWarranty() - ((Jupiter)o2).getWarranty();
                }else if((o1 instanceof Serius) && (o2 instanceof Serius)){
                      return ((Serius)o1).getWarranty() - ((Serius)o2).getWarranty() ;
                }else{
                    return 0;
                }
            }
        });
        System.out.println("Danh sách sắp xếp tăng dần là: ");
        display(lstXe);
    }
    
     private void sortByGiam() {
        
        Collections.sort(lstXe, new Comparator<Motor>() {
            @Override
            public int compare(Motor o1, Motor o2) {
                if((o1 instanceof Jupiter) && (o2 instanceof Jupiter)){
                    return ((Jupiter)o2).getWarranty() - ((Jupiter)o1).getWarranty();
                }else if((o1 instanceof Serius) && (o2 instanceof Serius)){
                      return ((Serius)o2).getWarranty() - ((Serius)o1).getWarranty() ;
                }else{
                    return 0;
                }
            }
        });
        System.out.println("Danh sách sắp xếp giảm dần là: ");
        display(lstXe);
    }
    
    public void search(Scanner sc){
        Serius searchSer;
        Serius setSer = new Serius();
        int i;
         System.out.print("Nhập loại xe cần tìm: ");
         String enterSer = sc.nextLine();
         setSer.setCode(enterSer);
         System.out.println(" Danh sách tìm thấy: ");
        for(i=0; i<lstXe.size();i++){
            searchSer = (Serius) lstXe.get(i);
            if(searchSer.getName().contains(enterSer)){
                searchSer.displayInfor();
            }
        }
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Yamaha app = new Yamaha();
        app.run();
    }

    
}
