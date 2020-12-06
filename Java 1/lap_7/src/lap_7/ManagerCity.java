/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import lap_7.Bai1;
/**
 *
 * @author ADMIN
 */
public class ManagerCity {
    List<Bai1> lstCity = new ArrayList<>();
    
    public ManagerCity(){
        
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\t**********MENU**********");
            System.out.println("\t1.Nhập thông tin n thành phố");
            System.out.println("\t2.Hiển thị thông tin vừa nhập");
            System.out.println("\t3.Sắp xếp thông tin tăng dần theo tên nước.");
            System.out.println("\t4.Tìm kiếm thông tin theo cityId");
            System.out.println("\t5.Thoát.");
            System.out.print("Sự lựa chọn của bạn: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                   input(sc);
                    break;
                case 2:
                    display(lstCity);
                    break;
                case 3:
                    sort();
                    break;
                case 4:
                    search(sc);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
    public void input(Scanner sc){
        System.out.print("Nhập thông tin n thành phố:");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
          Bai1  city = new Bai1();
            city.input();
            lstCity.add(city);
        }
    }
    
    public void display( List<Bai1> lst ){
        for(Bai1 f : lst){
            System.out.println("");
            f.display();
        }
    }
    public void sort(){
        Collections.sort(lstCity) ;
        System.out.println("Danh sách tăng dần theo tên nước: ");
        for(Bai1 f : lstCity){
            System.out.println("");
            f.display();
        }
    }
     public void search(Scanner sc){
         System.out.print("Nhập mã thành phố: ");
         sc.nextLine();
         String search = sc.nextLine();
        List<Bai1> lst = new ArrayList<>();
        for(Bai1 f : lstCity){
            if(f.getCityId().contains(search)){
                System.out.println("");
                lst.add(f);
            }
        }
         System.out.println("Danh sách thành phố tìm thấy: ");
        display(lst);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        ManagerCity app = new ManagerCity();
        app.run();
    }
}