/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class QuanLyGiangVien {
    List<Bai1> lstGiangVien = new ArrayList<>();
    
    public QuanLyGiangVien(){
        
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("==============Chon menu======================");
            System.out.println("\t1. Nhập vào thông tin của giảng viên ");
            System.out.println("\t2. Xuất danh sách toàn bộ giảng viên");
            System.out.println("\t3. Xuất danh sách giảng viên cơ hữu");
            System.out.println("\t4. Xuất danh sách giảng viên thỉnh giảng");
            System.out.println("\t5. Tính tổng số tiền lương của toàn bộ giảng viên");
            System.out.println("\t6.Tìm giảng viên có tổng lương cao nhất.");
            System.out.println("\t7.Thoát");
            System.out.print("Chọn chức năng 1->7: ");
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
                    display(true);
                    break;
                case 4:
                    display(false);
                    break;
                case 5:
                    totalSalary();
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }
    public void input(Scanner sc) {
        System.out.println("Nhập giảng viên cơ hữu chọn (C); nhập giảng viên thỉnh giảng (T)");
        String str =  sc.nextLine();
         char c = ' ';
        if(str.length() >= 0){
             c = str.charAt(0);
        }
       
        System.out.printf("Số lượng giảng viên cần nhập: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (c == 'C' || c == 'c') {
                GiangVienCoHuu gv = new GiangVienCoHuu();
                gv.input();
                lstGiangVien.add(gv);
            } else {
                GiangVienThinhGiang gv = new GiangVienThinhGiang();
                 System.out.println("");
                gv.input();
                lstGiangVien.add(gv);
            }
        }
    }
    public void display() {
        System.out.println("Tên \t   Địa chỉ \t   Điện thoại \t   Số giờ giảng ");
        for (int i = 0; i < lstGiangVien.size(); i++) {
            if (lstGiangVien.get(i) instanceof GiangVienCoHuu) {
                ((GiangVienCoHuu) lstGiangVien.get(i)).display();
            } else {
                 System.out.println("");
                ((GiangVienThinhGiang) lstGiangVien.get(i)).display();
            }
        }
    }
    public void display(boolean type) {
        System.out.println("Tên \t  Địa chỉ \t  Điện thoại \t  Số giờ giảng");
        if (type) {

            for (int i = 0; i < lstGiangVien.size(); i++) {
                if (lstGiangVien.get(i) instanceof GiangVienCoHuu) {
                    ((GiangVienCoHuu) lstGiangVien.get(i)).display();
                }
            }
        } else {
            for (int i = 0; i < lstGiangVien.size(); i++) {
                if (lstGiangVien.get(i) instanceof GiangVienThinhGiang) {
                     System.out.println("");
                    ((GiangVienThinhGiang) lstGiangVien.get(i)).display();
                }
            }
        }

    }
    public void totalSalary(){
        double total = 0.0;
        for (int i = 0; i < lstGiangVien.size(); i++) {
            if (lstGiangVien.get(i) instanceof GiangVienCoHuu) {
               GiangVienCoHuu gc = ((GiangVienCoHuu) lstGiangVien.get(i));
               total += gc.getLuong();
            } else {
                GiangVienThinhGiang gt = ((GiangVienThinhGiang) lstGiangVien.get(i));
                total += (gt.getSoGioGiang() * 200000);
            }
        }
        
        System.out.println("\tTổng lương toàn bộ giảng viên:" + total);
    }
     public void totalSalaryMax(){
         double total = 0.0;
          double max = 0;
          
     }
    public static void main(String[] args) {
        // TODO code application logic here
        QuanLyGiangVien app = new QuanLyGiangVien();
        app.run();
    }
    
}