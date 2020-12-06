/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class mainBai4 {
    List<Bai4> lstSach = new ArrayList<>();
    
    public mainBai4(){
        
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\t==========Chon menu=========");
            System.out.println("\t1. Nhập thông tin cho n cuốn sách");
            System.out.println("\t2. Hiển thị thông tin vừa nhập"); 
            System.out.println("\t3. Hiển thị thông tin sắp xếp giảm dần theo giá"); 
            System.out.println("\t4.Thoát ");
            System.out.print("Chọn chức năng 1->4: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display(lstSach);
                    break;
                case 3:
                    sortDESC();
                    break;
                    
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
    public void input(Scanner sc){
        System.out.print("Nhập thông tin n quyển sách:");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
            System.out.println("Nhập quyển " + (i + 1));
            Bai4 Sach = new Bai4();
            Sach.nhap();
            System.out.println("");
            lstSach.add(Sach);   
        }  
    }
   public void display( List<Bai4> lst ){
       System.out.println("Danh sách vừa nhập là:");
        System.out.println("isbn \t bookName \t author \t publisher \t price ");
        for(Bai4 f : lst){
            System.out.println("");
            f.toString();
            System.out.println("=================================================================");
        }
    }
    public void sortDESC(){
        Collections.sort(lstSach, (Bai4 o1,Bai4 o2)-> (int) (o2.getPrice() - o1.getPrice()));
        System.out.println("Danh sách giảm dần theo giá là:");
        System.out.println("isbn \t bookName \t author \t publisher \t price ");
        lstSach.toString();
        System.out.println("=================================================================");
    }
    public static void main(String[] args) {
        mainBai4 app = new mainBai4();
        app.run();
    }
}
