/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_12;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import lap_12.bank.WorkOfBank;
import lap_12.work.Work;

/**
 *
 * @author USER
 */
public class ManagerWorkingOfBank {

    List<Work> lstWork = new ArrayList<>();
    
    public ManagerWorkingOfBank(){
        
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\t==========Chon menu=========");
            System.out.println("\t1. Nhập vào thông tin n công việc của ngân hang");
            System.out.println("\t2.Hiển thị danh sách thông tin các công việc");
            System.out.println("\t3. Sắp xếp và hiển thị danh sách tăng dần theo tên công việc");
            System.out.println("\t4. Sắp xếp và hiển thị danh sách giảm dần theo số ngày thực hiện");
            System.out.println("\t5. Tìm kiếm thông tin công việc theo tên công việc ");
            System.out.println("\t6.Thoát ");
            System.out.print("Chọn chức năng 1->6: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display(lstWork);
                    break;
                case 3:
                   sortAscending();//tăng
                    break;
                case 4:
                    sortDescending();//giảm
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
        System.out.print("Nhập thông tin n cv:");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
            System.out.println("Nhập công việc " + (i + 1));
            WorkOfBank CongViec = new WorkOfBank();
            CongViec.input();
            System.out.println("");
            lstWork.add(CongViec);   
        }  
    }
   public void display( List<Work> lst ){
        System.out.println("Mã \t Tên \t    Ngày bắt đầu \t  Ngày Kết thúc \t  Tổng chi phí \t Ngày thực hiện cv \t Phòng ban thực hiện \t Số nhân viên thực hiện \t Cấp duyệt ");
        for(Work f : lst){
            System.out.println("");
            f.display();
            System.out.println("=====================================================================================================================================================");
        }
    }
    public void sortAscending(){
        Collections.sort(lstWork);
        System.out.println("Danh sách tăng dần theo tên công việc: ");
         System.out.println("Mã \t Tên \t    Ngày bắt đầu \t  Ngày Kết thúc \t  Tổng chi phí \t Ngày thực hiện cv \t Phòng ban thực hiện \t Số nhân viên thực hiện \t Cấp duyệt ");
        for(Work f : lstWork){
             System.out.println("");
            f.display();
        }
    }
    public void sortDescending(){
        Work  CongViec = new Work();
        Collections.sort(lstWork, new Comparator<Work>() {
            @Override
            public int compare(Work o1, Work o2) {
                if(o1. NgayThucHien() < o2.NgayThucHien() ){
                    return 1;
                }else{
                    if(o1.NgayThucHien() == o2.NgayThucHien()){
                        return 0;
                    }else{
                        return -1;
                    }
                }
            }
        });
         System.out.println("Danh sách sắp xếp giảm dần theo số ngày thực hiện là: ");
          System.out.println("Mã \t Tên \t    Ngày bắt đầu \t  Ngày Kết thúc \t  Tổng chi phí \t Ngày thực hiện cv \t Phòng ban thực hiện \t Số nhân viên thực hiện \t Cấp duyệt ");
        for(Work nhanvien :lstWork){
             System.out.println("");
            nhanvien.display();
        }
    }
    public void search(Scanner sc){
        Work searchSer;
        Work setSer = new Work();
        int i;
         System.out.print("Nhập tên công việc cần tìm: ");
         String search = sc.nextLine();
         setSer.setWorkName(search);
        System.out.println("Danh sách người tìm thấy: ");
         System.out.println("Mã \t Tên \t    Ngày bắt đầu \t  Ngày Kết thúc \t  Tổng chi phí \t Ngày thực hiện cv \t Phòng ban thực hiện \t Số nhân viên thực hiện \t Cấp duyệt ");
        for(i=0; i<lstWork.size();i++){
            searchSer = (Work) lstWork.get(i);
            if(searchSer.getWorkName().contains(search)){
                 System.out.println("");
                searchSer.display();
            }
        }
    }
    public static void main(String[] args) {
        ManagerWorkingOfBank app = new ManagerWorkingOfBank();
        app.run();
    }
    
}
