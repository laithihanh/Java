/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTapLamThem_Lap2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author USER
 */
public class Bai2 {
    private String NhanHieu;
    private float TrongLuong;
    private LocalDate HSD;

    public Bai2() {
    }

    public Bai2(String NhanHieu, float TrongLuong, LocalDate HSD) {
        this.NhanHieu = NhanHieu;
        this.TrongLuong = TrongLuong;
        this.HSD = HSD;
    }

    public String getNhanHieu() {
        return NhanHieu;
    }

    public void setNhanHieu(String NhanHieu) {
        this.NhanHieu = NhanHieu;
    }

    public float getTrongLuong() {
        return TrongLuong;
    }

    public void setTrongLuong(float TrongLuong) {
        this.TrongLuong = TrongLuong;
    }

    public LocalDate getHSD() {
        return HSD;
    }

    public void setHSD(LocalDate HSD) {
        this.HSD = HSD;
    }
    String RegexpNhanHieu= "^[a-zA-Z 0-9]{1,20}$";
    public void input(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.printf("\tNhập nhãn hiệu:");
            this.NhanHieu= sc.nextLine();
            Pattern pattern = Pattern.compile(RegexpNhanHieu);
            Matcher matcher = pattern.matcher(NhanHieu );
            if(matcher.matches()){
                break;
            }else{
                System.err.println("\tNhãn hiệu không vượt quá 20 ký tự");
            }
        }while(true);
        while (true) {
            try {
                System.out.printf("\tNhập trọng lượng:");
                this.TrongLuong = sc.nextFloat();
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số thực:");
                  sc.nextLine();
            }
        }  
        sc.nextLine();
        System.out.printf("\tNhập hạn sử dụng:");
        HSD= string2LocalDate(sc);
    }
    public LocalDate string2LocalDate( Scanner sc){
        LocalDate ld = null;
        try{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ld = LocalDate.parse(sc.nextLine(),dateTimeFormatter);
        }catch(DateTimeParseException e){
               System.err.println("\tHạn sử dung không hợp lệ (dd/MM/yyyy)");
               System.out.printf("\tNhập lại :");
               sc.nextLine();
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return ld;
    }
    public void display(){
        StringBuilder builder = new StringBuilder();
  
        builder.append((String.format(this.NhanHieu)));
        builder.append("\t|");
        builder.append((String.format("%10s",this.TrongLuong)));
        builder.append("\t|");
        builder.append((String.format("%15s",this.HSD)));
        
        System.out.println(builder.toString());
    }
    public int YearHSD(){
        return HSD.getYear();
    }
}
