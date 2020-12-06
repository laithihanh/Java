/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTapLamThem_Lap2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 *
 * @author USER
 */
public class Bai1 {
    private String TenPhim;
    private int GiaTien;
    private LocalTime XuatChieu;
    private LocalDate NgayXem;

    public Bai1() {
    }

    public Bai1(String TenPhim, int GiaTien, LocalTime XuatChieu, LocalDate NgayXem) {
        this.TenPhim = TenPhim;
        this.GiaTien = GiaTien;
        this.XuatChieu = XuatChieu;
        this.NgayXem = NgayXem;
    }

    public String getTenPhim() {
        return TenPhim;
    }

    public void setTenPhim(String TenPhim) {
        this.TenPhim = TenPhim;
    }

    public int getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(int GiaTien) {
        this.GiaTien = GiaTien;
    }

    public LocalTime getXuatChieu() {
        return XuatChieu;
    }

    public void setXuatChieu(LocalTime XuatChieu) {
        this.XuatChieu = XuatChieu;
    }

    public LocalDate getNgayXem() {
        return NgayXem;
    }

    public void setNgayXem(LocalDate NgayXem) {
        this.NgayXem = NgayXem;
    }
    
    String RegexpTenPhim= "^[a-zA-Z 0-9]{1,20}$";
    public void input(){
        Scanner sc = new Scanner(System.in);
        do{
           
            System.out.printf("\tNhập tên phim:");
            this.TenPhim= sc.nextLine();
            Pattern pattern = Pattern.compile(RegexpTenPhim);
            Matcher matcher = pattern.matcher(TenPhim );
            if(matcher.matches()){
                break;
            }else{
                System.err.println("\tTên phim không vượt quá 20 ký tự");
            }
        }while(true);
        while(true){
            try{
            System.out.printf("\tNhập giá tiền:");
            this.GiaTien= sc.nextInt();
            if(GiaTien >= -2.147 && GiaTien <= 2.147){
                break;
            }else{
                System.err.println("\tNhập sai giá tiền");
            }
            }catch(Exception ex){
                System.err.println("\tYêu cầu nhập số");
                  sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.printf("\tNhập thời gian xuất chiếu:");
            XuatChieu= string2LocalTime(sc);
        System.out.printf("\tNhập ngày xem:");
            NgayXem= string2LocalDate(sc);
         
    }
    public LocalTime string2LocalTime( Scanner sc){
        LocalTime ld = null;
        try{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm");
            ld = LocalTime.parse(sc.nextLine(),dateTimeFormatter);
        }catch(DateTimeParseException e){
               System.err.println("\tThời gian xuất chiếu không hợp lệ (dd/MM/yyyy)");
               System.out.printf("\tNhập lại :");
               sc.nextLine();
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return ld;
    }
    public LocalDate string2LocalDate( Scanner sc){
        LocalDate ld = null;
        try{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ld = LocalDate.parse(sc.nextLine(),dateTimeFormatter);
        }catch(DateTimeParseException e){
               System.err.println("\tNgày xem không hợp lệ (dd/MM/yyyy)");
               System.out.printf("\tNhập lại :");
               sc.nextLine();
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return ld;
    }
    public void display(){
        StringBuilder builder = new StringBuilder();
  
        builder.append((String.format(this.TenPhim)));
        builder.append("\t|");
        builder.append((String.format("%10s",this.GiaTien)));
        builder.append("\t|");
        builder.append((String.format("%15s",this.XuatChieu)));
        builder.append("\t|");
        builder.append((String.format("%10s",this.NgayXem)));
        
        System.out.println(builder.toString());
    }
    public static void main(String[] args) {
        Set<Bai1> set = new HashSet<Bai1>();
        Scanner sc= new Scanner(System.in);
        System.out.printf("Nhập số lượng vé :");
        int n= sc.nextInt();
        for(int i=0; i<n; i++){
            Bai1 bai1 = new Bai1();
            System.out.println("Nhập vé " + (i + 1));
             bai1.input();
            set.add(bai1);
        }
        System.out.println("Danh sách vừa nhập là:");
        System.out.println("TenPhim \t GiaTien \t XuatChieu \t NgayXem");
    }
    
}
