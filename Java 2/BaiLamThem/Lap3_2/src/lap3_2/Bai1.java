/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap3_2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author USER
 */
public class Bai1 {
    private String Tinh;
    private float DienTich;
    private long DanSo;

    public Bai1() {
    }

    public Bai1(String Tinh, float DienTich, long DanSo) {
        this.Tinh = Tinh;
        this.DienTich = DienTich;
        this.DanSo = DanSo;
    }

    public String getTinh() {
        return Tinh;
    }

    public void setTinh(String Tinh) {
        this.Tinh = Tinh;
    }

    public float getDienTich() {
        return DienTich;
    }

    public void setDienTich(float DienTich) {
        this.DienTich = DienTich;
    }

    public long getDanSo() {
        return DanSo;
    }

    public void setDanSo(long DanSo) {
        this.DanSo = DanSo;
    }
    String exgExpTinh= "^[a-zA-Z 0-9]{1,30}$";
    public void input(){
        Scanner sc = new Scanner(System.in);
        do{
            
            System.out.printf("\tNhập tên tỉnh:");
            this.Tinh= sc.nextLine();
            Pattern pattern = Pattern.compile(exgExpTinh);
            Matcher matcher = pattern.matcher(Tinh);
            if(matcher.matches()){
                break;
            }else{
                System.err.println("\tFullname không vượt quá 30 ký tự");
            }
        }while(true);
        
        while (true) {
            try {
                System.out.printf("\tNhập diện tích:");
                this.DienTich = sc.nextFloat();
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số:");
                  sc.nextLine();
            }
        }  
        
        while (true) {
            try {
                System.out.printf("\tNhập dân số:");
                this.DanSo = sc.nextLong();
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số:");
                  sc.nextLine();
            }
        }
    
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
  
        builder.append((String.format(this.Tinh)));
        builder.append("\t|");
        builder.append((String.format("%10s",this.DienTich)));
        builder.append("\t|");
        builder.append((String.format("%10s",this.DanSo)));
        
        System.out.println(builder.toString());
        return super.toString();
        
    }

//    @Override
//    public String toString() {
//        return "Bai1{" + "Tinh=" + Tinh + ", DienTich=" + DienTich + ", DanSo=" + DanSo + '}';
//    }
    

    int compareTo(Bai1 max) {
         return (int) getDienTich();
    }
    
    
    
}
