/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bailamthemlap11.Bai2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Person implements IPerson,Comparable<Person>{
   
    private String HoTen;//tối thiểu có 5 kí tự, tối đa có 50 kí tự
    private Boolean GioiTinh ;//bắt buộc phải nhập true/false
    private LocalDate NgaySinh; //Phải đủ 18 tuổi trở lên so với năm hiện tại
    private String QueQuan; //Tối thiểu có 5 kí tự, tối đa có 200 kí tự

    public Person() {
    }

    public Person(String HoTen, Boolean GioiTinh, LocalDate NgaySinh, String QueQuan) {
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.QueQuan = QueQuan;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public Boolean getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(Boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public LocalDate getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(LocalDate NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String QueQuan) {
        this.QueQuan = QueQuan;
    }

    @Override
    public void input() {
       Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập họ tên:");
        HoTen = sc.nextLine();
        while (HoTen.length()<5 || HoTen.length()>50) {
            System.err.printf("\tHọ tên phải có tối thiểu 5 kyd tự và không vượt quá 50 ký tự\n");
            System.out.printf("\tNhập tên nhân viên:");
            HoTen = sc.nextLine(); 
        }
        while (true) {
            try {
            
               System.out.printf("\tNhập giới tính(true,false):");
                GioiTinh = sc.nextBoolean();
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập true hoặc false :");
                System.out.println(""+ex.getLocalizedMessage());
                  sc.nextLine();
            }
        }  
         while (true) {
            try {
                Person nguoi = new Person();
               System.out.printf("\tNhập ngày sinh:");
               sc.nextLine();
               nguoi.setNgaySinh(string2LocalDate(sc));
                break;
            } catch (Exception ex) {
                System.out.println("Yêu cầu nhập số:");
                System.out.println(""+ex.getLocalizedMessage());
                  sc.nextLine();
            }
        }
//        System.out.printf("\tNhập ngày sinh:");
//        NgaySinh = input.nextLocalDate();
        System.out.printf("\tNhập quê quán:");
        QueQuan = sc.nextLine();
        while (QueQuan.length()<5 || QueQuan.length()>200) {
            System.err.printf("\tHọ tên phải có tối thiểu 5 kyd tự và không vượt quá 200 ký tự\n");
            System.out.printf("\tNhập quê quán:");
            QueQuan = sc.nextLine(); 
        }
    }
public LocalDate string2LocalDate( Scanner sc){
        LocalDate ld = null;
        try{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ld = LocalDate.parse(sc.nextLine(),dateTimeFormatter);
        }catch(DateTimeParseException e){
               System.err.println("\tNgày sinh không hợp lệ (dd/MM/yyyy)");
               System.out.printf("\tNhập ngày sinh :");
               sc.nextLine();
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return ld;
    }
    @Override
    public void display() {
        System.out.println("\tTên: "+HoTen);
        System.out.println("\tGiới tính: "+(GioiTinh == true ? "Nữ" : "Nam"));
        System.out.println("\tQuê quán: "+QueQuan);
    }

    @Override
    public int compareTo(Person o) {
        return this.getHoTen().compareTo(o.getHoTen());
    }
}
