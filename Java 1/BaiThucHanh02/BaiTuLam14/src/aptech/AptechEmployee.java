/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech;

import emp.Employee;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class AptechEmployee extends Employee{
    private String DonVi;//Đơn vị
    private String LinhVucDaoTao;//Lĩnh vực đào tạo

    public AptechEmployee() {
    }

    public String getDonVi() {
        return DonVi;
    }

    public void setDonVi(String DonVi) {
        this.DonVi = DonVi;
    }

    public String getLinhVucDaoTao() {
        return LinhVucDaoTao;
    }

    public void setLinhVucDaoTao(String LinhVucDaoTao) {
        this.LinhVucDaoTao = LinhVucDaoTao;
    }

    public AptechEmployee(String DonVi, String LinhVucDaoTao, String MaNv, String TenNv, Boolean GioiTinh, LocalDate NgaySinh, String QueQuan, String CongTy, String PhongBan, String ChucVu, int HeSoLuong, int SoCongViecTrongThang) {
        super(MaNv, TenNv, GioiTinh, NgaySinh, QueQuan, CongTy, PhongBan, ChucVu, HeSoLuong, SoCongViecTrongThang);
        this.DonVi = DonVi;
        this.LinhVucDaoTao = LinhVucDaoTao;
    }

    @Override
    public void display() {
        super.display(); 
        StringBuilder builder = new StringBuilder();
  
        builder.append((String.format("%20s",this.DonVi)));
        builder.append("\t|");
        builder.append((String.format("%20s",this.LinhVucDaoTao)));
        
        System.out.println(builder.toString());
    }

    @Override
    public void input() {
        super.input(); 
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập đơn vị :");
        DonVi= sc.nextLine();
        while (true ) {
            if(DonVi.length()>0)
                break;
            else
                System.err.printf("\tĐơn vị không được để trống\n");
                System.out.printf("\tNhập lại:");
                DonVi = sc.nextLine(); 
        }
        
        System.out.printf("\tNhập lĩnh vực đào tạo :");
        LinhVucDaoTao= sc.nextLine();
        while (true ) {
            if(LinhVucDaoTao.length()>0)
                break;
            else
                System.err.printf("\tLĩnh vực không được để trống\n");
                System.out.printf("\tNhập lại:");
                LinhVucDaoTao = sc.nextLine(); 
        }
    }
    
    
}
