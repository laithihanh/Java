/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai2 {
    private int MaGD;
    private String TenGD;
    private LocalDate NgayGD;
    private int MaDM;
    private float SoTien;

    public Bai2() {
    }

    public Bai2(int MaGD, String TenGD, LocalDate NgayGD, int MaDM, float SoTien) {
        this.MaGD = MaGD;
        this.TenGD = TenGD;
        this.NgayGD = NgayGD;
        this.MaDM = MaDM;
        this.SoTien = SoTien;
    }

    public int getMaGD() {
        return MaGD;
    }

    public void setMaGD(int MaGD) {
        this.MaGD = MaGD;
    }

    public String getTenGD() {
        return TenGD;
    }

    public void setTenGD(String TenGD) {
        this.TenGD = TenGD;
    }

    public LocalDate getNgayGD() {
        return NgayGD;
    }

    public void setNgayGD(LocalDate NgayGD) {
        this.NgayGD = NgayGD;
    }

    public int getMaDM() {
        return MaDM;
    }

    public void setMaDM(int MaDM) {
        this.MaDM = MaDM;
    }

    public float getSoTien() {
        return SoTien;
    }

    public void setSoTien(float SoTien) {
        this.SoTien = SoTien;
    }
    
    public void input() {
        Scanner s = new Scanner(System.in);
        // System.out.println("Mã sản phẩm: ");
        // this.MaGD = s.nextInt();
        System.out.printf("\tTên giao dich:");
        TenGD= s.nextLine();
        while(true){
            if(TenGD.length()> 0){
                 break;
            }else{
                System.err.printf("\tTên giao dich không được để trống\n");
                System.out.printf("\tNhập lại:");
                TenGD = s.nextLine(); 
            }
        }
        System.out.printf("\tNgày giao dịch: ");
        this.NgayGD = string2LocalDate(s);
        
        // s.nextLine(); // clear
        while (true) {
            try {
                System.out.printf("\tMã danh mục: ");
                this.MaDM = s.nextInt();
                while(MaDM <0){
                    System.err.println("\tMã danh mục phải lớn hơn 0");
                    System.out.printf("\tNhập lại:");
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số");
                  s.nextLine();
            }
        }
        while (true) {
            try {
                System.out.printf("\tSố tiền: ");
                this.SoTien = s.nextFloat();
                while(SoTien < 0){
                    System.err.println("\tSố tiền phải lớn hơn 0");
                    System.out.printf("\tNhập lại:");
                }
                break;
            } catch (Exception ex) {
                System.out.println("Yêu cầu nhập số:");
                  s.nextLine();
            }
        }
        System.out.println("Cảm ơn");
    }
     public LocalDate string2LocalDate( Scanner sc){
        LocalDate ld = null;
        try{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ld = LocalDate.parse(sc.nextLine(),dateTimeFormatter);
        }catch(DateTimeParseException e){
               System.err.println("\tNgày sinh không hợp lệ (dd/MM/yyyy)");
               System.out.printf("\tNhập lại :");
               sc.nextLine();
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return ld;
    }
}
