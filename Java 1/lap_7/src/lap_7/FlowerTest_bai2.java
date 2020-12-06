/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_7;
import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import lap_7.Bai2;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class FlowerTest_bai2 {
    List<Bai2> lstFlower = new ArrayList<>();
    
    public FlowerTest_bai2(){
        
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("==============Chon menu======================");
            System.out.println("\ta. Nhập thông tin n loài hoa ");
            System.out.println("\tb. Hiển thị thông tin vừa nhập");
            System.out.println("\tc. Sắp xếp danh sách tăng dần theo tên hoa");
            System.out.println("\td. Tìm kiếm theo flowerID");
            System.out.println("\te. Hiển thị tất cả các loại hoa có màu trắng");
            System.out.println("\tf. Thoát");
            System.out.print("Chọn chức năng a->f: ");
            
               char choice = sc.next().charAt(0);
           
            switch(choice){
                case 'a':
                    input(sc);
                    break;
                case 'b':
                    display(lstFlower);
                    break;
                case 'c':
                    sort();
                    break;
                case 'd':
                    search(sc);
                    break;
                case 'e':
                     kindOfFlower(sc);
                    break;
                case 'f':
                    System.exit(0);
                    break;
            }
        }
    }
    
    public void input(Scanner sc){
        System.out.print("Số hoa cần nhập:");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
          Bai2  flower = new Bai2();
            flower.input();
            lstFlower.add(flower);
        }
    }
    
    public void display( List<Bai2> lst ){
        for(Bai2 f : lst){
            f.display();
        }
    }
    
    public void sort(){
        Collections.sort(lstFlower);
        System.out.println("Danh sách tăng dần theo tên hoa: ");
        for(Bai2 f : lstFlower){
            f.display();
        }
    }
    
     public void search(Scanner sc){
         System.out.print("Nhập ID loài hoa cần tìm: ");
         sc.nextLine();
         String search = sc.nextLine();
        List<Bai2> lst = new ArrayList<>();
        for(Bai2 f : lstFlower){
            if(f.getFlowerID().contains(search)){
                lst.add(f);
            }
        }
         System.out.println("Danh sách hoa tìm thấy: ");
        display(lst);
    }
     
     public void kindOfFlower(Scanner sc){
        List<Bai2> lst = new ArrayList<>();
        for(Bai2 f : lstFlower){
            if(f.getKindOfFlower()==3){
                lst.add(f);
            }
        }
         System.out.println("Danh sách loại hoa có màu trắng: ");
        display(lst); 
     }
    public static void main(String[] args) {
        // TODO code application logic here
        FlowerTest_bai2 app = new FlowerTest_bai2();
        app.run();
    }
    }
