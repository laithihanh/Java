/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai1 {

    List<Car> lstXe = new ArrayList<>();
    
    public Bai1(){
        
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\t==========Chon menu=========");
            System.out.println("\t1. Nhập vào một danh sách LuxuryCar.");
            System.out.println("\t2.Hiển thị thông tin của danh sách");
            System.out.println("\t3. Sắp xếp danh sách giảm dần bởi giá bán và hiển thị thông tin");
            System.out.println("\t4. Tìm kiếm thông tin theo tên xe nhập vào.");
            System.out.println("\t5. Hiển thị tổng giá bán với giá vận chuyển là $ 20,000");
            System.out.println("\t6. Thoát");
            System.out.print("Chọn chức năng 1->5: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display(lstXe);
                    break;
                case 3:
                   sortDescending();
                    break;
                case 4:
                    search(sc);
                    break;
                 case 5:
//                    SumPrice(lstXe);
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
    public void input(Scanner sc){
        System.out.print("Nhập một danh sách LuxuryCar:");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
            LuxuryCar xe = new LuxuryCar();
            xe.input();
            System.out.println("");
            lstXe.add(xe);
            
         
        }
        
    }
    public void display( List<Car> lst ){
        for(Car f : lst){
            System.out.println("");
            f.getInfor();
        }
    }
    public void sortDescending(){
        Collections.sort(lstXe, new Comparator<Car>(){
            @Override
            public int compare(Car o1,Car o2){
                if(o1.calculatePrice() < o2.calculatePrice() ){
                    return 1;
                }else{
                    if(o1.calculatePrice() == o2.calculatePrice()){
                        return 0;
                    }else{
                        return -1;
                    }
                }
            }    
        });  
        System.out.println("Danh sách sắp xếp giảm dần là: ");
        for(int i=0;i<lstXe.size();i++){
            lstXe.get(i).getInfor();
            
        }
    }
    
    public void search(Scanner sc){
        Car searchSer;
        Car setSer = new Car();
        int i;
         System.out.print("Nhập mẫu xe cần tìm: ");
         String search = sc.nextLine();
         setSer.setName(search);
        System.out.println("Danh sách mẫu xe tìm thấy: ");
        for(i=0; i<lstXe.size();i++){
            searchSer = (Car) lstXe.get(i);
            if(searchSer.getName().contains(search)){
                searchSer.getInfor();
            }
        }
    }
//    public void SumPrice(List<Car> lst){
//   
//        for(Car f : lst){
//            LuxuryCar luxury = new LuxuryCar();
//            System.out.println(""+luxury.calculatePrice());
//            f.getInfor();
//        }
//        
//    
//    }
    public static void main(String[] args) {
       Bai1 app = new Bai1();
        app.run();
    }
    
}
