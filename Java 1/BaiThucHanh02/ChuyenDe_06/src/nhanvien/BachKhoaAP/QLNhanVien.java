/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhanvien.BachKhoaAP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import nhanvien.NhanVien;

/**
 *
 * @author ADMIN
 */
public class QLNhanVien {
    List<NhanVien> lstNhanVien = new ArrayList<>();
//    NhanVienBKAP arrNV[] = new NhanVienBKAP[3];
    public QLNhanVien(){
        
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\t==========Chon menu=========");
            System.out.println("\t1.Nhập");
            System.out.println("\t2.Hiển thị ");
            System.out.println("\t3. Tìm kiếm");
            System.out.println("\t4. Sắp xếp giảm dần");
            System.out.println("\t5. Xếp Loai – Khen Thuong");
            System.out.println("\t6. Thoát");
            System.out.print("Chọn chức năng 1->6: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display(lstNhanVien);
                    break;
                case 3:
                    search(sc);
                    break;
                case 4:
                    sortDescending();
                    break;
                 case 5:
                  xepLoai();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
    public void input(Scanner sc){
        System.out.print("Nhập số lượng nhân viên:");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
            NhanVienBKAP nhanvien = new NhanVienBKAP();
            System.out.println("");
            nhanvien.input();
             System.out.println("");
            lstNhanVien.add(nhanvien);
            
         
        }
        System.out.println("------------------------------");
        
    }
    public void display( List<NhanVien> lst ){
        for(NhanVien f : lst){
            System.out.println("");
            f.intro();
            System.out.println("------------------------------");
        }
    }  
    public void search(Scanner sc){
        NhanVien searchSer;
        boolean isNull = true;
        NhanVien setSer = new NhanVien();
        int i;
         System.out.print("Nhập tên nhân viên cần tìm: ");
         String search = sc.nextLine();
         setSer.setTen(search);
        for(i=0; i<lstNhanVien.size();i++){
            searchSer = (NhanVien) lstNhanVien.get(i);
            if(searchSer.getTen().contains(search)){
                searchSer.intro();
                System.out.println("------------------------------");
                isNull = false;
            }
        }
        if (isNull) {
            System.out.println("Không tim thấy");
            System.out.println("------------------------------");
        }
    }
        public void sortDescending(){
        Collections.sort(lstNhanVien, new Comparator<NhanVien>(){
            @Override
            public int compare(NhanVien o1,NhanVien o2){
                if(o1.getLuongCoBan() < o2.getLuongCoBan() ){
                    return 1;
                }else{
                    if(o1.getLuongCoBan() == o2.getLuongCoBan()){
                        return 0;
                    }else{
                        return -1;
                    }
                }
            }    
        });  
        System.out.println("Danh sách sắp xếp giảm dần là: ");
            for(int i=0;i<lstNhanVien.size();i++){
                lstNhanVien.get(i).intro();
                System.out.println("------------------------------");
            }
        }
        private void xepLoai() {
            List<NhanVienBKAP> NhanVienBKAP = new ArrayList<>();
            List<NhanVienBKAP> lstXuatSac = NhanVienBKAP.stream().filter((nv) -> {
                return nv.getSoNgayLam() > 26;
            }).collect(Collectors.toList());
            List<NhanVienBKAP> lstTot = NhanVienBKAP.stream().filter((nv) -> {
                return nv.getSoNgayLam() > 24 && nv.getSoNgayLam() <= 26;
            }).collect(Collectors.toList());
                System.out.println("\t *** KHEN THƯỞNG NHÂN VIÊN ***");
            if (lstXuatSac.size() > 0) {
                System.out.println("XUẤT SẮC");
                for (NhanVienBKAP xs : lstXuatSac) {
                    xs.intro();
                    System.out.println("------------------------------");
                }
            } else if (lstTot.size() > 0) {
                System.out.println("TỐT");
                for (NhanVienBKAP xs : lstTot) {
                    xs.intro();
                    System.out.println("------------------------------");
                }
            }else{
                System.out.println("(Khiển trách toàn bộ nhân viên do số ngày nghỉ làm quá nhiều)");
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
       QLNhanVien app = new QLNhanVien();
        app.run();
    }
}
