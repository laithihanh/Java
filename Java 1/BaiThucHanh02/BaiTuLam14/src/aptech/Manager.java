/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech;

import emp.Employee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Manager {
    List<Employee> lstEmployee = new ArrayList<>();
    
    public Manager(){
        
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\t==========Chon menu=========");
            System.out.println("\t1. Nhập thông tin cho n nhân viên Aptech");
            System.out.println("\t2. Hiển thị thông tin vừa nhập");
            System.out.println("\t3. Sắp xếp thông tin giảm dần theo thưởng và hiển thị");
            System.out.println("\t4. Sắp xếp thông tin tăng dần theo phòng ban và hiển thị");
            System.out.println("\t5. Tìm kiếm thông tin theo phòng ban");
            System.out.println("\t6.Thoát ");
            System.out.print("Chọn chức năng 1->6: ");
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
                   sortDescending();//giảm
                  
                    break;
                case 4:
                     sortAscending();//tăng
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
    public void input(Scanner sc){
        System.out.print("Nhập thông tin n nhân viên:");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
            System.out.println("Nhập nhân viên " + (i + 1));
            AptechEmployee NhanVien = new AptechEmployee();
            NhanVien.input();
            System.out.println("");
            lstEmployee.add(NhanVien);   
        }  
    }
   public void display( List<Employee> lst ){
        System.out.println("Mã \t Tên \t Giới tính \t Ngày sinh \t Quê quán \t Công ty \t Phòng ban \t Chức vụ \t Hệ số lương \t Số công việc trong tháng \t Thưởng \t Lương \t Đơn vị \t Lĩnh vực đào tạo ");
        for(Employee f : lst){
            System.out.println("");
            f.display();
            System.out.println("===========================================================================================================================================================================");
        }
    }
   public void sortDescending(){
        Employee  CongViec = new Employee();
        Collections.sort(lstEmployee, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if(o1. calculateBonus() < o2.calculateBonus() ){
                    return 1;
                }else{
                    if(o1.calculateBonus() == o2.calculateBonus()){
                        return 0;
                    }else{
                        return -1;
                    }
                }
            }
        });
         System.out.println("Danh sách sắp xếp giảm dần theo thưởng là: ");
         System.out.println("Mã \t Tên \t Giới tính \t Ngày sinh \t Quê quán \t Công ty \t Phòng ban \t Chức vụ \t Hệ số lương \t Số công việc trong tháng \t Thưởng \t Lương \t Đơn vị \t Lĩnh vực đào tạo ");
        for(Employee nhanvien :lstEmployee){
             System.out.println("");
            nhanvien.display();
        }
    }
    public void sortAscending(){
        Collections.sort(lstEmployee,(Employee o1,Employee o2) ->o1.getPhongBan().compareTo(o2.getPhongBan())
        );
        
        System.out.println("Danh sách tăng dần theo phòng ban: ");
        System.out.println("Mã \t Tên \t Giới tính \t Ngày sinh \t Quê quán \t Công ty \t Phòng ban \t Chức vụ \t Hệ số lương \t Số công việc trong tháng \t Thưởng \t Lương \t Đơn vị \t Lĩnh vực đào tạo ");
        for(Employee f : lstEmployee){
             System.out.println("");
            f.display();
        }
    }
    
    public void search(Scanner sc){
        Employee searchSer;
        Employee setSer = new Employee();
        int i;
         System.out.print("Nhập tên phòng ban cần tìm: ");
         String search = sc.nextLine();
         setSer.setPhongBan(search);
        System.out.println("Danh sách tìm thấy: ");
        System.out.println("Mã \t Tên \t Giới tính \t Ngày sinh \t Quê quán \t Công ty \t Phòng ban \t Chức vụ \t Hệ số lương \t Số công việc trong tháng \t Thưởng \t Lương \t Đơn vị \t Lĩnh vực đào tạo ");
        for(i=0; i<lstEmployee.size();i++){
            searchSer = (Employee) lstEmployee.get(i);
            if(searchSer.getPhongBan().contains(search)){
                 System.out.println("");
                searchSer.display();
            }
        }
    }
    public static void main(String[] args) {
        Manager app = new Manager();
        app.run();
    }
}
