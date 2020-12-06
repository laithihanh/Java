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
public class KhachSan_Bai4 {
    List<Bai4> lstKhachSan= new ArrayList<>();
    
    public KhachSan_Bai4(){
        
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\t**********MENU**********");
            System.out.println("\t1.Nhập thông tin phòng");
            System.out.println("\t2.Hiển thị thông tin vừa nhập");
            System.out.println("\t3.Liệt kê các phòng trống trong danh sách.");
            System.out.println("\t4.Tính tổng số lượng giường có trong danh sách.");
            System.out.println("\t5.Sắp xếp danh sách liên kết tăng dần theo đơn giá thuê.");
            System.out.println("\t6.Thoát");
            System.out.print("Sự lựa chọn của bạn: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                   input(sc);
                    break;
                case 2:
                    display(lstKhachSan);
                    break;
                case 3:
                   LietkePhong(sc);
                    break;
                case 4:
                    Count(sc);
                    break;
                case 5:
                    sortAscending();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
    public void input(Scanner sc){
        System.out.print("Nhập thông tin n phòng:");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
          Bai4  phong = new Bai4();
            phong.input();
            System.out.println("");
            lstKhachSan.add(phong);
        }
    }
    
    public void display( List<Bai4> lst){
        for(Bai4 f : lst){
            System.out.println("");
            f.display();
        }
    }
    public void LietkePhong(Scanner sc) {
        List<Bai4> lst = new ArrayList<>();
        for(Bai4 f : lstKhachSan){
            if(f.getTinhTrangPhong()== 0){
                lst.add(f);
            }
        }
        System.out.println(" Danh sách phòng trống là: ");
        display(lst); 
        System.out.println("");
    
    }
    public void Count(Scanner sc) {
        List<Bai4> lst = new ArrayList<>();
        int count =0;
        for(Bai4 f : lstKhachSan){
               count+=f.getSoLuongGiuong();
        }
        System.out.println("Tổng số lượng giường là: "+count);
        display(lst); 
        
        System.out.println("");
    
    }
    public void sortAscending(){
        Collections.sort(lstKhachSan, new Comparator<Bai4>(){
            @Override
            public int compare(Bai4 o1,Bai4 o2){
                if(o1.DonGiaThue > o2.DonGiaThue ){
                    return 1;
                }else{
                    if(o1.DonGiaThue == o2.DonGiaThue){
                        return 0;
                    }else{
                        return -1;
                    }
                }
            }    
        });  
        System.out.println("Danh sách sắp xếp tăng dần theo đơn giá là: ");
        for(int i=0;i<lstKhachSan.size();i++){
            lstKhachSan.get(i).display();
            
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        KhachSan_Bai4 app = new KhachSan_Bai4();
        app.run();
    }
}
