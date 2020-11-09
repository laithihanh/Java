/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class menuBai2 {
     List<Bai2> lstEmployee = new ArrayList<>();
    
    public menuBai2(){
        
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\t==========Chon menu=========");
            System.out.println("\t1. Nhập thông tin cho n nhân viên");
            System.out.println("\t2. Hiển thị thông tin vừa nhập"); 
            System.out.println("\t3.Thoát ");
            System.out.print("Chọn chức năng 1->3: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display(lstEmployee);
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }
    public void input(Scanner sc){
        System.out.print("Nhập thông tin n sinh viên:");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
            System.out.println("Nhập sinh viên " + (i + 1));
            Bai2 SinhVien = new Bai2();
            SinhVien.input();
            
            System.out.println("");
            lstEmployee.add(SinhVien);   
        }  
    }
   public void display( List<Bai2> lst ){
        System.out.println("rollNo \t\t fullname \t deskphone \t cellphone \t email \t\t yearOfBirth ");
        for(Bai2 f : lst){
            System.out.println("");
            f.toString();
            System.out.println("==========================================================================================");
        }
    }
   
    public static void main(String[] args) {
        menuBai2 app = new menuBai2();
        app.run();
    }
}
