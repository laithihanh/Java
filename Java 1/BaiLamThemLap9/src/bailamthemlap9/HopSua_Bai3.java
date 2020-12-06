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
public class HopSua_Bai3 {
    List<Bai2> lstSua= new ArrayList<>();
    
    public HopSua_Bai3(){
        
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\t**********MENU**********");
            System.out.println("\t1.Nhập số lượng sữa");
            System.out.println("\t2.Hiển thị thông tin vừa nhập");
            System.out.println("\t3.Đếm số lượng hộp sữa sản xuất trước năm 2003 trong danh sách.");
            System.out.println("\t4.Tìm hộp sữa mới nhất trong danh sách.");
            System.out.println("\t5.Sắp xếp các hộp sữa tăng dần theo hạn sử dụng.");
            System.out.println("\t6.Thoát");
            System.out.print("Sự lựa chọn của bạn: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                   input(sc);
                    break;
                case 2:
                    display(lstSua);
                    break;
                case 3:
//                   LietkeDiemToan(sc);
                    break;
                case 4:
//                    Count(sc);
                    break;
                case 5:
//                    sortDescending();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
    public void input(Scanner sc){
        System.out.print("Nhập thông tin sữa:");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
          Bai2  sua = new Bai2();
            sua.input();
            System.out.println("");
            lstSua.add(sua);
        }
    }
    
    public void display( List<Bai2> lst ){
        for(Bai2 f : lst){
            System.out.println("");
            f.display();
        }
    }
//    public void LietkeDiemToan(Scanner sc) {
//        List<Bai2> lst = new ArrayList<>();
//        for(Bai2 f : lstSua){
//            if(f.getDiemToan()<5){
//                lst.add(f);
//            }
//        }
//        System.out.println(" Danh sách học sinh có điểm toán < 5 là: ");
//        display(lst); 
//        System.out.println("");
//    
//    }
//    public void Count(Scanner sc) {
//        List<Bai2> lst = new ArrayList<>();
//        int count =0;
//        for(Bai2 f : lstSua){
//            if(f.getDiemToan()>8){
//                if (f.getDiemVan()>8) {
//                    count++;
//                    lst.add(f);
//                }
//            }
//        }
//        System.out.println(" Danh sách học sinh có điểm văn ,toán >8 là: ");
//        display(lst); 
//        System.out.println("Tổng học sinh có điểm văn ,toán >8 là: "+count);
//        System.out.println("");
//    
//    }
//    public void sortDescending(){
//        Collections.sort(lstSua, new Comparator<Bai2>(){
//            @Override
//            public int compare(Bai2 o1,Bai2 o2){
//                if(o1.TrungBinh < o2.TrungBinh ){
//                    return 1;
//                }else{
//                    if(o1.TrungBinh == o2.TrungBinh){
//                        return 0;
//                    }else{
//                        return -1;
//                    }
//                }
//            }    
//        });  
//        System.out.println("Danh sách sắp xếp giảm dần là: ");
//        for(int i=0;i<lstSua.size();i++){
//            lstSua.get(i).display();
//            
//        }
//    }

    public static void main(String[] args) {
        // TODO code application logic here
        HocSinh_Bai2 app = new HocSinh_Bai2();
        app.run();
    }
}
