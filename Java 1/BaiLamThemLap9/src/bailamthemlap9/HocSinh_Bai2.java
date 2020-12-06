/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bailamthemlap9;
import bailamthemlap9.Bai2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class HocSinh_Bai2 {
    List<Bai2> lstHocSinh= new ArrayList<>();
    
    public HocSinh_Bai2(){
        
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\t**********MENU**********");
            System.out.println("\t1.Nhập thông tin nhân viên");
            System.out.println("\t2.Hiển thị thông tin vừa nhập,thêm,sửa,xóa thông tin");
            System.out.println("\t3.Liệt kê các học sinh có điểm toán nhỏ hơn 5 trong danh sách.");
            System.out.println("\t4.Đếm số lượng học sinh có điểm toán và điểm văn lớn hơn 8 điểm trong danh sách.");
            System.out.println("\t5.Viết hàm sắp xếp các học sinh giảm dần theo điểm trung bình.");
            System.out.println("\t6.Thoát");
            System.out.print("Sự lựa chọn của bạn: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                   input(sc);
                    break;
                case 2:
                    display(lstHocSinh);
                    break;
                case 3:
                   LietkeDiemToan(sc);
                    break;
                case 4:
                    Count(sc);
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
        System.out.print("Nhập thông tin n học sinh:");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
          Bai2  hocsinh = new Bai2();
            hocsinh.input();
            System.out.println("");
            lstHocSinh.add(hocsinh);
        }
    }
    
    public void display( List<Bai2> lst ){
        for(Bai2 f : lst){
            System.out.println("");
            f.display();
        }
    }
    public void LietkeDiemToan(Scanner sc) {
        List<Bai2> lst = new ArrayList<>();
        for(Bai2 f : lstHocSinh){
            if(f.getDiemToan()<5){
                lst.add(f);
            }
        }
        System.out.println(" Danh sách học sinh có điểm toán < 5 là: ");
        display(lst); 
        System.out.println("");
    
    }
    public void Count(Scanner sc) {
        List<Bai2> lst = new ArrayList<>();
        int count =0;
        for(Bai2 f : lstHocSinh){
            if(f.getDiemToan()>8){
                if (f.getDiemVan()>8) {
                    count++;
                    lst.add(f);
                }
            }
        }
        System.out.println(" Danh sách học sinh có điểm văn ,toán >8 là: ");
        display(lst); 
        System.out.println("Tổng học sinh có điểm văn ,toán >8 là: "+count);
        System.out.println("");
    
    }
    public void sortDescending(){
        Collections.sort(lstHocSinh, new Comparator<Bai2>(){
            @Override
            public int compare(Bai2 o1,Bai2 o2){
                if(o1.TrungBinh < o2.TrungBinh ){
                    return 1;
                }else{
                    if(o1.TrungBinh == o2.TrungBinh){
                        return 0;
                    }else{
                        return -1;
                    }
                }
            }    
        });  
        System.out.println("Danh sách sắp xếp giảm dần là: ");
        for(int i=0;i<lstHocSinh.size();i++){
            lstHocSinh.get(i).display();
            
        }
    }
//    public void edit(int id) {
//        boolean isExisted = false;
//        for (int i = 0; i < lstHocSinh.size(); i++) {
//            Bai2 hocsinh = new Bai2();
//            if (hocsinh.getName() == hocsinh.name) {
//                isExisted = true;
//                hocsinh.getName();
//                hocsinh.getDiemToan();
//                hocsinh.getDiemVan();
//                hocsinh.getTrungBinh();
//                break;
//            }
//        }
//        if (!isExisted) {
//            Object[] name = null;
//            System.out.printf("name= %d not existed.\n",name);
//        } else {
//            studentDao.write(studentList);
//        }
//    }
//    
    public static void main(String[] args) {
        // TODO code application logic here
        HocSinh_Bai2 app = new HocSinh_Bai2();
        app.run();
    }
}
