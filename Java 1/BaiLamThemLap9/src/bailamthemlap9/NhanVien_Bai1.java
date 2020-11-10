/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bailamthemlap9;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class NhanVien_Bai1 {
    List<Bai1> lstNhanVien= new ArrayList<>();
    
    public NhanVien_Bai1(){
        
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\t**********MENU**********");
            System.out.println("\t1.Nhập thông tin nhân viên");
            System.out.println("\t2.Hiển thị thông tin vừa nhập");
            System.out.println("\t3.Liệt kê các nhân viên trên 40 tuổi trong danh sách.");
            System.out.println("\t4.Đếm số lượng nhân viên có lương lớn hơn 1.000.000 đồng trong danh sách.");
            System.out.println("\t5.Viết hàm sắp xếp các nhân viên giảm dần theo năm sinh (không quan tâm ngày và tháng sinh).");
            System.out.println("\t6.Thoát");
            System.out.print("Sự lựa chọn của bạn: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                   input(sc);
                    break;
                case 2:
                    display(lstNhanVien);
                    break;
                case 3:
                   calculateAge(sc);
                    break;
                case 4:
                    LuongNhanVien(sc);
                    break;
                case 5:
                    sortDescending();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
    public void input(Scanner sc){
        System.out.print("Nhập thông tin n nhân viên:");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
          Bai1  nhanvien = new Bai1();
            nhanvien.input();
            System.out.println("");
            lstNhanVien.add(nhanvien);
        }
    }
    
    public void display( List<Bai1> lst ){
        for(Bai1 f : lst){
            System.out.println("");
            f.display();
        }
    }
    public void  calculateAge(Scanner sc) {
        System.out.print("Nhập năm hiện tại :");
        int nam = sc.nextInt();
        System.out.println("Nhân viên có tuổi lớn hơn 40 là:");
        for(int i = 0 ; i< lstNhanVien.size(); i++){
           Bai1  nhanvien = new Bai1();
           nhanvien=lstNhanVien.get(i);
           
           int age=nam-nhanvien.getYearOfBirth();
           if(age>40){
               nhanvien.display();
               System.out.println("");
           }
        }
    }
    public void  LuongNhanVien(Scanner sc){
        List<Bai1> lst = new ArrayList<>();
        int count = 0;
        for(Bai1 f : lstNhanVien){
            if(f.getSalary()>1000000){
                count++;
                lst.add(f);
            }
        }
        System.out.println(" Danh sách nhân viên có lương >1000000 là: ");
        display(lst); 
        System.out.println("Tổng nhân viên có lương >1000000 là: "+count);
        System.out.println("");
    }
    public void sortDescending(){
        Collections.sort(lstNhanVien, new Comparator<Bai1>(){
            @Override
            public int compare(Bai1 o1,Bai1 o2){
                if(o1.YearOfBirth < o2.YearOfBirth ){
                    return 1;
                }else{
                    if(o1.YearOfBirth == o2.YearOfBirth){
                        return 0;
                    }else{
                        return -1;
                    }
                }
            }    
        });  
        System.out.println("Danh sách sắp xếp giảm dần là: ");
        for(int i=0;i<lstNhanVien.size();i++){
            lstNhanVien.get(i).display();
            
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        NhanVien_Bai1 app = new NhanVien_Bai1();
        app.run();
    }
}
