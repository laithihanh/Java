/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Employee implements IEmployee{
    private String MaNv;//Mã nhân viên
    private String TenNv;//Tên nhân viên
    private Boolean GioiTinh;//Giới tính
    private LocalDate NgaySinh;//Ngày sinh
    private String QueQuan;//Quê quán
    private String CongTy;//Công ty
    private String PhongBan;//Phòng ban
    private String ChucVu;//Chức vụ
    private int HeSoLuong;//Hệ số lương
    private int SoCongViecTrongThang;//Số công việc trong tháng

    public Employee() {
    }

    public String getMaNv() {
        return MaNv;
    }

    public void setMaNv(String MaNv) {
        this.MaNv = MaNv;
    }

    public String getTenNv() {
        return TenNv;
    }

    public void setTenNv(String TenNv) {
        this.TenNv = TenNv;
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

    public String getCongTy() {
        return CongTy;
    }

    public void setCongTy(String CongTy) {
        this.CongTy = CongTy;
    }

    public String getPhongBan() {
        return PhongBan;
    }

    public void setPhongBan(String PhongBan) {
        this.PhongBan = PhongBan;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public int getHeSoLuong() {
        return HeSoLuong;
    }

    public void setHeSoLuong(int HeSoLuong) {
        this.HeSoLuong = HeSoLuong;
    }

    public int getSoCongViecTrongThang() {
        return SoCongViecTrongThang;
    }

    public void setSoCongViecTrongThang(int SoCongViecTrongThang) {
        this.SoCongViecTrongThang = SoCongViecTrongThang;
    }

    public Employee(String MaNv, String TenNv, Boolean GioiTinh, LocalDate NgaySinh, String QueQuan, String CongTy, String PhongBan, String ChucVu, int HeSoLuong, int SoCongViecTrongThang) {
        this.MaNv = MaNv;
        this.TenNv = TenNv;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.QueQuan = QueQuan;
        this.CongTy = CongTy;
        this.PhongBan = PhongBan;
        this.ChucVu = ChucVu;
        this.HeSoLuong = HeSoLuong;
        this.SoCongViecTrongThang = SoCongViecTrongThang;
    }
    
    

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập mã nhân viên:");
        MaNv= sc.nextLine();
        while(MaNv.length()< 3){
            System.err.println("\tMã nhân viên phải đủ 3 ký tự");
            System.out.printf("\tNhập lại:");
            MaNv= sc.nextLine();
        }
        System.out.printf("\tNhập tên nhân viên:");
        TenNv= sc.nextLine();
        while(TenNv.length()>30){
            System.out.println("\tTên nhân viên không vượt quá 30 ký tự");
            System.out.printf("\tNhập lại:");
            TenNv= sc.nextLine();
        }
        while(true){
            try {
            
               System.out.printf("\tNhập giới tính(true,false):");
                GioiTinh = sc.nextBoolean();
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập true hoặc false :");
                  sc.nextLine();
            }
        }
       
        System.out.printf("\tNhập ngày sinh:");
        sc.nextLine();
        NgaySinh=string2LocalDate(sc);
  
        System.out.printf("\tNhập quê quán :");
        QueQuan= sc.nextLine();
        while (true ) {
            if(QueQuan.length()> 0){
                 break;
            }else{
                System.err.printf("\tQuê quán không được để trống\n");
                System.out.printf("\tNhập lại:");
                QueQuan = sc.nextLine(); 
            }
        }
        System.out.printf("\tNhập công ty :");
        CongTy= sc.nextLine();
        while (true) {
            if(CongTy.length()>0 )
                break;
            else
                System.err.printf("\tTên công ty không được để trống\n");
                System.out.printf("\tNhập lại:");
                CongTy = sc.nextLine(); 
        }
        System.out.printf("\tNhập phòng ban :");
        PhongBan= sc.nextLine();
        while (true) {
            if(PhongBan.length()>0 )
                break;
            else
                System.err.printf("\tPhòng ban không được để trống\n");
                System.out.printf("\tNhập lại:");
                PhongBan = sc.nextLine(); 
        }
        System.out.printf("\tNhập chức vụ :");
        ChucVu= sc.nextLine();
        while (true) {
            if(ChucVu.length()>0 )
                break;
            else 
                System.err.printf("\tChức vụ không được để trống\n");
                System.out.printf("\tNhập lại:");
                ChucVu = sc.nextLine(); 
        }
        
        while (true) {
            try {
                System.out.printf("\tNhập hệ số lương:");
                HeSoLuong = sc.nextInt();
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số:");
                  sc.nextLine();
            }
        }  
        
        while (true) {
            try {
                System.out.printf("\tNhập số lượng cv trong tháng:");
                SoCongViecTrongThang = sc.nextInt();
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số:");
                  sc.nextLine();
            }
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
        StringBuilder builder = new StringBuilder();
        builder.append((String.format(this.MaNv)));
        builder.append("\t|");
        builder.append((String.format("%5s",this.TenNv)));
        builder.append("\t|");
        builder.append((String.format("%10s",this.GioiTinh)));
        builder.append("\t|");
        builder.append((String.format("%10s",this.NgaySinh)));
        builder.append("\t|");
        builder.append((String.format("%10s", this.QueQuan)));
        builder.append("\t|");
        builder.append((String.format("%10s", this.CongTy)));
        builder.append("\t|");
        builder.append((String.format("%10s", this.PhongBan)));
        builder.append("\t|");
        builder.append((String.format("%10s", this.ChucVu)));
        builder.append("\t|");
        builder.append((String.format("%10s", this.HeSoLuong)));
        builder.append("\t|");
        builder.append((String.format("%10s", this.SoCongViecTrongThang)));
        builder.append("\t|");
        builder.append((String.format("%10s", this.calculateBonus())));
        builder.append("\t|");
        builder.append((String.format("%10s", this.calculateSalary())));
        
        
        System.out.printf(builder.toString());
    }

    @Override
    public double calculateBonus() {
        if(SoCongViecTrongThang >= 5 && SoCongViecTrongThang < 7){
            return 2000;
        }else if(SoCongViecTrongThang >= 7 && SoCongViecTrongThang < 10){
            return 5000;
        }else if(SoCongViecTrongThang >= 10){
            return 10000;
        }
        return 0;
    }

    @Override
    public double calculateSalary() {
        return basicSalay * HeSoLuong + calculateBonus();
    }
    
}
