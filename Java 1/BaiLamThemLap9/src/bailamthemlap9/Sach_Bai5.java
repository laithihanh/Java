/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bailamthemlap9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Sach_Bai5 {
     List<Bai5> lstSach= new ArrayList<>();
    
    public Sach_Bai5(){
        
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\t**********MENU**********");
            System.out.println("\t1.Nhập thông tin sách");
            System.out.println("\t2.Hiển thị thông tin vừa nhập(Thêm sửa xóa)");
            System.out.println("\t3.Tìm quyển sách cũ nhất trong danh sách liên kết.");
            System.out.println("\t4.Tìm một năm có nhiều sách xuất bản nhất và liệt kê tất cả các quyển sách xuất bản trong năm đó");
            System.out.println("\t5.Thoát");
            System.out.print("Sự lựa chọn của bạn: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                   input(sc);
                    break;
                case 2:
                    display(lstSach);
                    break;
                case 3:
                   LietkeSach(sc);
                    break;
                case 4:
//                    Count(sc);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
    public void input(Scanner sc){
        System.out.print("Nhập thông tin n phòng:");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
          Bai5  sach = new Bai5();
            sach.input();
            System.out.println("");
            lstSach.add(sach);
        }
    }
    
    public void display( List<Bai5> lst){
        for(Bai5 f : lst){
            System.out.println("");
            f.display();
        }
    }
    public void LietkeSach(Scanner sc) {
        List<Bai5> lst = new ArrayList<>();
        int min=0;
        for(Bai5 f : lstSach){
            if(f.getNamXuatBan() < min){
                min=f.getNamXuatBan();
                lst.add(f);
            }
        }
        System.out.println(" Danh sách phòng trống là: ");
        display(lst); 
        System.out.println("");
    
    }
//    public void Count(Scanner sc) {
//        List<Bai4> lst = new ArrayList<>();
//        int count =0;
//        for(Bai4 f : lstKhachSan){
//               count+=f.getSoLuongGiuong();
//        }
//        System.out.println("Tổng số lượng giường là: "+count);
//        display(lst); 
//        
//        System.out.println("");
//    
//    }
//    public void sortAscending(){
//        Collections.sort(lstKhachSan, new Comparator<Bai4>(){
//            @Override
//            public int compare(Bai4 o1,Bai4 o2){
//                if(o1.DonGiaThue > o2.DonGiaThue ){
//                    return 1;
//                }else{
//                    if(o1.DonGiaThue == o2.DonGiaThue){
//                        return 0;
//                    }else{
//                        return -1;
//                    }
//                }
//            }    
//        });  
//        System.out.println("Danh sách sắp xếp tăng dần theo đơn giá là: ");
//        for(int i=0;i<lstKhachSan.size();i++){
//            lstKhachSan.get(i).display();
//            
//        }
//    }
    public static void main(String[] args) {
        // TODO code application logic here
        Sach_Bai5 app = new Sach_Bai5();
        app.run();
    }
}
