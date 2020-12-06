/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bailamthemlap11;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class NhanVien_Bai1 {
    ArrayList<Bai1> lstNhanVien = new ArrayList<>();
    public NhanVien_Bai1(){
        
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\t**********MENU**********");
            System.out.println("\t1.Nhập thông tin nhân viên");
            System.out.println("\t2.Hiển thị thông tin vừa nhập");
            System.out.println("\t3.Liệt kê các nhân viên trên 40 tuổi trong danh sách.");
            System.out.println("\t4.Đếm số lượng nhân viên có lương lớn hơn 1.000.000 đồng trong danh sách.");
            System.out.println("\t5.Viết hàm sắp xếp các nhân viên giảm dần theo năm sinh (không quan tâm ngày và tháng sinh).");
            System.out.println("\t6.Thoát");
            System.out.print("Sự lựa chọn của bạn: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                   input(sc);
                    break;
                case 2:
                    display(lstNhanVien);
                    break;
                case 3:
                   calculateAge(sc);
                    break;
                case 4:
                    LuongNhanVien(sc);
                    break;
                case 5:
                    sortAscending();//Tăng dần
                    sortDescending();//Giảm dần
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
        Bai1 nhanvien = new Bai1();
        System.out.printf("Nhân viên %d \n",i+1);
        System.out.printf("\tNhập tên nhân viên:");
        sc.nextLine();
        nhanvien.setHoTen(sc.nextLine());
        while (nhanvien.getHoTen().length()>30) {
            System.out.printf("\tHọ tên phải không vượt quá 30 ký tự\n");
            System.out.printf("\tNhập tên nhân viên:");
            nhanvien.setHoTen(sc.nextLine());
        }
       
        while (true) {
            try {
            
               System.out.printf("\tNhập ngày sinh:");
               nhanvien.setNgaySinh(string2LocalDate(sc));
                break;
            } catch (Exception ex) {
                System.out.println("Yêu cầu nhập số:");
                System.out.println(""+ex.getLocalizedMessage());
                  sc.nextLine();
            }
        }
        while (true) {
            try {
            
               System.out.printf("\tNhập lương:");
                nhanvien.setLuong(sc.nextFloat());
                break;
            } catch (Exception ex) {
                System.out.println("Yêu cầu nhập số thực:");
                System.out.println(""+ex.getLocalizedMessage());
                  sc.nextLine();
            }
        }   
        
        System.out.printf("\tNhập giới tính(0 chọn nữ, 1 chọn nam):");
        nhanvien.setGioiTinh(sc.nextInt());
        while (( nhanvien.getGioiTinh()!=0) && (nhanvien.getGioiTinh() !=1)) {
            System.out.printf("\tNữ (0), Nam (1):");
            nhanvien.setGioiTinh(sc.nextInt());
        }
        lstNhanVien.add(nhanvien);
    }
    }
     public LocalDate string2LocalDate( Scanner sc){
        LocalDate ld = null;
        try{
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ld = LocalDate.parse(sc.nextLine(),dateTimeFormatter);
        }catch(DateTimeParseException e){
               System.out.println("\tNgày sinh không hợp lệ (dd/MM/yyyy)");
               System.out.printf("\tNhập ngày sinh dạng (dd/MM/yyyy):");
                sc.nextLine();

        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return ld;
    }
    public void display( List<Bai1> lst ){
        for(Bai1 f : lst){
            System.out.println("");
            f.toString();
        }
    }
    public void  calculateAge(Scanner sc) {
        Bai1  nhanvien = new Bai1();
        System.out.println("Nhân viên có tuổi lớn hơn 40 là:");
        for(int i = 0 ; i< lstNhanVien.size(); i++){
         
           nhanvien=lstNhanVien.get(i);
           LocalDate ngaysinhNv = nhanvien.getNgaySinh();
           LocalDate DayNow = LocalDate.now();
           long years = ChronoUnit.YEARS.between(ngaysinhNv, DayNow);
           if(years>40){
               nhanvien.toString();
               System.out.println("");
           }
        }
    }
    public void  LuongNhanVien(Scanner sc){
        List<Bai1> lst = new ArrayList<>();
        int count = 0;
        for(Bai1 f : lstNhanVien){
            if(f.getLuong()>1000000){
                count++;
                lst.add(f);
            }
        }
        System.out.println(" Danh sách nhân viên có lương >1000000 là: ");
        display(lst); 
        System.out.println("Tổng nhân viên có lương >1000000 là: "+count);
        System.out.println("");
    }
    public void sortAscending(){
        Collections.sort(lstNhanVien, new Comparator<Bai1>() {
            @Override
            public int compare(Bai1 o1, Bai1 o2) {
                return o1.getNgaySinh().compareTo(o2.getNgaySinh());
            }
        });
        System.out.println("Danh sách sắp xếp tăng dần theo năm sinh là: ");
        for(Bai1 nhanvien :lstNhanVien){
            nhanvien.toString();
        }
    }
    public void sortDescending(){
        Collections.sort(lstNhanVien, new Comparator<Bai1>() {
            @Override
            public int compare(Bai1 o1, Bai1 o2) {
                return o2.getNgaySinh().compareTo(o1.getNgaySinh());
            }
        });
         System.out.println("Danh sách sắp xếp giảm dần theo năm sinh là: ");
        for(Bai1 nhanvien :lstNhanVien){
            nhanvien.toString();
        }
    }
    public void display(){
        for(Bai1 st : lstNhanVien){
            System.out.println(st.toString());
        }
    }
     public static void main(String[] args) {
        // TODO code application logic here
        NhanVien_Bai1 app = new NhanVien_Bai1();
        app.run();
    }
}
